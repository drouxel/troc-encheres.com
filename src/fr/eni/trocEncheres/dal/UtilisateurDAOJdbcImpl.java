package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private static final String INSERT_USER = "INSERT INTO utilisateurs"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, "
			+ "ville, mot_de_passe, credit, administrateur)"
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_USER = "UPDATE utilisateurs SET "
			+ "pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,"
			+ "ville=?,mot_de_passe=? WHERE no_utilisateur=?";
	private static final String UPD_USER = "UPDATE utilisateurs SET "
			+ "pseudo=?,nom=?,prenom=?,email=?,telephone=?,"
			+ "mot_de_passe=? WHERE no_utilisateur=?";
	private static final String CONNECT_USER = "SELECT * FROM utilisateurs "
			+ "WHERE email = ? OR pseudo = ? "
			+ "AND mot_de_passe = ?";
	private static final String DELETE_USER = "DELETE FROM utilisateurs WHERE no_utilisateur = ?";
	private static final String GET_USER = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?";

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur u) throws BusinessException {
		if (u==null) {
			throw new BusinessException("vous devez créer un utilisateur pour pouvoir l'ajouter à la base de donnée");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, u.getPseudo());
				pstmt.setString(2, u.getNom());
				pstmt.setString(3, u.getPrenom());
				pstmt.setString(4, u.getMail());
				if(u.getTelephone()!= null) {
					pstmt.setString(5, u.getTelephone());
				}else {
					pstmt.setNull(5, Types.VARCHAR );
				}
				pstmt.setString(6, u.getRue());
				pstmt.setString(7, u.getCodePostal());
				pstmt.setString(8, u.getVille());
				pstmt.setString(9, u.getMotDePasse());
				pstmt.setInt(10, 0);
				pstmt.setInt(11, 0);
				pstmt.executeUpdate();
				ResultSet rs;
				rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					u.setNoUtilisateur(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return u;
	}

	@Override
	public void modifierUtilisateur(Utilisateur u) throws BusinessException {
		if (u==null) {
			throw new BusinessException("pas d'information concernant l'utilisateur à modifier");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPDATE_USER);
				pstmt.setString(1, u.getPseudo());
				pstmt.setString(2, u.getNom());
				pstmt.setString(3, u.getPrenom());
				pstmt.setString(4, u.getMail());
				if(u.getTelephone()!=null) {
					pstmt.setString(5, u.getTelephone());
				}else {
					pstmt.setNull(5, Types.VARCHAR);
				}
				pstmt.setString(6, u.getRue());
				pstmt.setString(7, u.getCodePostal());
				pstmt.setString(8, u.getVille());
				pstmt.setString(9, u.getMotDePasse());
				pstmt.setInt(10, u.getNoUtilisateur());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void gererUtilisateur(Utilisateur u) throws BusinessException {
		if (u==null) {
			throw new BusinessException("vous devez créer un utilisateur pour pouvoir l'ajouter à la base de donnée");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(UPD_USER);
				pstmt.setString(1, u.getPseudo());
				pstmt.setString(2, u.getNom());
				pstmt.setString(3, u.getPrenom());
				pstmt.setString(4, u.getMail());
				if(u.getTelephone()!=null) {
					pstmt.setString(5, u.getTelephone());
				}else {
					pstmt.setNull(5, Types.VARCHAR);
				}
				pstmt.setString(6, u.getMotDePasse());
				pstmt.setInt(7, u.getNoUtilisateur());
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Utilisateur connecterUtilisateur(String login, String motDePasse) throws BusinessException {
		Utilisateur u = new Utilisateur();
		if (login==null || motDePasse==null) {
			throw new BusinessException("vous devez saisir votre login et votre mot de passe");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(CONNECT_USER);
				pstmt.setString(1, login);
				pstmt.setString(2, login);
				pstmt.setString(3, motDePasse);
				ResultSet rs = null;
				rs = pstmt.executeQuery();
				System.out.println(rs.toString());
				if(rs.next()) {
					u.setPseudo(rs.getString("pseudo"));
					u.setNom(rs.getString("nom"));
					u.setPrenom(rs.getString("prenom"));
					u.setMail(rs.getString("email"));
					u.setTelephone(rs.getString("telephone"));
					u.setRue(rs.getString("rue"));
					u.setCodePostal(rs.getString("code_postal"));
					u.setVille(rs.getString("ville"));
					u.setMotDePasse(rs.getString("mot_de_passe"));
					u.setCredit(rs.getInt("credit"));
					u.setAdmin(rs.getBoolean("administrateur"));
					u.setNoUtilisateur(rs.getInt("no_utilisateur"));
				}else {
					throw new BusinessException("combinaison login/mot de passe inconnue");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return u;
	}

	@Override
	public void supprimerUtilisateur(int id) throws BusinessException {
		if (id==0) {
			throw new BusinessException("vous devez créer un utilisateur pour pouvoir l'ajouter à la base de donnée");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
				pstmt.close();
				cnx.commit();
			} catch (Exception e) {
				e.printStackTrace();
				cnx.rollback();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Utilisateur getUtilisateur(int id) throws BusinessException {
		Utilisateur u = new Utilisateur();
		if (id==0) {
			throw new BusinessException("aucun utilisateur identifié");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_USER);
				pstmt.setInt(1, id);
				ResultSet rs = null;
				rs = pstmt.executeQuery();
				System.out.println(rs.toString());
				if(rs.next()) {
					u.setPseudo(rs.getString("pseudo"));
					u.setNom(rs.getString("nom"));
					u.setPrenom(rs.getString("prenom"));
					u.setMail(rs.getString("email"));
					u.setTelephone(rs.getString("telephone"));
					u.setRue(rs.getString("rue"));
					u.setCodePostal(rs.getString("code_postal"));
					u.setVille(rs.getString("ville"));
					u.setMotDePasse(rs.getString("mot_de_passe"));
					u.setCredit(rs.getInt("credit"));
					u.setAdmin(rs.getBoolean("administrateur"));
					u.setNoUtilisateur(rs.getInt("no_utilisateur"));
				}else {
					throw new BusinessException("une erreur est survenue lors de la récupération des informations");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new BusinessException(e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		return u;
	}

}
