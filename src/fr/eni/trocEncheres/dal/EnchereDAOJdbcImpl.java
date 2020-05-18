package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;

class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String INSERT_ENCHERE ="INSERT INTO encheres(date_enchere, credit, no_utilisateur, no_vente) "
			+ "VALUES(?,?,?,?)";
	private static final String UPDATE_ENCHERE ="UPDATE encheres SET date_enchere = ?, credit = ? "
			+ "WHERE no_utilisateur = ? AND no_vente = ?";
	private static final String DELETE_ENCHERE ="DELETE FROM encheres WHERE no_utilisateur = ? AND no_vente = ?";
	private static final String DELETE_ENCHERES ="DELETE FROM encheres WHERE no_vente = ?";
//	private static final String GET_ACQUISITIONS ="";
	private static final String GET_ENCHERES_VENTE ="SELECT * FROM encheres WHERE no_vente = ? ORDER BY credit DESC";
	private static final String GET_ENCHERES ="SELECT * FROM encheres GROUP BY no_vente";
	private static final String BDD_MAUVAISE_CONNEXION = "Problème de connexion à la base de données.";
	private static final String BDD_ERREUR_TRAITEMENT = "Erreur de traitement au niveau de la base de données.";

	@Override
	public void ajouterEnchere(Enchere e) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if(e == null) {
			BExc.ajouterErreur("veuillez renseigner une enchère");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
				pstmt.setDate(1, Date.valueOf(e.getDateEnchere()));
				pstmt.setInt(2, e.getCredit());
				pstmt.setInt(3, e.getEncherisseur().getNoUtilisateur());
				pstmt.setInt(4, e.getVente().getNoVente());
				int i = pstmt.executeUpdate();
				if(i==0) {
					pstmt = cnx.prepareStatement(INSERT_ENCHERE);
					pstmt.setDate(1, Date.valueOf(e.getDateEnchere()));
					pstmt.setInt(2, e.getCredit());
					pstmt.setInt(3, e.getEncherisseur().getNoUtilisateur());
					pstmt.setInt(4, e.getVente().getNoVente());
					pstmt.executeUpdate();
				}
				pstmt.close();
				cnx.commit();
			} catch (Exception ex) {
				cnx.rollback();
				BExc.ajouterErreur(BDD_ERREUR_TRAITEMENT);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BExc.ajouterErreur(BDD_MAUVAISE_CONNEXION);
		}
	}

	@Override
	public void supprimerEnchere(Enchere e) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if(e == null) {
			BExc.ajouterErreur("Veuillez renseigner une enchère.");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_ENCHERE);
				pstmt.setInt(1, e.getEncherisseur().getNoUtilisateur());
				pstmt.setInt(2, e.getVente().getNoVente());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) {
				BExc.ajouterErreur(BDD_ERREUR_TRAITEMENT);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BExc.ajouterErreur(BDD_MAUVAISE_CONNEXION);
		}
	}

	@Override
	public void supprimerEncheres(int noVente) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if(noVente==0) {
			BExc.ajouterErreur("veuillez renseigner une vente");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_ENCHERES);
				pstmt.setInt(1, noVente);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception ex) {
				BExc.ajouterErreur(BDD_ERREUR_TRAITEMENT);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BExc.ajouterErreur(BDD_MAUVAISE_CONNEXION);
		}
	}

//	@Override
//	public List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Enchere> getEncheres(int noVente) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if(noVente==0) {
			BExc.ajouterErreur("veuillez renseigner une vente");
		}
		List<Enchere> encheres = new ArrayList<Enchere>();
		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
		VenteDAO vDAO = DAOFactory.getVenteDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_ENCHERES_VENTE);
				pstmt.setInt(1, noVente);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Enchere e = new Enchere();
					e.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
					e.setEncherisseur(uDAO.getUtilisateur(rs.getInt("no_utilisateur")));
					e.setVente(vDAO.getVente(rs.getInt("no_vente")));
					e.setCredit(rs.getInt("credit"));
					encheres.add(e);
				}
				rs.close();
				pstmt.close();
			} catch (Exception ex) {
				BExc.ajouterErreur(BDD_ERREUR_TRAITEMENT);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BExc.ajouterErreur(BDD_MAUVAISE_CONNEXION);
		}
		return encheres;
	}

	@Override
	public List<Enchere> getEncheres() throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<Enchere> encheres = new ArrayList<Enchere>();
		UtilisateurDAO uDAO = DAOFactory.getUtilisateurDAO();
		VenteDAO vDAO = DAOFactory.getVenteDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(GET_ENCHERES);
				while(rs.next()) {
					Enchere e = new Enchere();
					e.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
					e.setEncherisseur(uDAO.getUtilisateur(rs.getInt("no_utilisateur")));
					e.setVente(vDAO.getVente(rs.getInt("no_vente")));
					e.setCredit(rs.getInt("credit"));
					encheres.add(e);
				}
				rs.close();
				stmt.close();
			} catch (Exception ex) {
				BExc.ajouterErreur(BDD_ERREUR_TRAITEMENT);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			BExc.ajouterErreur(BDD_MAUVAISE_CONNEXION);
		}
		return encheres;
	}

}
