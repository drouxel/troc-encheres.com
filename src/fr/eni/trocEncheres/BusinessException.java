package fr.eni.trocEncheres;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> listeErreurs;
	
	public BusinessException() {
		super();
		this.listeErreurs=new ArrayList<String>();
	}
	
	/**
	 * 
	 * @param code Code de l'erreur. 
	 * Doit avoir un message associé dans un fichier properties.
	 */
	public void ajouterErreur(String code)
	{
		if(!this.listeErreurs.contains(code))
		{
			this.listeErreurs.add(code);
		}
	}
	
	public boolean hasErreurs()
	{
		return this.listeErreurs.size()>0;
	}
	
	public List<String> getListeCodesErreur()
	{
		return this.listeErreurs;
	}
}
