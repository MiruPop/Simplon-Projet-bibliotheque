package co.simplon.beans;

import java.time.LocalDate;

public class Exemplaire extends Livre{
	private int id_exemplaire;
	private Editeur editeur;
	private String anneeEd;
	private LocalDate dateAchat;
	private String codeUsure;

	
	public Exemplaire() {
		super();
	}



	public int getId_exemplaire() {
		return id_exemplaire;
	}
	public void setId_exemplaire(int id_exemplaire) {
		this.id_exemplaire = id_exemplaire;
	}
	public Editeur getEditeur() {
		return editeur;
	}
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}
	public String getAnneeEd() {
		return anneeEd;
	}
	public void setAnneeEd(String anneeEd) {
		this.anneeEd = anneeEd;
	}
	public LocalDate getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}
	public String getCodeUsure() {
		return codeUsure;
	}
	public void setCodeUsure(String codeUsure) {
		this.codeUsure = codeUsure;
	}

	
//	@Override
//	public String toString() {
//		return super.toString()+"\nExemplaire (" + id_exemplaire + "):\nEditeur: " + editeur + ", année edition: " + anneeEd;
//	}
}