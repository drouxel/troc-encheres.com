package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Utilisateur;
/**
 * Implémentation de l'interface UtilisateurDAO
 * @author damien
 *
 */
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
	private static final String GET_PSEUDOS = "SELECT pseudo FROM utilisateurs";
	private static final String GET_MAILS = "SELECT email FROM utilisateurs";
	private static final String GET_TELS = "SELECT telephone FROM utilisateurs";

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur u) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if (u==null) {
			BExc.ajouterErreur("vous devez cr�er un utilisateur pour pouvoir l'ajouter � la base de donn�es");
			throw BExc;
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
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur("BDD_MAUVAISE_CONNEXION");				
			throw BExc;
		}
		return u;
	}

	@Override
	public void modifierUtilisateur(Utilisateur u) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if (u==null) {
			BExc.ajouterErreur("pas d'information concernant l'utilisateur � modifier");
			throw BExc;
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
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
	}

	@Override
	public void gererUtilisateur(Utilisateur u) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if (u==null) {
			BExc.ajouterErreur("Vous devez cr�er un utilisateur pour pouvoir l'ajouter � la base de donn�es.");
			throw BExc;
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
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
	}

	@Override
	public Utilisateur connecterUtilisateur(String login, String motDePasse) throws BusinessException {
		BusinessException BExc = new BusinessException();
		Utilisateur u = new Utilisateur();
		if (login==null || motDePasse==null) {
			throw new BusinessException("Vous devez saisir votre login et votre mot de passe.");
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
					BExc.ajouterErreur("combinaison login/mot de passe inconnue");
					throw BExc;
				}
			} catch (Exception e) {
				e.printStackTrace();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return u;
	}

	@Override
	public void supprimerUtilisateur(int id) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if (id==0) {
			BExc.ajouterErreur("vous devez cr�er un utilisateur pour pouvoir l'ajouter �la base de donn�es");
			throw BExc;
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
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
	}

	@Override
	public Utilisateur getUtilisateur(int id) throws BusinessException {
		BusinessException BExc = new BusinessException();
		
		Utilisateur u = new Utilisateur();
		if (id==0) {
			BExc.ajouterErreur("Aucun utilisateur identifi�.");
		}
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_USER);
				pstmt.setInt(1, id);
				ResultSet rs = null;
				rs = pstmt.executeQuery();
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
					BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
					throw BExc;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return u;
	}

	@Override
	public List<String> getPseudos() throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<String> logins = new ArrayList<String>();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(GET_PSEUDOS);
				while(rs.next()) {
					logins.add(rs.getString("pseudo"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return logins;
	}

	@Override
	public List<String> getMails() throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<String> mails = new ArrayList<String>();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(GET_MAILS);
				while(rs.next()) {
					mails.add(rs.getString("email"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return mails;
	}

	@Override
	public List<String> getTelephones() throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<String> tels = new ArrayList<String>();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				Statement stmt = cnx.createStatement();
				ResultSet rs = stmt.executeQuery(GET_TELS);
				while(rs.next()) {
					if(rs.getString("telephone")!=null) {
						tels.add(rs.getString("telephone"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return tels;
	}

}
