package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Vente;

/**
 * interface permettant de créer une base commune aux différentes implémentations liées à la base de données
 * @author damien
 *
 */
public interface VenteDAO {
	/**
	 * fonction qui permet d'ajouter une vente à la base de données et qui renvoie cette vente avec le numéro qui lui a été attribué par la base de données
	 * @param vente à ajouter dans la base de données
	 * @return cette même vente avec son numéro qui aura été déterminé par la bdd
	 * @throws BusinessException
	 */
	public Vente ajouterVente(Vente v) throws BusinessException;
	/**
	 * fonction qui retourne une liste de ventes créées par un utilisateur donné
	 * @param numéro de l'utilisateur dont on souhaite afficher les ventes
	 * @return une liste des ventes créées par cet utilisateur
	 * @throws BusinessException
	 */
	public List<Vente> getVentesUtilisateur(int noUtilisateur) throws BusinessException;
	/**
	 * fonction qui retourne une liste de ventes correspondant au mot clé renseigné
	 * @param mot-clé 
	 * @return liste de ventes contenant ce mot-clé dans leur nom
	 * @throws BusinessException
	 */
	public List<Vente> getVentesByNom(String nom) throws BusinessException;
	/**
	 * fonction qui retourne une liste de ventes associées à une catégorie donnée
	 * @param le numéro de la catégorie concernée
	 * @return liste des ventes répertoriées dans cette catégorie
	 * @throws BusinessException
	 */
	public List<Vente> getVentesByCategorie(int noCategorie) throws BusinessException;
	/**
	 * fonction qui permet de récupérer une vente en renseignant son numéro
	 * @param noVente
	 * @return la vente correspondant au numéro passé en paramètre avec tous ses attrubut
	 * @throws BusinessException
	 */
	public Vente getVente(int noVente) throws BusinessException;
	/**
	 * permet de récupérer toutes les ventes enregistrées en base de données
	 * @return une liste des ventes enregistrées en base de données
	 * @throws BusinessException
	 */
	public List<Vente> getVentes() throws BusinessException;
}
