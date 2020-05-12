package fr.eni.trocEncheres.bll;

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
