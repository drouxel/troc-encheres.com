package fr.eni.trocEncheres.bll;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.EnchereDAO;

/**
 * @author MATTHIEU
 *Ajouter, Supprimer une enchère
 */
public class EnchereManager {

	//singleton
		private static EnchereManager instance;
		
		public static EnchereManager getInstance()throws BusinessException {
			if(instance == null) {
				instance = new EnchereManager();
			}
			return instance;
		}
	
	//Attribut(s)
		EnchereDAO daoEnchere = DAOFactory.getEnchereDAO();
	
		/**
		 * Constructeur par défaut
		 */
		public EnchereManager() {
			daoEnchere = DAOFactory.getEnchereDAO();
		}
		
	/**
	 * Methode permettant d'ajouter une enchère
	 * @throws BusinessException
	 */
	public void ajouterEnchere(Enchere e) throws BusinessException {
		dateIsValideEnchere(e);
		montantIsValideEnchere(e);
		
		//ajoute une enchère si la date est correcte et si le montant l'est aussi
		try {
			if (dateIsValideEnchere(e) || montantIsValideEnchere(e)){
				daoEnchere.ajouterEnchere(e);					
			}
		} catch (BusinessException e2) {
			throw new BusinessException("Erreur lors de l'ajout de l'enchère.");
		}
	}
	
	/**
	 * Methode permettant de supprimer une enchère
	 * @throws BusinessException
	 */
	public void supprimerEnchere() throws BusinessException {
		
	}
	
	/**
	 * Fonction qui vérifie la date de l'enchère
	 * @param e
	 * @return 
	 * @throws BusinessException
	 */
	private boolean dateIsValideEnchere(Enchere e) throws BusinessException {
		// Permet de vérifier le créneau des dates
		// manque getDateDebutEnchere() code à rajouter à la suite :
		// || e.getDateEnchere().isAfter(e.getVente().get)
		if (e.getDateEnchere().isAfter(e.getVente().getDateFinEnchere())) {
			throw new BusinessException("Erreur de date");
		}else {
			return true;
		}
		
		
	}
	
	/**
	 * Fonction qui vérifie le montant de l'enchère
	 * @param e
	 * @return 
	 * @throws BusinessException
	 */
	private boolean montantIsValideEnchere(Enchere e) throws BusinessException {
		// Si les crésit sont égal à 0, alors pas d'enchère
		if (e.getCredit() == 0) {
				throw new BusinessException("Erreur de prix");
		}else {
			return true;
		}
	}
	
}
