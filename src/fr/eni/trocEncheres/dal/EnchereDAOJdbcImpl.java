package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Enchere;
import fr.eni.trocEncheres.bo.Vente;

class EnchereDAOJdbcImpl implements EnchereDAO {

	@Override
	public void ajouterEnchere(Enchere e) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void annulerEnchere(int idAcquereur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void annulerVente(int noVente, int no_utilisateur) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void faireEnchere(Enchere e) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
