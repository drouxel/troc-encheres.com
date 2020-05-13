package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Categorie;

public interface CategorieDAO {
	public List<Categorie> getCategories()throws BusinessException ;
	public Categorie getCategorieById(int id)throws BusinessException ;
	public Categorie ajouterCategorie(Categorie categorie)throws BusinessException ;
	public void supprimerCategorie(int id)throws BusinessException ;
}
