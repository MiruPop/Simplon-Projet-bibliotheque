package co.simplon.controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.simplon.beans.Adherent;
import co.simplon.dao.DaoContext;
import co.simplon.dao.AdherentDAO;

/**
 * Servlet implementation class maBibliotheque
 */

//je laisse le nom vide, pour pouvoir décider avec le "switch" quelle action entreprendre
@WebServlet("/")
public class maBibliotheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
//je définis un objet de type Interface, à qui je vais appliquer les methodes de la servlet
	private AdherentDAO adherentDao;
	private DaoContext daoContext;

	//constructeur par défaut
	public maBibliotheque() {
	        super();
	    }

	//lancement de la servlet
	public void init() throws ServletException {
		DaoContext.init(this.getServletContext());
		DaoContext daoContext = new DaoContext();
		adherentDao = daoContext.getAdherentDao();
	}
	

	/*pour pouvoir regrouper toutes les actions avec un "switch", la méthode doGet va renvoyer
	 * toutes les actions qui lui sont propres vers la méthode doPost */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		doPost(request, response);
	}


	/*la méthode doPost va regrouper dans un "switch" toutes les actions possibles
	 * Chaque action appelera une méthode décrite par la suite*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/ficheInscription":
			try {
				ficheVide(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
			break;
		case "/ficheAdherent":
			try {
				ficheModif(request, response);
			} catch (SQLException | ServletException | IOException e) {
				e.printStackTrace();
			}
			break;
		case "/inscrire":
			try {
				inscription(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
			break;
		case "/desinscrire":
			try {
				desinscription(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
			break;
		case "/modifier":
			try {
				modification(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
			break;
		default:
			try {
				listeAdher(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
			break;
		}

	}


	/*la méthode ficheVide renvoit l'utilisateur vers une fiche-adhérent individuelle vide,
	 * définie dans un fichier jsp appart, qui permettra de créer une nouvelle entrée dans la table */
	private void ficheVide(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("fiche-adherent.jsp");
		dispatcher.forward(request, response);
	}

	/*la méthode ficheModif renvoit l'utilisateur vers la fiche-adhérent individuelle, qui reprend
	 * les informations de l'adhérent séléctionné par son matricule, permettant ainsi leur modification */
	private void ficheModif(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int matricule = Integer.parseInt(request.getParameter("matricule"));
		Adherent existant = adherentDao.selectionner(matricule);
		RequestDispatcher dispatcher = request.getRequestDispatcher("fiche-adherent.jsp");
		request.setAttribute("adherent", existant);
		dispatcher.forward(request, response);
	}
	
	/*la méthode listeAdher renvoit l'utilisateur vers la page principale, où sont listés tous les adhérents */
	private void listeAdher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setAttribute("liste", this.adherentDao.lister());
		RequestDispatcher dispatcher = request.getRequestDispatcher("biblio.jsp");
		dispatcher.forward(request, response);
	}
	
	/*la méthode inscription permet de récupérer les informations saisies dans la fiche vide,
	 * pour créer une nouvelle entrée dans la table (requête "insert into"),
	 * puis redirige l'utilisateur vers la page listant tous les adhérents */
	private void inscription(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
				String nomAdh = request.getParameter("nom");	//bien vérifier que le nom du paramètre corréspond bien au name= des inputs
				String prenomAdh = request.getParameter("prenom");
				String ddnAdh = request.getParameter("dateNaiss");
				String adrAdh = request.getParameter("adresse");
				String telAdh = request.getParameter("telephone");
				String categAdh = request.getParameter("categPro");
				String inscrAdh = request.getParameter("dateAdhesion");
				
				Adherent nouvAdherent = new Adherent();
					nouvAdherent.setNom(nomAdh);
					nouvAdherent.setPrenom(prenomAdh);
					nouvAdherent.setDateNaiss(LocalDate.parse(ddnAdh));
					nouvAdherent.setAdresse(adrAdh);
					nouvAdherent.setTelephone(telAdh);
					nouvAdherent.setCategPro(categAdh);
					nouvAdherent.setDateAdhesion(LocalDate.parse(inscrAdh));
				
				adherentDao.ajouter(nouvAdherent);
				response.sendRedirect("liste");
	}

	/*la méthode desinscription récupère la matricule d'un adhérent,
	 * pour executer la requête "delete" */
	private void desinscription(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int matricule = Integer.parseInt(request.getParameter("matricule"));
		adherentDao.retirer(matricule);
		response.sendRedirect("liste");
	}
	
	/*la méthode modification récupère les informations saisies dans la fiche d'un adhérent,
	 * pour modifier ses informations dans la table (requête "update"),
	 * puis redirige l'utilisateur vers la page listant tous les adhérents */
	private void modification(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int matricule = Integer.parseInt(request.getParameter("matricule"));
		String nomAdh = request.getParameter("nom");
		String prenomAdh = request.getParameter("prenom");
		String ddnAdh = request.getParameter("dateNaiss");
		String adrAdh = request.getParameter("adresse");
		String telAdh = request.getParameter("telephone");
		String categAdh = request.getParameter("categPro");
		String inscrAdh = request.getParameter("dateAdhesion");
		
		Adherent adherentExistant = new Adherent();
			adherentExistant.setMatricule(matricule);
			adherentExistant.setNom(nomAdh);
			adherentExistant.setPrenom(prenomAdh);
			adherentExistant.setDateNaiss(LocalDate.parse(ddnAdh));
			adherentExistant.setAdresse(adrAdh);
			adherentExistant.setTelephone(telAdh);
			adherentExistant.setCategPro(categAdh);
			adherentExistant.setDateAdhesion(LocalDate.parse(inscrAdh));
		
		adherentDao.modifier(adherentExistant);
		response.sendRedirect("liste");
	}
}