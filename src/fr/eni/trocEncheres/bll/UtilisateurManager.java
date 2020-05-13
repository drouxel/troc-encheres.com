package fr.eni.trocEncheres.bll;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.dal.UtilisateurDAO;

public class UtilisateurManager {
	
	//singleton
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
	//Attributs
	private UtilisateurDAO utilisateurDAO;
	private static final int CHAMPS_VARCHAR_30 = 30;
	private static final int CHAMPS_VARCHAR_20 = 20;
	private static final int CHAMPS_VARCHAR_15 = 15;
	private static final int CHAMPS_VARCHAR_10 = 10;
	
	
	/**
	 * 
	 * @param utilisateur
	 * @throws BusinessException
	 */
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException{
		validerChamps(utilisateur.getPseudo(), CHAMPS_VARCHAR_30);
	}
	
	
}
