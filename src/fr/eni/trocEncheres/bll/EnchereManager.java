package fr.eni.trocEncheres.bll;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.EnchereDAO;

/**
 * @author MATTHIEU Ajouter, Supprimer une enchère
 */
public class EnchereManager {

	// singleton
	private static EnchereManager instance;

	public static EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

	// Attribut(s)
	EnchereDAO daoEnchere = DAOFactory.getEnchereDAO();

	/**
	 * Constructeur par défaut
	 */
	public EnchereManager() {
		daoEnchere = DAOFactory.getEnchereDAO();
	}

	/**
	 * Methode permettant d'ajouter une enchère
	 * 
	 * @throws BusinessException
	 */
	public void ajouterEnchere(Enchere e) throws BusinessException {
		BusinessException BExc = new BusinessException();

		// ajoute une enchère si la date est correcte et si le montant l'est aussi
		try {
			if (dateIsValideEnchere(e) && montantIsValideEnchere(e)) {
				daoEnchere.ajouterEnchere(e);
			} else {
				throw BExc;
			}
		} catch (BusinessException e2) {
			BExc.ajouterErreur("Erreur lors de l'ajout de l'ench�re.");
		}
	}

	/**
	 * Methode permettant de supprimer une enchère
	 * 
	 * @throws BusinessException
	 */
	public void supprimerEnchere(Enchere e) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoEnchere.supprimerEnchere(e);
		} catch (BusinessException e1) {
			BExc.ajouterErreur("Erreur lors de la suppression");
		}
	}

	/**
	 * Methode permettant de supprimer une enchère
	 * 
	 * @throws BusinessException
	 */
	public void supprimerEnchere(int noVente) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoEnchere.supprimerEncheres(noVente);
		} catch (BusinessException e) {
			BExc.ajouterErreur("Erreur lors de la suppression");
		}
	}

//	public void enchereTerminee()

	/**
	 * Fonction qui vérifie la date de l'enchère
	 * 
	 * @param e
	 * @return
	 * @throws BusinessException
	 */
	private boolean dateIsValideEnchere(Enchere e) throws BusinessException {
		BusinessException BExc = new BusinessException();
		// Permet de vérifier le créneau des dates
		if (e.getDateEnchere().isAfter(e.getVente().getDateFinEnchere())) {
			BExc.ajouterErreur("Erreur de date");
			throw BExc;
		} else {
			return true;
		}
	}

	/**
	 * Fonction qui vérifie le montant de l'enchère
	 * 
	 * @param e
	 * @return
	 * @throws BusinessException
	 */
	private boolean montantIsValideEnchere(Enchere e) throws BusinessException {
		BusinessException BExc = new BusinessException();
		// Si les crésit sont égal à 0, alors pas d'enchère
		if (e.getCredit() == 0) {
			BExc.ajouterErreur("Erreur de prix");
			throw BExc;
		} else {
			return true;
		}
	}

	/**
	 * Fonction permettant de lister des encheres liées à une vente (la liste est
	 * triée par ordre décroissant de la meilleure offre à la moins bonne)
	 * 
	 * @param noVente
	 * @return
	 * @throws BusinessException
	 */
	public List<Enchere> getEncheres(int noVente) throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoEnchere.getEncheres(noVente);
		} catch (BusinessException e) {
			BExc.ajouterErreur("Erreur de r�cup�ration des ench�res li�es � la vente.");
		}
		return daoEnchere.getEncheres(noVente);
	}

	/**
	 * Fonction permettant de lister des encheres
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public List<Enchere> getEncheres() throws BusinessException {
		BusinessException BExc = new BusinessException();
		try {
			daoEnchere.getEncheres();
		} catch (BusinessException e) {
			BExc.ajouterErreur("Erreur de r�cup�ration des ench�res.");
		}
		return daoEnchere.getEncheres();
	}
}
