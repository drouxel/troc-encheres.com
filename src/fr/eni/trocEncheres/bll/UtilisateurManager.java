package fr.eni.trocEncheres.bll;

import java.util.List;
import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Utilisateur;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.UtilisateurDAO;

/**
 * Ajouter, Supprimer, gerer un utilisateur
 * @author MATTHIEU
 *@author Ludo -> gestion des exceptions
 */
public class UtilisateurManager {
	
	//singleton
	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
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
		BusinessException BExc = new BusinessException();
		//Attribut(s)
		boolean isValide = true;
		
		isValide = verifAjouterUtil(u, isValide);
		
		// insertion de l'utilisateur si tout les 'isValide' sont à 'true'
		try {
			if(isValide) {
				daoUtilisateur.ajouterUtilisateur(u);
			}
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de l'insertion");
		}
	}

	private boolean verifAjouterUtil(Utilisateur u, boolean isValide) throws BusinessException {
		BusinessException BExc = new BusinessException();
		// vérifier que tous les champs de saisies soit tous remplis
		if(u == null) {
			isValide = false;
			BExc.ajouterErreur("Utilisateur null");
			throw BExc;
		}if (u.getPseudo().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Pseudo est obligatoire !");
			throw BExc;
		}if (u.getNom().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Nom est obligatoire !");
			throw BExc;
		}if (u.getPrenom().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Pr�nom est obligatoire !");
			throw BExc;
		}if (u.getMail().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Email est obligatoire !");
			throw BExc;
		}if (u.getRue().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Rue est obligatoire !");
			throw BExc;
		}if (u.getCodePostal().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Code Postal est obligatoire !");
			throw BExc;
		}if (u.getVille().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Ville est obligatoire !");
			throw BExc;
		}if (u.getMotDePasse().trim().length() == 0) {
			isValide = false;
			BExc.ajouterErreur("Le champ Mot de Passe est obligatoire !");
			throw BExc;
		}
		return isValide;
	}
	
	/**
	 * Permet de modifier l'utilisateur
	 * @param u
	 * @throws BusinessException
	 */
	public void modifierUtilisateur(Utilisateur u) throws BusinessException {
		BusinessException BExc = new BusinessException();
		boolean isValide = true;
		
				isValide = verifAjouterUtil(u, isValide);
				
				// vérifie que 'isValide' soit 'true' avant de modifier
				try {
					if(isValide) {
						daoUtilisateur.modifierUtilisateur(u);
					}
				} catch (BusinessException e) {
					BExc.ajouterErreur("Echec de la mise � jour");
					throw BExc;
				}
	}
	
	/**
	 * Permet de suppirmer un utilisateur
	 * @param no_utilisateur
	 * @throws BusinessException
	 */
	public void supprimerUtilisateur(int no_utilisateur) throws BusinessException{
		BusinessException BExc = new BusinessException();
		try {
			daoUtilisateur.supprimerUtilisateur(no_utilisateur);			
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de la suppression");
			throw BExc;
		}
	}
	
	/**
	 * Permet de connecter un utilisateur avec son login et mot de passe
	 * @param login
	 * @param motDePasse
	 * @throws BusinessException
	 */
	public Utilisateur connecterUtilisateur(String login, String motDePasse) throws BusinessException {
		BusinessException BExc = new BusinessException();
		Utilisateur u = null;
		try {
			u = daoUtilisateur.connecterUtilisateur(login, motDePasse);			
		} catch (BusinessException e) {
			BExc.ajouterErreur("Erreur lors de la connexion");
			throw BExc;
		}
		return u;
	}
	
	/**
	 * méthode permettant de modifier utilisateur présent dans la base de données.
	 * @param u
	 * @throws BusinessException
	 */
	public void gererUtilisateur(Utilisateur u) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoUtilisateur.gererUtilisateur(u);			
		} catch (BusinessException e) {
			BExc.ajouterErreur("Echec de la modification de l'utilisateur.");
			throw BExc;
		}
	}
	
	public List<String> getPseudos() throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoUtilisateur.getPseudos();
		} catch (BusinessException e) {
			BExc.ajouterErreur("Erreur de r�cup�ration du pseudo.");
			throw BExc;
		}
		return daoUtilisateur.getPseudos();
	}
	
	public List<String> getMails() throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoUtilisateur.getMails();
		} catch (BusinessException e) {
			BExc.ajouterErreur("Erreur de r�cup�ration de l'adresse e-mail.");
			throw BExc;
		}
		return daoUtilisateur.getMails();
	}
	
	public Utilisateur getUtilisateurById(int noUtilisateur) throws BusinessException{
		return daoUtilisateur.getUtilisateur(noUtilisateur);
	}
}












