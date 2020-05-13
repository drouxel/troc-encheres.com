package fr.eni.trocEncheres.bll;

import fr.eni.trocEncheres.dal.DAOFactory;
import fr.eni.trocEncheres.dal.UtilisateurDAO;
import fr.eni.trocEncheres.dal.UtilisateurDAOJdbcImpl;

public class CategorieManager {
	//singleton
	private static CategorieManager instance;
	
	public static CategorieManager getInstance() {
		if(instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
	
}
