package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.bo.Vente;

public interface EnchereDAO {
	void ajouterEnchere(Enchere e) throws BusinessException;
	void annulerEnchere(int idAcquereur)throws BusinessException;
	void annulerVente(int noVente, int no_utilisateur)throws BusinessException;
	void faireEnchere(Enchere e) throws BusinessException;
	List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException;
}
