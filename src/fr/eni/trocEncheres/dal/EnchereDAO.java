package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.bo.Vente;

public interface EnchereDAO {
	void ajouterEnchere(Enchere e) throws BusinessException;
	void supprimerEnchere(int noUtilisateur)throws BusinessException;
	void supprimerEncheres(int noVente)throws BusinessException;
	List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException;
	List<Enchere> getEncheres(int noVente) throws BusinessException;
}
