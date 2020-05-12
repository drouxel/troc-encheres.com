package fr.eni.trocEncheres.dal;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;

public interface EnchereDAO {
	void ajouterEnchere(Enchere e) throws BusinessException;
//	void annulerEnchere(int idAcquereur)throws BusinessException;
//	void annulerVente(int noVente, int no_utilisateur)throws BusinessException;
	
}
