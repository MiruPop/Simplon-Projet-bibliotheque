package co.simplon.dao;

import java.sql.*;

import javax.servlet.ServletContext;

import co.simplon.beans.Adherent;

public class DaoContext {
	
	//je définis les paramètres de connexion à mon serveur de Base de données
	
	protected static String url;
	protected static String username;
	protected static String password;
	protected static String driver;

	
	public static void init( ServletContext context ) {

		try {
			driver = context.getInitParameter( "JDBC_DRIVER" );
			url = context.getInitParameter( "JDBC_URL" );
			username = context.getInitParameter( "JDBC_LOGIN" );
			password = context.getInitParameter( "JDBC_PASSWORD" );
		} catch( Exception exception ) {
			exception.printStackTrace();
		}
	}
	
	//je charge le Driver pour MySQL et je créé la connexion à la BDD, avec les propriétés fournies plus haut
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(driver);
		} catch( Exception exception ) {
			exception.printStackTrace();
			}
		Connection connexion = DriverManager.getConnection(url, username, password);
		System.out.println("Connexion faite");
		return connexion;
		}

	/*j'accède à mon AdherentDAO plutôt en passant par l'interface
	Ca me permet, si jamais j'ai d'autres méthodes dans AdherentDAO,
	de n'appliquer que les méthodes définies dans l'interface. Par contre, si j'ai une méthode
	spécifique à cette classe, et je veux l'appliquer, je déclare plutôt un objet du type de la classe (ici AdherentDAO)*/
	//ça me permet de mieux bénéficier de la généricité et de créer des classes de type Interface qui peuvent facilement communiquer entre elles
	
	public AdherentDAO getAdherentDao() {
		
		AdherentDAO objAdherent = new AdherentDaoImpl(this);
		return objAdherent;
//		return new AdherentDAO(this);
	}
}
