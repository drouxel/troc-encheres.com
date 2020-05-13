package fr.eni.trocEncheres.bll;

import java.sql.ResultSet;

import javax.management.Query;

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
		
	
	
	/**
	 * Permet d'ajouter un utilisateur à la base de donné
	 * @param utilisateur
	 * @throws BusinessException
	 */
	public void ajouterUtilisateur(Utilisateur u) throws BusinessException {
		//Attribut(s)
		boolean isValide = true;
		
		// vérifier que tous les champs de saisies soit tous remplis
		if(u == null) {
			isValide = false;
			throw new BusinessException("Utilisateur null");
		}if (u.getPseudo().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Pseudo est obligatoire !");
		}if (u.getNom().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Nom est obligatoire !");
		}if (u.getPrenom().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Prénom est obligatoire !");
		}if (u.getMail().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Email est obligatoire !");
		}if (u.getRue().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Rue est obligatoire !");
		}if (u.getCodePostal().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Code Postal est obligatoire !");
		}if (u.getVille().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Ville est obligatoire !");
		}if (u.getMotDePasse().trim().length() == 0) {
			isValide = false;
			throw new BusinessException("Le champs Mot de Passe est obligatoire !");
		}
		
		// insertion de l'utilisateur si tout les 'isValide' sont à 'true'
		try {
			if(isValide) {
				daoUtilisateur.ajouterUtilisateur(u);
			}
		} catch (BusinessException e) {
			throw new BusinessException("Echec de l'insertion");
		}
	}
	
	
	
	/**
	 * Permet de modifier l'utilisateur
	 * @param u
	 * @throws BusinessException
	 */
	public void modifierUtilisateur(Utilisateur u) throws BusinessException {
		boolean isValide = true;
		
				// vérifier que tous les champs de saisies soit tous remplis
				if(u == null) {
					isValide = false;
					throw new BusinessException("Utilisateur null");
				}if (u.getPseudo().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Pseudo est obligatoire !");
				}if (u.getNom().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Nom est obligatoire !");
				}if (u.getPrenom().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Prénom est obligatoire !");
				}if (u.getMail().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Email est obligatoire !");
				}if (u.getRue().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Rue est obligatoire !");
				}if (u.getCodePostal().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Code Postal est obligatoire !");
				}if (u.getVille().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Ville est obligatoire !");
				}if (u.getMotDePasse().trim().length() == 0) {
					isValide = false;
					throw new BusinessException("Le champs Mot de Passe est obligatoire !");
				}
				
				// vérifie que 'isValide' soit 'true' avant de modifier
				try {
					if(isValide) {
						daoUtilisateur.modifierUtilisateur(u);
					}
				} catch (BusinessException e) {
					throw new BusinessException("Echec de la mise à jour");
				}
	}
	
	
	
	/**
	 * Permet de suppirmer un utilisateur
	 * @param no_utilisateur
	 * @throws BusinessException
	 */
	public void supprimerUtilisateur(int no_utilisateur) throws BusinessException{
		// supprime l'utilisateur par son no_utilisateur
		try {
			daoUtilisateur.supprimerUtilisateur(no_utilisateur);			
		} catch (BusinessException e) {
			throw new BusinessException("Echec de la suppression");
		}
	}
	
	
}












