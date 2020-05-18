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
}
