package fr.eni.trocEncheres.dal;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Retrait;
/**
 * interface permettant de créer une base commune aux différentes implémentations liées à la base de données
 * @author damien
 *
 */
public interface RetraitDAO {
	/**
	 * cette methode permet de récupérer l'adresse de retrait pour l'enchère 
	 * si elle est définie par le vendeur comme étant l'adresse qu'il a renseignée dans son profil. 
	 * @param id
	 * @return
	 * @throws BusinessException
	 */
	public Retrait getAdresseUtilisateur(int id) throws BusinessException;
	/**
	 * cette methode permet d'ajouter l'adresse du retrait associé à une vente
	 * @param retrait 
	 * @param noVente 
	 * @throws BusinessException
	 */
	public void ajouterRetrait(Retrait retrait, int noVente) throws BusinessException;
	/**
	 * 
	 * @param noVente
	 * @return un Retrait associé au numéro de vente renseigné
	 * @throws BusinessException
	 */
	public Retrait getRetrait(int noVente) throws BusinessException;
}
