package co.simplon.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import co.simplon.beans.Adherent;

public class AdherentDaoImpl implements AdherentDAO {

	private DaoContext daoContext;
	private Connection connexion = null;
	PreparedStatement prepStat = null;

	//on définit une variables pour chaque requette utilisée dans les méthodes
	private static final String insererAdh = "insert into adherent(nom, prenom, dateNaissance, adresse, telephone, categoriePro,dateAdhesion) values(?,?,?,?,?,?,?);";
	private static final String selectAdherParID = "select matricule, nom, prenom, dateNaissance, adresse, telephone, categoriePro,dateAdhesion from minibiblio.adherent where matricule =?";
	private static final String listerAdher = "select * from minibiblio.adherent;";
	private static final String retirerAdher = "delete from minibiblio.adherent where matricule = ?;";
	private static final String modifierAdher = "update minibiblio.adherent set nom=?, prenom=?, dateNaissance=?, adresse=?, telephone=?, categoriePro=?,dateAdhesion=? where matricule = ?;";

	//constructeur
	public AdherentDaoImpl(DaoContext daoContext) {
		this.daoContext = daoContext;
	}

	//méthode pour retourner la liste complète des adhérents
	@Override
	public List<Adherent> lister() {
		List<Adherent> allAdherents = new ArrayList<>();

		Adherent adherent = null;
		ResultSet reponse = null;

		try {
			this.connexion = DaoContext.getConnection();
			prepStat = connexion.prepareStatement(listerAdher);
			reponse = prepStat.executeQuery();

			while (reponse.next()) {
				int matricule = reponse.getInt("matricule");
				String nom = reponse.getString("nom");
				String prenom = reponse.getString("prenom");
				LocalDate dateNaiss = reponse.getObject("dateNaissance", LocalDate.class);
				String adresse = reponse.getString("adresse");
				String telephone = reponse.getString("telephone");
				String categPro = reponse.getString("categoriePro");
				LocalDate dateAdhesion = reponse.getObject("dateAdhesion", LocalDate.class);

				adherent = new Adherent();
				adherent.setMatricule(matricule);
				adherent.setNom(nom);
				adherent.setPrenom(prenom);
				adherent.setDateNaiss(dateNaiss);
				adherent.setAdresse(adresse);
				adherent.setTelephone(telephone);
				adherent.setCategPro(categPro);
				adherent.setDateAdhesion(dateAdhesion);
				
				allAdherents.add(adherent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allAdherents;
	}

	//méthode pour ajouter un nouvel adhérent
	@Override
	public void ajouter(Adherent adherent) {
		try {
			this.connexion = DaoContext.getConnection();
			prepStat = connexion.prepareStatement(insererAdh);
			prepStat.setString(1, adherent.getNom());
			prepStat.setString(2, adherent.getPrenom());
			prepStat.setObject(3, adherent.getDateNaiss());
			prepStat.setString(4, adherent.getAdresse());
			prepStat.setString(5, adherent.getTelephone());
			prepStat.setString(6, adherent.getCategPro());
			prepStat.setObject(7, adherent.getDateAdhesion());
			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//méthode pour retirer un adhérent
	@Override
	public void retirer(int id) {
		try {
			this.connexion = DaoContext.getConnection();
			prepStat = connexion.prepareStatement(retirerAdher);
			prepStat.setInt(1, id);
			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//méthode pour selectionner un adhérent en fonction de son matricule
	@Override
	public Adherent selectionner(int id) {
		Adherent unAdherent = null;

		try {
			this.connexion = DaoContext.getConnection();
			prepStat = connexion.prepareStatement(selectAdherParID);
			prepStat.setInt(1, id);
			ResultSet reponse = prepStat.executeQuery();

			while (reponse.next()) {
				int matricule = reponse.getInt("matricule");
				String nom = reponse.getString("nom");
				String prenom = reponse.getString("prenom");
				LocalDate dateNaiss = reponse.getObject("dateNaissance", LocalDate.class);
				String adresse = reponse.getString("adresse");
				String telephone = reponse.getString("telephone");
				String categPro = reponse.getString("categoriePro");
				LocalDate dateAdhesion = reponse.getObject("dateAdhesion", LocalDate.class);

				unAdherent = new Adherent();
				unAdherent.setMatricule(matricule);
				unAdherent.setNom(nom);
				unAdherent.setPrenom(prenom);
				unAdherent.setDateNaiss(dateNaiss);
				unAdherent.setAdresse(adresse);
				unAdherent.setTelephone(telephone);
				unAdherent.setCategPro(categPro);
				unAdherent.setDateAdhesion(dateAdhesion);
			}
		} catch (SQLException e) {
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unAdherent;
	}
	
	//méthode pour modifier les infos d'un adhérent
	@Override
	public void modifier(Adherent adherent) {
		try {
			this.connexion = DaoContext.getConnection();
			prepStat = connexion.prepareStatement(modifierAdher);
			prepStat.setString(1, adherent.getNom());
			prepStat.setString(2, adherent.getPrenom());
			prepStat.setObject(3, adherent.getDateNaiss());
			prepStat.setString(4, adherent.getAdresse());
			prepStat.setString(5, adherent.getTelephone());
			prepStat.setString(6, adherent.getCategPro());
			prepStat.setObject(7, adherent.getDateAdhesion());
			prepStat.setInt(8, adherent.getMatricule());
			
			prepStat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}