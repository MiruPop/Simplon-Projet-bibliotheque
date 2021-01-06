package co.simplon.beans;

public class Recherche {
	private int idRecherche;
	private Adherent adherent;
	private Catalogue catalogue;

	public Recherche() {
		super();
	}

	public int getIdRecherche() {
		return idRecherche;
	}

	public void setIdRecherche(int idRecherche) {
		this.idRecherche = idRecherche;
	}

	public Adherent getAdherent() {
		return adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

}
