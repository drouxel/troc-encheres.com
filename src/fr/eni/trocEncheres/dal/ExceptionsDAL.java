package fr.eni.trocEncheres.dal;
/**
 * classe abstraite permettant d'avoir une remontée uniforme des erreurs liées à la DAL
 * @author Ludo
 *
 */
public abstract class ExceptionsDAL {
	public static final String BDD_ERREUR_CONNEXION = "Probl�me de connexion � la base de donn�es.";
	public static final String BDD_ERREUR_TRAITEMENT = "Erreur de traitement au niveau de la base de donn�es.";
}
