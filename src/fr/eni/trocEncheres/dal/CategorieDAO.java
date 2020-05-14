package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Categorie;
/**
 * Classe permettant d'interagir avec la table categories de la base de données
 * @author damien
 *
 */
public interface CategorieDAO {
	/**
	 * fonction qui permet de récupérer une liste de catégories enregistrées en base de données
	 * @return liste d'objets Categorie sous forme d'ArrayList
	 * @throws BusinessException
	 */
	public List<Categorie> getCategories()throws BusinessException ;
	/**
	 * fonction que permet de récupérer une catégorie en passant le numéro qui lui est associé en paramètre
	 * @param id = le numéro correspondant à la catégorie
	 * @return la catégorie correspondant au numéro passé en paramètre
	 * @throws BusinessException
	 */
	public Categorie getCategorieById(int id)throws BusinessException ;
	/**
	 * fonction qui permet d'ajouter une catégorie dans la base de données, 
	 * elle ne devrait être utilisée que par des utilisateurs qui ont la qualité d'administrateur
	 * @param categorie avec un libellé renseigné et un noCategorie à null
	 * @return la Categorie avec le numéro que la base de données lui aura attribué
	 * @throws BusinessException
	 */
	public Categorie ajouterCategorie(Categorie categorie)throws BusinessException ;
	/**
	 * méthode permettant de supprimer une Categorie de la base de données,
	 * elle ne devrait être utilisée que par des utilisateurs qui ont la qualité d'administrateur
	 * @param id
	 * @throws BusinessException
	 */
	public void supprimerCategorie(int id)throws BusinessException ;
}
