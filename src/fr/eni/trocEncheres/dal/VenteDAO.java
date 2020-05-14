package fr.eni.trocEncheres.dal;

import java.util.List;

import fr.eni.trocEncheres.BusinessException;
import fr.eni.trocEncheres.bo.Vente;

/**
 * interface permettant de créer une base commune aux différentes implémentations liées à la base de données
 * @author damien
 *
 */
public interface VenteDAO {
	public void ajouterVente() throws BusinessException;
	public List<Vente> getVentesUtilisateur(int noUtilisateur) throws BusinessException;
	public List<Vente> getVentesByNom(String nom) throws BusinessException;
	public List<Vente> getVentesByCategorie(int noCategorie) throws BusinessException;
	public List<Vente> getAcquisitions(int noUtilisateur) throws BusinessException;
	public Vente getVente(int noVente) throws BusinessException;
}
