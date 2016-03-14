package mywebapp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnexionSession {

	final static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	/**
	 * constructeur privé pour construir un singleton
	 */
	private ConnexionSession() {
		// Constructeur vide
	}

	public static SessionFactory getConnection() {
		return sessionFactory;
	}
	
	public static void fermerConnexionSession(final SessionFactory sf) {
		sf.close();
	}
	
}
