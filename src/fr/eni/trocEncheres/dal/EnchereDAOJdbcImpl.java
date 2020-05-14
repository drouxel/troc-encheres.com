package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.bo.Vente;

class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String INSERT_ENCHERE ="INSERT INTO encheres(date_enchere, credit, no_utilisateur, no_vente) "
			+ "VALUES(?,?,?,?)";
	private static final String UPDATE_ENCHERE ="UPDATE encheres SET date_enchere = ?, credit = ? "
			+ "WHERE no_utilisateur = ? AND no_vente = ?";
	private static final String DELETE_ENCHERE ="";
	private static final String DELETE_ENCHERES ="";
	private static final String GET_ACQUISITIONS ="";
	private static final String GET_ENCHERES ="";

	@Override
	public void ajouterEnchere(Enchere e) throws BusinessException {
		if(e == null) {
			throw new BusinessException("veuillez renseigner une enchère");
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
				throw new BusinessException(ex.getMessage());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new BusinessException(ex.getMessage());
		}
	}

	@Override
	public void supprimerEnchere(int noUtilisateur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerEncheres(int noVente) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getEncheres(int noVente) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
