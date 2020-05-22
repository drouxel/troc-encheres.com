package fr.eni.trocEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Vente;
/**
 * Implémentation de l'interface VanteDAO
 * @author damien
 *
 */
class VenteDAOJdbcImpl implements VenteDAO {
	public static final String INSERT_VENTE = "INSERT INTO ventes "
			+ "(nom_article, description, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
			+ " VALUES(?,?,?,?,?,?,?)";
	private static final String GET_VENTES_BY_USER = "SELECT * FROM ventes WHERE no_utilisateur = ?";
	private static final String GET_VENTES_BY_NOM = "SELECT * FROM ventes WHERE nom_article like ? ";
	private static final String GET_VENTES_BY_CATEGORIE = "SELECT * FROM ventes WHERE no_categorie = ?";
	private static final String GET_VENTE_BY_NO = "SELECT * FROM ventes WHERE no_vente = ?";
	private static final String GET_VENTES = "SELECT * FROM ventes";

	@Override
	public Vente ajouterVente(Vente v) throws BusinessException {
		BusinessException BExc = new BusinessException();
		if (v == null) {
			BExc.ajouterErreur("Veuillez renseigner une vente.");
		}
		System.out.println(v.toString());
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				cnx.setAutoCommit(false);
				PreparedStatement pstmt = cnx.prepareStatement(INSERT_VENTE, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, v.getNomArticle());
				pstmt.setString(2, v.getDescription());
				pstmt.setDate(3, Date.valueOf(v.getDateFinEnchere()));
				pstmt.setInt(4, v.getMiseAPrix());
				pstmt.setNull(5, Types.INTEGER);
				pstmt.setInt(6, v.getVendeur().getNoUtilisateur());
				pstmt.setInt(7, v.getCategorie().getNoCategorie());
				pstmt.executeUpdate();
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
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
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return v;
	}

	@Override
	public List<Vente> getVentesUtilisateur(int noUtilisateur) throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<Vente> ventes = new ArrayList<Vente>();
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		CategorieDAO cat = DAOFactory.getCategorieDAO();
		RetraitDAO rDAO = DAOFactory.getRetraitDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_VENTES_BY_USER);
				pstmt.setInt(1, noUtilisateur);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Vente v = new Vente();
					v.setNoVente(rs.getInt("no_vente"));
					v.setNomArticle(rs.getString("nom_article"));
					v.setDescription(rs.getString("description"));
					v.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
					v.setMiseAPrix(rs.getInt("prix_initial"));
					v.setPrixVente(rs.getInt("prix_vente"));
					v.setVendeur(user.getUtilisateur(rs.getInt("no_utilisateur")));
					v.setCategorie(cat.getCategorieById(rs.getInt("no_categorie")));
					v.setRetrait(rDAO.getRetrait(v.getNoVente()));
					ventes.add(v);
				}
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}

		return ventes;
	}

	@Override
	public List<Vente> getVentesByNom(String nom) throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<Vente> ventes = new ArrayList<Vente>();
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		CategorieDAO cat = DAOFactory.getCategorieDAO();
		RetraitDAO rDAO = DAOFactory.getRetraitDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_VENTES_BY_NOM);
				pstmt.setString(1, "%" + nom + "%");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Vente v = new Vente();
					v.setNoVente(rs.getInt("no_vente"));
					v.setNomArticle(rs.getString("nom_article"));
					v.setDescription(rs.getString("description"));
					v.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
					v.setMiseAPrix(rs.getInt("prix_initial"));
					v.setPrixVente(rs.getInt("prix_vente"));
					v.setVendeur(user.getUtilisateur(rs.getInt("no_utilisateur")));
					v.setCategorie(cat.getCategorieById(rs.getInt("no_categorie")));
					v.setRetrait(rDAO.getRetrait(v.getNoVente()));
					ventes.add(v);
				}
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}

		return ventes;
	}

	@Override
	public List<Vente> getVentesByCategorie(int noCategorie) throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<Vente> ventes = new ArrayList<Vente>();
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		CategorieDAO cat = DAOFactory.getCategorieDAO();
		RetraitDAO rDAO = DAOFactory.getRetraitDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_VENTES_BY_CATEGORIE);
				pstmt.setInt(1, noCategorie);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Vente v = new Vente();
					v.setNoVente(rs.getInt("no_vente"));
					v.setNomArticle(rs.getString("nom_article"));
					v.setDescription(rs.getString("description"));
					v.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
					v.setMiseAPrix(rs.getInt("prix_initial"));
					v.setPrixVente(rs.getInt("prix_vente"));
					v.setVendeur(user.getUtilisateur(rs.getInt("no_utilisateur")));
					v.setCategorie(cat.getCategorieById(rs.getInt("no_categorie")));
					v.setRetrait(rDAO.getRetrait(v.getNoVente()));
					ventes.add(v);
				}
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return ventes;
	}

	@Override
	public Vente getVente(int noVente) throws BusinessException {
		BusinessException BExc = new BusinessException();
		Vente v = new Vente();
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		CategorieDAO cat = DAOFactory.getCategorieDAO();
		RetraitDAO rDAO = DAOFactory.getRetraitDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
				PreparedStatement pstmt = cnx.prepareStatement(GET_VENTE_BY_NO);
				pstmt.setInt(1, noVente);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					v.setNoVente(rs.getInt("no_vente"));
					v.setNomArticle(rs.getString("nom_article"));
					v.setDescription(rs.getString("description"));
					v.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
					v.setMiseAPrix(rs.getInt("prix_initial"));
					v.setPrixVente(rs.getInt("prix_vente"));
					v.setVendeur(user.getUtilisateur(rs.getInt("no_utilisateur")));
					v.setCategorie(cat.getCategorieById(rs.getInt("no_categorie")));
					v.setRetrait(rDAO.getRetrait(v.getNoVente()));
				}
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
				throw BExc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return v;
	}

	public List<Vente> getVentes() throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<Vente> ventes = new ArrayList<Vente>();
		UtilisateurDAO user = DAOFactory.getUtilisateurDAO();
		CategorieDAO cat = DAOFactory.getCategorieDAO();
		RetraitDAO rDAO = DAOFactory.getRetraitDAO();
		try {
			Connection cnx = ConnecteurBDD.getConnection();
			try {
			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(GET_VENTES);
			while (rs.next()) {
				Vente v = new Vente();
				v.setNoVente(rs.getInt("no_vente"));
				v.setNomArticle(rs.getString("nom_article"));
				v.setDescription(rs.getString("description"));
				v.setDateFinEnchere(rs.getDate("date_fin_encheres").toLocalDate());
				v.setMiseAPrix(rs.getInt("prix_initial"));
				v.setPrixVente(rs.getInt("prix_vente"));
				v.setVendeur(user.getUtilisateur(rs.getInt("no_utilisateur")));
				v.setCategorie(cat.getCategorieById(rs.getInt("no_categorie")));
				v.setRetrait(rDAO.getRetrait(v.getNoVente()));
				ventes.add(v);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_TRAITEMENT);
			throw BExc;
		}
		} catch (SQLException e) {
			e.printStackTrace();
			BExc.ajouterErreur(ExceptionsDAL.BDD_ERREUR_CONNEXION);
			throw BExc;
		}
		return ventes;
	}

}
