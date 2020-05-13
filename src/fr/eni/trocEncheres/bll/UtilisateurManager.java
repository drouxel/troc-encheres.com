package fr.eni.trocEncheres.bll;

import java.sql.ResultSet;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.dal.DAOFactory;
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
	
	//Attribut(s)
	UtilisateurDAO daoUtilisateur = DAOFactory.getUtilisateurDAO();
	
	
	/**
	 * Constructeur de la classe objet
	 */
	public UtilisateurManager() {
		super();
	}
	
//	/**
//	 * Recupere le No de l'utilisateur
//	 * @param pseudo
//	 * @return
//	 * @throws BusinessException
//	 */
//	public int selectNoUtilisateur(String pseudo) throws BusinessException  {
//		int noUtilisateur = 0;
//		
//		try {
//			noUtilisateur = daoUtilisateur.ajouterUtilisateur(pseudo);
//		} catch (BusinessException e) {
//			throw new BusinessException("echec selection No utilisateur");
//		}
//		
//		return noUtilisateur;
//	}
	
	
	/**
	 * Permet d'ajouter un utilisateur à la base de donné
	 * @param utilisateur
	 * @throws BusinessException
	 */
	public void ajouterUtilisateur(Utilisateur u) throws BusinessException {
		//Attribut(s)
		boolean valide = true;
		
		// vérifier que tous les champs de saisies soit tous remplis
		if(u == null) {
			valide = false;
			throw new BusinessException("Utilisateur null");
		}if (u.getPseudo().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Pseudo est obligatoire !");
		}if (u.getNom().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Nom est obligatoire !");
		}if (u.getPrenom().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Prénom est obligatoire !");
		}if (u.getMail().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Email est obligatoire !");
		}if (u.getRue().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Rue est obligatoire !");
		}if (u.getCodePostal().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Code Postal est obligatoire !");
		}if (u.getVille().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Ville est obligatoire !");
		}if (u.getMotDePasse().trim().length() == 0) {
			valide = false;
			throw new BusinessException("Le champs Mot de Passe est obligatoire !");
		}
		
		// vérifie que le pseudo choisit ne soit pas déja dans la BDD
		try {
//			if(daoUtilisateur.ajouterUtilisateur() != 0) {
//				valide = false;
//				throw new BusinessException("Le pseudo entré, est déja utilisé");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// insertion de l'utilisateur si tout les 'valide' sont à 'true'
		try {
			if(valide) {
				daoUtilisateur.ajouterUtilisateur(u);
			}
		} catch (BusinessException e) {
			throw new BusinessException("Echec de l'insertion");
		}
	}
	
	
}












