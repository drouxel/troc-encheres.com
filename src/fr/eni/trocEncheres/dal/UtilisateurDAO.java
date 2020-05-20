package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Utilisateur;
/**
 * interface permettant de créer une base commune aux différentes implémentations liées à la base de données
 * @author damien
 *
 */
public interface UtilisateurDAO {
	/**
	 * méthode permettant de créer un nouvel utilisateur et de l'insérer dans la base de données.
	 * @param Utilisateur
	 * @throws BusinessException si un problème survient pendant l'opération avec la base de données.
	 */
	public Utilisateur ajouterUtilisateur(Utilisateur u) throws BusinessException;
	/**
	 * méthode permettant de modifier utilisateur présent dans la base de données.
	 * @param Utilisateur
	 * @throws BusinessException si un problème survient pendant l'opération avec la base de données.
	 */
	public void modifierUtilisateur(Utilisateur u) throws BusinessException;
	/**
	 * méthode permettant de modifier utilisateur présent dans la base de données.
	 * @param Utilisateur
	 * @throws BusinessException si un problème survient pendant l'opération avec la base de données.
	 */
	public void gererUtilisateur(Utilisateur u) throws BusinessException;
	/**
	 * méthode permettant de récupérer l'utilisateur correspondant au login et au mot de passe renseignés sur la page connexion
	 * @param login soit le pseudo, soit l'adresse mail fourni lors de la tentative de connection
	 * @param motDePasse fourni lors de la tentative de connection
	 * @return l'utilisateur correspondant aux paramètres fournis
	 * @throws BusinessException si une erreur survient lors de la tentative de connection
	 */
	public Utilisateur connecterUtilisateur(String login, String motDePasse) throws BusinessException;
	/**
	 * fonction permettant de récupérer un utilisateur enregistré dans la base de données grâce à son numéro
	 * @param id = numéro utilisateur
	 * @return Utilisateur
	 * @throws BusinessException
	 */
	public Utilisateur getUtilisateur(int id) throws BusinessException;
	/**
	 * permet de supprimer un utilisateur renseignant son noUtilisateur.
	 * seul l'utilisateur même est autorisé à réaliser cette opération ou un admistrateur
	 * @param id -> noUtilisateur
	 * @throws BusinessException si une erreur survient ou si la personne n'est pas autorisée à réaliser cette opération
	 */
	public void supprimerUtilisateur(int id) throws BusinessException;
	/**
	 * fonction qui retourne tous les logins enregistrés en base de données
	 * @return tous les logins sous forme de String
	 * @throws BusinessException
	 */
	public List<String> getPseudos() throws BusinessException;
	/**
	 * fonction qui retourne toutes les adresses mail enregistrés en base de données
	 * @return tous les logins sous forme de String
	 * @throws BusinessException
	 */
	public List<String> getMails() throws BusinessException;
	/**
	 * fonction qui retourne tous les numéros de téléphone enregistrés en base de données
	 * @return tous les numéros de téléphone sous forme de String
	 * @throws BusinessException
	 */
	public List<String> getTelephones() throws BusinessException;
}
