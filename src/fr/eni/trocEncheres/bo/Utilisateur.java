package fr.eni.trocEncheres.bo;

/**
 * class permettant de creer des utilisateurs
 * @author MATTHIEU
 *
 */
public class Utilisateur {
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String mail;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private String prenom;
	private boolean admin;
	
	/**
	 * Constructeur surchargé
	 * @param pseudo
	 * @param nom
	 * @param mail
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param prenom
	 * @param admin
	 */
	public Utilisateur(String pseudo, String nom, String mail, String telephone, String rue, String codePostal, String ville,
			String motDePasse, int credit, String prenom, boolean admin) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.mail = mail;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.prenom = prenom;
		this.setAdmin(admin);
	}

	/**
	 * Constructeur surchargé
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param mail
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param prenom
	 * @param admin
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String mail, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, String prenom, boolean admin) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.mail = mail;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.setCredit(credit);
		this.setPrenom(prenom);
		this.setAdmin(admin);
	}	
	
	/**
	 * Constructeur vide 
	 */
	public Utilisateur() {
	}	

	/**
	 * Constructeur pseudo
	 * @param pseudo
	 */
	public Utilisateur(String pseudo) {
		super();
		this.pseudo = pseudo;
	}

	/**
	 * 
	 * @return  noUtilisateur
	 */
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	
	/**
	 * 
	 * @param noUtilisateur
	 */
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	/**
	 * 
	 * @return pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	/**
	 * 
	 * @param pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	/**
	 * 
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * 
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * 
	 * @return rue
	 */
	public String getRue() {
		return rue;
	}
	
	/**
	 * 
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	/**
	 * 
	 * @return codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	
	/**
	 * 
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	/**
	 * 
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}
	
	/**
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	/**
	 * 
	 * @return motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	
	/**
	 * 
	 * @param motDePasse
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/**
	 * 
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}
	
	/**
	 * 
	 * @param credit
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	@Override
	/**
	 * methode toString de utilisateur
	 */
	public String toString() {
		return "utilisateur [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", mail=" + mail
				+ ", telephone=" + telephone + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", motDePasse=" + motDePasse + "]";
	}
	
	/**
	 * 
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * 
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return le statut administrateur
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * permet de modifier le droit administrateur d'un utilisateur
	 * @param admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
