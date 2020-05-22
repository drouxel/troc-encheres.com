package fr.eni.trocEncheres.bo;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author MATTHIEU
 *Classe permettant de crrer une vente
 */
public class Vente {

	@Override
	public String toString() {
		return "Vente [noVente=" + noVente + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateFinEnchere=" + dateFinEnchere + ", miseAPrix=" + miseAPrix + ", prixVente=" + prixVente
				+ ", categorie=" + categorie + ", retrait=" + retrait + ", vendeur=" + vendeur + ", acheteur="
				+ acheteur + "]";
	}

	// variable vente
	private int noVente;
	private String nomArticle;
	private String description;
	private LocalDate dateFinEnchere;
	private int miseAPrix;
	private int prixVente;
	private Categorie categorie;
	private Retrait retrait;
	private Utilisateur vendeur;
	private Utilisateur acheteur;
	private String image;
	private Date dateFinEnchereAffichage;
	
	
	/**
	 * @return the dateFinEnchereAffichage
	 */
	public Date getDateFinEnchereAffichage() {
		return Date.from(this.getDateFinEnchere().atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 
	 */
	public Vente() {
	}

	/**
	 * @param nomArticle
	 * @param description
	 * @param dateFinEnchere
	 * @param miseAPrix
	 */
	public Vente(String nomArticle, String description, LocalDate dateFinEnchere, int miseAPrix) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
	}
	
	/**
	 * @param noVente
	 * @param nomArticle
	 * @param description
	 * @param dateFinEnchere
	 * @param miseAPrix
	 * @param prixVente
	 * @param categorie
	 * @param retrait
	 * @param acheteur
	 * @param vendeur
	 * @param image
	 */
	public Vente(int noVente,String nomArticle, String description, LocalDate dateFinEnchere, int miseAPrix, int prixVente, Categorie categorie,
			Retrait retrait, Utilisateur acheteur,Utilisateur vendeur, String image) {
		super();
		this.noVente = noVente;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.setPrixVente(prixVente);
		this.categorie = categorie;
		this.retrait = retrait;
		this.acheteur = acheteur;
		this.vendeur= vendeur;
		this.setImage(image);
	}
	
	/**
	 * @param nomArticle
	 * @param description
	 * @param dateFinEnchere
	 * @param miseAPrix
	 * @param categorie
	 * @param retrait
	 * @param acheteur
	 * @param vendeur
	 */
	public Vente(String nomArticle, String description, LocalDate dateFinEnchere, int miseAPrix, Categorie categorie,
			Retrait retrait, Utilisateur acheteur,Utilisateur vendeur) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
		this.retrait = retrait;
		this.acheteur = acheteur;
		this.vendeur= vendeur;
	}

	/**
	 * @param nomArticle
	 */
	public Vente(String nomArticle) {
		super();
		this.nomArticle = nomArticle;
	}

	/**
	 * @param noVente
	 * @param nomArticle
	 * @param description
	 * @param dateFinEnchere
	 * @param miseAPrix
	 * @param categorie
	 * @param retrait
	 */
	public Vente(int noVente, String nomArticle, String description, LocalDate dateFinEnchere, int miseAPrix, Categorie categorie, Retrait retrait) {
		this.noVente = noVente;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = miseAPrix;
		this.categorie = categorie;
		this.retrait = retrait;
	}
	
	/**
	 * @return
	 */
	public int getNoVente() {
		return noVente;
	}
	
	/**
	 * @param noVente
	 */
	public void setNoVente(int noVente) {
		this.noVente = noVente;
	}
	
	/**
	 * @return
	 */
	public String getNomArticle() {
		return nomArticle;
	}
	
	/**
	 * @param nomArticle
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**dateFinEnchere	
	 * 	 
	 * @return
	 */
	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}
	
	/**
	 * @param dateFinEnchere
	 */
	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}
	
	/**miseAPrix
	 * @return
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	/**
	 * @param miseAPrix
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}	
	
	/**categorie
	 * @return
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	
	/**
	 * @param categorie
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/**retrait
	 * @return
	 */
	public Retrait getRetrait() {
		return retrait;
	}
	
	/**
	 * @param retrait
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	/**vendeur
	 * @return
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}
	
	/**
	 * @param vendeur
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	
	/**acheteur
	 * @return
	 */
	public Utilisateur getAcheteur() {
		return acheteur;
	}
	
	/**
	 * @param acheteur
	 */
	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	/**prixVente
	 * @return
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	/**image
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
}