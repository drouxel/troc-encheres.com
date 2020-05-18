package fr.eni.trocEncheres.bo;

import java.time.LocalDate;

/**
 * @author MATTHIEU
 *Classe permettant de creer des enchères.
 */
public class Enchere {
	private Utilisateur encherisseur;
	private Vente vente;
	private LocalDate dateEnchere;
	private int credit;
	
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
	public Enchere(Utilisateur encherisseur, Vente vente, LocalDate dateEnchere, int credit) {
		this.encherisseur = encherisseur;
		this.vente = vente;
		this.dateEnchere = dateEnchere;
		this.credit = credit;
	}
	
	/**
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
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
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	
	/**
	 * 
	 * @param dateEnchere
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [encherisseur=" + encherisseur + ", vente=" + vente + ", dateEnchere=" + dateEnchere
				+ ", credit=" + credit + "]";
	}
}
