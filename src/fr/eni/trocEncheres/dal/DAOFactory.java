package fr.eni.trocEncheres.dal;

public abstract class DAOFactory {
	public static EnchereDAO getEnchereDAO() {
		return null;
	}
	public static RetraitDAO getRetraitDAO() {
		return null;
	}
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	public static VenteDAO getVenteDAO() {
		return null;
	}
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
}
