package co.simplon.dao;

import java.util.List;

import co.simplon.beans.Adherent;

public interface AdherentDAO {
	public List<Adherent> lister();
	public void ajouter(Adherent adherent);
	public void retirer (int id);
	public Adherent selectionner(int id);
	public void modifier(Adherent adherent);
}
