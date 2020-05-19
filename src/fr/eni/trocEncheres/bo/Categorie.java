package fr.eni.trocEncheres.bo;
/**
 * classe permettant de définir des catégories d'objet pouvant être troqués sur le site.
 * @author damien
 *
 */
public class Categorie {
	private int noCategorie;
	private String libelle;
	/**
	 * constructeur prenant en paramêtre le libellé de la catégorie
	 * @param libelle
	 */
	public Categorie(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * constructeur vide permettant l'hydratation des infos après traitement 
	 */
	public Categorie() {
	}
	/**
	 * @return le numéro de la catégorie
	 */
	public int getNoCategorie() {
		return noCategorie;
	}
	/**
	 * @param numéro attribué à la catégorie
	 */
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	/**
	 * @return le libellé associé à la catégorie
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * permet de définir le libellé associé à la catégorie
	 * @param le libellé associé à la catégorie
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
