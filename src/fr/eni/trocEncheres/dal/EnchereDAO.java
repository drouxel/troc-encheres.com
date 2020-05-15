package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
/**
 * interface permettant de créer une base commune aux différentes implémentations liées à la base de données
 * @author damien
 *
 */
public interface EnchereDAO {
	/**
	 * méthode qui permet d'ajouter une enchere à la base de données
	 * @param l'enchère à ajouter
	 * @throws BusinessException
	 */
	void ajouterEnchere(Enchere e) throws BusinessException;
	/**
	 * méthode qui permet de supprimer une enchere de la base de données
	 * @param l'enchère à supprimer
	 * @throws BusinessException
	 */
	void supprimerEnchere(Enchere e)throws BusinessException;
	/**
	 * méthodes permettant de supprimer les encheres associées à une vente
	 * @param numéro de la vente concernée
	 * @throws BusinessException
	 */
	void supprimerEncheres(int noVente)throws BusinessException;
//	List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException;
	/**
	 * fonction qui renvoie une liste des encheres liées à une vente
	 * la liste est triée par ordre décroissant de la meilleure offre à la moins bonne
	 * @param numéro de la vente concernée
	 * @return
	 * @throws BusinessException
	 */
	List<Enchere> getEncheres(int noVente) throws BusinessException;
}
