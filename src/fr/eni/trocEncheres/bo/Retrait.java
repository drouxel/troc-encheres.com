package fr.eni.trocEncheres.bo;

public class Retrait {
	private int noVente;
	private String rue;
	private String codePostal;
	private String ville;
	
	/**
	 * Constructeur vide
	 */
	public Retrait() {
	}
	
	/**
	 * Constructeur
	 * @param rue
	 */
	public Retrait(String rue) {
		this.rue = rue;
	}

	public Retrait(int noVente, String rue, String codePostal, String ville) {
		this.noVente = noVente;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNoVente() {
		return noVente;
	}

	public void setNoVente(int noVente) {
		this.noVente = noVente;
	}

	@Override
	public String toString() {
		return "Retrait [noVente=" + noVente + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}
}
