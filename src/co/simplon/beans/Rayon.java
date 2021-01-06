package co.simplon.beans;

public class Rayon {
	private int idRayon;
	private String genre;
	private Exemplaire exemplaire;
	
	public Rayon() {
		super();
	}
	
	public int getIdRayon() {
		return idRayon;
	}
	public void setIdRayon(int idRayon) {
		this.idRayon = idRayon;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Exemplaire getExemplaire() {
		return exemplaire;
	}
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}
}
