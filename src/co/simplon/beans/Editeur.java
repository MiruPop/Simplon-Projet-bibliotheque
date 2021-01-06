package co.simplon.beans;

public class Editeur {
	private int id_editeur;
	private String nom;
	
	public Editeur() {
		super();
	}

	public int getId_editeur() {
		return id_editeur;
	}
	public void setId_editeur(int id_editeur) {
		this.id_editeur = id_editeur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

//	@Override
//	public String toString() {
//		return nom;
//	}
	
}
