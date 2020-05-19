package fr.eni.trocEncheres.bll;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Retrait;
import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.RetraitDAO;

/**
 * @author MATTHIEU
 *Ajouter un retrait
 */
public class RetraitManager {
	//singleton
		private static RetraitManager instance;
		
		public static RetraitManager getInstance() {
			if(instance == null) {
				instance = new RetraitManager();
			}
			return instance;
		}
		
		//Attribut(s)
		RetraitDAO daoRetrait = DAOFactory.getRetraitDAO();
		
		public void ajouterRetrait(Retrait retrait) throws BusinessException {
			BusinessException BExc = new BusinessException();
			try {
				daoRetrait.getRetrait(retrait.getNoVente());
			} catch (BusinessException e) {
				BExc.ajouterErreur("Erreur à l'ajout du retrait.");
			}
			
			//Verifier adresse
		}
		
		/**
		 * Methode qui permet d'ajouter l'adresse du retrait associÃ© Ã  une vente
		 * @param id
		 * @throws BusinessException
		 */
		public void getAdresse(int id) throws BusinessException {
			BusinessException BExc = new BusinessException();
			try {
				daoRetrait.getAdresseUtilisateur(id);				
			} catch (BusinessException e) {
				BExc.ajouterErreur("Erreur de récupération de l'adresse de l'utilisateur.");
			}
			
		}
		
		/**
		 * Retrait associÃ© au numÃ©ro de vente renseignÃ©
		 * @param noVente
		 * @throws BusinessException
		 */
		public void getRetrait(int noVente) throws BusinessException {
			BusinessException BExc = new BusinessException();
			try {
				daoRetrait.getRetrait(noVente);
			} catch (BusinessException e) {
				BExc.ajouterErreur("Erreur de récupération du retrait.");
			}
			
		}
}
