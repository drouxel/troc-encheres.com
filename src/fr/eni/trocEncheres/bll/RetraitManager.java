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
		
		public static RetraitManager getInstance()throws BusinessException {
			if(instance == null) {
				instance = new RetraitManager();
			}
			return instance;
		}
		
		//Attribut(s)
		RetraitDAO daoRetrait = DAOFactory.getRetraitDAO();
		
		public void ajouterRetrait(Retrait retrait) throws BusinessException {
			daoRetrait.getRetrait(retrait.getNoVente());
			//Verifier adresse
		}
		
		/**
		 * Methode qui permet d'ajouter l'adresse du retrait associé à une vente
		 * @param id
		 * @throws BusinessException
		 */
		public void getAdresse(int id) throws BusinessException {
			daoRetrait.getAdresseUtilisateur(id);
		}
		
		/**
		 * Retrait associé au numéro de vente renseigné
		 * @param noVente
		 * @throws BusinessException
		 */
		public void getRetrait(int noVente) throws BusinessException {
			daoRetrait.getRetrait(noVente);
		}
}
