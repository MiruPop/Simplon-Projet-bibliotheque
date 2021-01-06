package co.simplon.beans;

import java.time.LocalDate;

public class Emprunt {
	private int idPret;
	private Exemplaire exemplaire;
	private Adherent adherent;
	private LocalDate datePret;
	private LocalDate dateRetour;
	
	public Emprunt() {
		super();
	}
	
	
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public int getIdPret() {
		return idPret;
	}
	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}
	public LocalDate getDatePret() {
		return datePret;
	}
	public void setDatePret(LocalDate datePret) {
		this.datePret = datePret;
	}
	public LocalDate getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}
}
