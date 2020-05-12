package fr.eni.trocEncheres.bo;

import java.util.Date;

public class Enchere {
	private Utilisateur encherisseur;
	private Vente vente;
	private Date dateEnchere;
	
	/**
	 * Constructeur vide de Enchere
	 */
	public Enchere() {
	}
	
	/**
	 * Constructeur surchargé
	 * @param encherisseur
	 * @param vente
	 * @param dateEnchere
	 */
	public Enchere(Utilisateur encherisseur, Vente vente, Date dateEnchere) {
		this.encherisseur = encherisseur;
		this.vente = vente;
		this.dateEnchere = dateEnchere;
	}
	
	/**
	 * encherisseur
	 * @return
	 */
	public Utilisateur getEncherisseur() {
		return encherisseur;
	}
	
	/**
	 * 
	 * @param encherisseur
	 */
	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}
	
	/**
	 * vente
	 * @return
	 */
	public Vente getVente() {
		return vente;
	}
	
	/**
	 * 
	 * @param vente
	 */
	public void setVente(Vente vente) {
		this.vente = vente;
	}
	
	/**
	 * dateEnchere
	 * @return
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}
	
	/**
	 * 
	 * @param dateEnchere
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
}
