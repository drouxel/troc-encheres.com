package fr.eni.trocEncheres.dal;

public abstract class DAOFactory {
	public EnchereDAO getEnchereDAO() {
		return null;
	}
	public RetraitDAO getRetraitDAO() {
		return null;
	}
	public UtilisateurDAO getUtilisateurDAO() {
		return null;
	}
	public VenteDAO getVenteDAO() {
		return null;
	}
}
