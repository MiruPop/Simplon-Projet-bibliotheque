package co.simplon.beans;

public class Livre{
	private int codeCatalogue;
	private String titre;
	private Auteur auteur;
	
	public Livre() {
	}


	public int getCodeCatalogue() {
		return codeCatalogue;
	}
	public void setCodeCatalogue(int id_livre) {
		this.codeCatalogue = id_livre;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Auteur getAuteur(Auteur auteur) {
		return auteur;
	}
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}


//	@Override
//	public String toString() {
//		return "Titre: " + titre + "\n" + auteur;
//	}
}
