package fr.eni.trocEncheres.bll;

import java.util.List;
import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Categorie;
import fr.eni.trocEncheres.dal.CategorieDAO;
import fr.eni.trocEncheres.dal.DAOFactory;

/**
 * @author MATTHIEU
 *Creer, supprimer des catégories.
 */
public class CategorieManager {
	
	//singleton
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
	//Attribut(s)
	CategorieDAO daoCategorie = DAOFactory.getCategorieDAO();
	
	/**
	 * Constructeur de la classe Objet
	 */
	public CategorieManager() {	
	}
	
	/**
	 * Methode permettant d'ajouter une categorie
	 * @param categorie
	 * @throws BusinessException
	 */
	public void ajouterCategorie(Categorie categorie) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoCategorie.ajouterCategorie(categorie);
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de l'ajout de la categorie");
		}
	}
	
	/**
	 * Methode permettant de supprimer une categorie
	 * @param categorie
	 * @throws BusinessException
	 */
	public void supprimerCategorie(int id) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoCategorie.supprimerCategorie(id);
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de suppression de la categorie");
		}
	}
	
	public List<Categorie> getCategories() throws BusinessException {
		BusinessException BExc = new BusinessException();
		List<Categorie> categories = null;
		try {
			categories = daoCategorie.getCategories();
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de la r�cup�ration des cat�gories.");
			e.printStackTrace();
		}
		return categories;
	}
	
	public void categorieById(int id) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try { 			
			daoCategorie.getCategorieById(id);
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de r�cup�ration de la cat�gorie.");
		}
	}
	
	
}