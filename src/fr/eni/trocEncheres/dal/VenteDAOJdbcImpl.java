package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Vente;

class VenteDAOJdbcImpl implements VenteDAO {
	public static final String INSERT_VENTE = "INSERT INTO ventes "
			+ "(nom_article, description, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ " VALUES(?,?,?,?,?,?,?)";
	public static final String GET_VENTES_BY_USER = "";
	public static final String GET_VENTES_BY_NOM = "";
	public static final String GET_VENTES_BY_CATEGORIE = "";
	public static final String GET_VENTE_BY_NO = "";

	@Override
	public Vente ajouterVente(Vente v) throws BusinessException {
		if(v == null) {
			throw new BusinessException("veuillez renseigner une vente");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_VENTE,PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, v.getNomArticle());
				pstmt.setString(2, v.getDescription());
				pstmt.setDate(3, Date.valueOf(v.getDateFinEnchere()));
				pstmt.setInt(4, v.getMiseAPrix());
				pstmt.setNull(5, Types.INTEGER);
				pstmt.setInt(6, v.getVendeur().getNoUtilisateur());
				pstmt.setInt(7, v.getCategorie().getNoCategorie());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					v.setNoVente(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				v.getRetrait().setNoVente(v.getNoVente());
				RetraitDAO rDAO = new RetraitDAOJdbcImpl();
				rDAO.ajouterRetrait(v.getRetrait());
				cnx.commit();
			} catch (Exception e) {
				cnx.rollback();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return v;
	}

	@Override
	public List<Vente> getVentesUtilisateur(int noUtilisateur) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vente> getVentesByNom(String nom) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vente> getVentesByCategorie(int noCategorie) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Vente getVente(int noVente) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
