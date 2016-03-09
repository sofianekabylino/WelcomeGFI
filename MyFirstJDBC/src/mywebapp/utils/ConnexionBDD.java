package mywebapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {

	public static Connection getConnection() {
	    Connection connexion = null;
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
}
