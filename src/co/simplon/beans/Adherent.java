package co.simplon.beans;

import java.time.LocalDate;

public class Adherent {
	private int matricule;
	private String nom;
	private String prenom;
	private LocalDate dateNaiss;
	private String adresse;
	private String telephone;
	private String categPro;
	private LocalDate dateAdhesion;

	public Adherent() {
		super();
	}

	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(LocalDate dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCategPro() {
		return categPro;
	}
	public void setCategPro(String categPro) {
		this.categPro = categPro;
	}
	public LocalDate getDateAdhesion() {
		return dateAdhesion;
	}
	public void setDateAdhesion(LocalDate dateAdhesion) {
		this.dateAdhesion = dateAdhesion;
	}
}
