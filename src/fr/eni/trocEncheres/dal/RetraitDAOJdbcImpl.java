package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Retrait;

class RetraitDAOJdbcImpl implements RetraitDAO {
	private static final String GET_ADRESSE = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?";
	private static final String GET_RETRAIT = "SELECT * FROM retraits WHERE no_vente = ?";
	private static final String INSERT_RETRAIT = "INSERT INTO retraits (no_vente, rue, code_postal, ville) VALUES (?,?,?,?)";

	@Override
	public Retrait getAdresseUtilisateur(int id) throws BusinessException {
		BusinessException BExc = new BusinessException();
		Retrait r = new Retrait();
		try {
			Connection cnx=ConnecteurBDD.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(GET_ADRESSE);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				r.setRue(rs.getString("rue"));
				r.setCodePostal(rs.getString("code_postal"));
				r.setVille(rs.getString("ville"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);;
		}
		return r;
	}

	@Override
	public void ajouterRetrait(Retrait retrait) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if(retrait.getNoVente()==0) {
			BExc.ajouterErreur("le retrait n'est pas associé à une vente");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_RETRAIT);
				pstmt.setInt(1, retrait.getNoVente());
				pstmt.setString(2, retrait.getRue());
				pstmt.setString(3, retrait.getCodePostal());
				pstmt.setString(4, retrait.getVille());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				cnx.rollback();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
		}
	}

	@Override
	public Retrait getRetrait(int noVente) throws BusinessException {
		BusinessException BExc = new BusinessException();
		Retrait r = new Retrait();
		try {
			Connection cnx=ConnecteurBDD.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(GET_RETRAIT);
			pstmt.setInt(1, noVente);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				r.setNoVente(rs.getInt("no_vente"));
				r.setRue(rs.getString("rue"));
				r.setCodePostal(rs.getString("code_postal"));
				r.setVille(rs.getString("ville"));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
		}
		return r;
	}

}
