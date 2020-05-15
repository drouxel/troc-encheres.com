package fr.eni.trocEncheres.dal;
/**
 * Factory permettant de récupérer des instances d'objet de type Data Acces Object 
 * pour pouvoir intervenir sur la base de données sans se soucier de l'implémentation
 * qui se cache derrière pour les autres couches du projet
 * @author damien
 *
 */
public abstract class DAOFactory {
	/**
	 * fonction qui retourne un objet de la classe abstraite EnchereDAO 
	 * permettant de manipuler la table encheres de la base de données
	 * @return EnchereDAO avec implémentation correspondant à la base de données
	 */
	public static EnchereDAO getEnchereDAO() {
		return new EnchereDAOJdbcImpl();
	}
	/**
	 * fonction qui retourne un objet de la classe abstraite RetraitDAO 
	 * permettant de manipuler la table Retrait de la base de données
	 * @return RetraitDAO avec implémentation correspondant à la base de données
	 */
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOJdbcImpl();
	}
	/**
	 * fonction qui retourne un objet de la classe abstraite UtilisateurDAO 
	 * permettant de manipuler la table utilisateurs de la base de données
	 * @return UtilisateurDAO avec implémentation correspondant à la base de données
	 */
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	/**
	 * fonction qui retourne un objet de la classe abstraite VenteDAO 
	 * permettant de manipuler la table ventes de la base de données
	 * @return VenteDAO avec implémentation correspondant à la base de données
	 */
	public static VenteDAO getVenteDAO() {
		return new VenteDAOJdbcImpl();
	}
	/**
	 * fonction qui retourne un objet de la classe abstraite CategorieDAO 
	 * permettant de manipuler la table categories de la base de données
	 * @return CategorieDAO avec implémentation correspondant à la base de données
	 */
	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
	}
}
