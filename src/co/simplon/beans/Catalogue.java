package co.simplon.beans;

public class Catalogue {
	private int idCatalogue;
	private Livre livre;
	private String nomCatalogue;
	
	public Catalogue() {
		super();
	}
	
	
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public int getIdCatalogue() {
		return idCatalogue;
	}
	public void setIdCatalogue(int idCatalogue) {
		this.idCatalogue = idCatalogue;
	}
	public String getNomCatalogue() {
		return nomCatalogue;
	}
	public void setNomCatalogue(String nom) {
		this.nomCatalogue = nom;
	}
}
