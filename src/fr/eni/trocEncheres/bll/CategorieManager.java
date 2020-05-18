package fr.eni.trocEncheres.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Categorie;
import fr.eni.trocEncheres.dal.CategorieDAO;
import fr.eni.trocEncheres.dal.CategorieDAOJdbcImpl;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.UtilisateurDAO;
import fr.eni.trocEncheres.dal.UtilisateurDAOJdbcImpl;

/**
 * @author MATTHIEU
 *Creer, supprimer des catégories.
 */
public class CategorieManager {
	
	//singleton
	private static CategorieManager instance;
	
	public static CategorieManager getInstance()throws BusinessException {
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
		try {
			daoCategorie.ajouterCategorie(categorie);
		} catch (BusinessException e) {
			throw new BusinessException("Echec de l'ajout de la categorie");
		}
	}
	
	/**
	 * Methode permettant de supprimer une categorie
	 * @param categorie
	 * @throws BusinessException
	 */
	public void supprimerCategorie(int id) throws BusinessException {
		try {
			daoCategorie.supprimerCategorie(id);
		} catch (BusinessException e) {
			throw new BusinessException("Echec de suppression de la categorie");
		}
	}
	
	public List<Categorie> getCategories() throws BusinessException{
		List<Categorie> categories = null;
		categories = daoCategorie.getCategories();
		return categories;
	}
	
	public void categorieById(int id) throws BusinessException {
		try { 			
			daoCategorie.getCategorieById(id);
		} catch (BusinessException e) {
			throw new BusinessException("Erreur de catégorie");
		}
	}
	
	
}
