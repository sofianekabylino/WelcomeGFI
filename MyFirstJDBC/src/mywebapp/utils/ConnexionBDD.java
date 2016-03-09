package mywebapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import mywebapp.exceptions.DAOException;

public class ConnexionBDD {

	private static Connection connexion = null;

	/**
	 * constructeur priv� pour construir un singleton
	 */
	private ConnexionBDD() {
		// Constructeur vide
	}

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/welcomegfi", "root", "Sofiane");
		} catch (final ClassNotFoundException e) {
			throw new RuntimeException("Drivers MySQL indisponibles." + e.getMessage());
		} catch (final SQLException e) {
			throw new RuntimeException("Connexion � la base de donn�es impossible." + e.getMessage());
		}
		return connexion;
	}

	public static void fermerConnexion(final Connection connection) throws DAOException {
		if (connexion != null) {
			try {
				connexion.close();
			} catch (final SQLException e) {
				e.printStackTrace();
				throw new DAOException("Echec de la fermeture de la connexion", e.getCause());
			}
		}
	}
}
