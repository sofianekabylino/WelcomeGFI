package mywebapp.persistance.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import mywebapp.exceptions.DAOException;
import mywebapp.utils.ConnexionBDD;

/**
 * Classe qui impl�mente les m�thodes qui p�rmettent de g�rer les int�rractions
 * avec la base de donn�es pour les commandes.
 */
public class CommandeDAO implements ICommandeDAO {

	private static ICommandeDAO instance = new CommandeDAO();

	/**
	 * Constructeur private pour construir le singleton
	 */
	private CommandeDAO() {
		// Constructeur vide
	}

	public static ICommandeDAO getInstance() {
		return instance;
	}

	@Override
	public void creerCommandeBDD(Map<Integer, Integer> panier) throws DAOException {
		final int idCommande = genererId();
		Date aujourdhui = genererDate();

		Connection connection = ConnexionBDD.getConnection();

		String requeteCommande = "INSERT INTO commande VALUES (?, ?)";
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(requeteCommande);
			preparedStatement.setInt(1, idCommande);
			preparedStatement.setDate(2, aujourdhui);
			int nbOperations = preparedStatement.executeUpdate();
			if (nbOperations == 0) {
				throw new DAOException("�chec de la cr�ation de la commande, aucune ligne ajout�e dans la table.");

			}
			System.out.println("nombre de mise a jour = " + nbOperations);
			connection.commit();
		} catch (final SQLException e) {
			try {
				connection.rollback();
			} catch (final SQLException e1) {
				throw new DAOException(e1.getMessage(), e1.getCause());
			}
			e.printStackTrace();
		}
		try {
			connection.setAutoCommit(false);
			for (Integer key : panier.keySet()) {
				String requeteCommandeProduit = "INSERT INTO commande_produit VALUES (?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(requeteCommandeProduit);
				preparedStatement.setInt(1, key);
				preparedStatement.setInt(2, idCommande);
				preparedStatement.setInt(3, panier.get(key));
				int nbMaj = preparedStatement.executeUpdate();
				if (nbMaj == 0) {
					throw new DAOException(
							"�chec de la cr�ation de la quantite de la commande, aucune ligne ajout�e dans la table.");
				}
				System.out.println("nombre de mise a jour = " + nbMaj);
			}
			connection.commit();
		} catch (final SQLException e) {
			try {
				connection.rollback();
			} catch (final SQLException e1) {
				throw new DAOException(e1.getMessage(), e1.getCause());
			}
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			ConnexionBDD.fermerConnexion(connection);
		}
	}

	/**
	 * Methode qui genere un nombre aleatoir pour le stoquer dans la base de
	 * donnee
	 * 
	 * @return valeur aleatoire
	 * @throws DAOException
	 */
	public int genererId() throws DAOException {
		Connection connection = ConnexionBDD.getConnection();
		String requete = "SELECT MAX(id) AS id FROM commande";
		int id = 0;
		try {
			connection.setAutoCommit(false);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			connection.commit();
			if (rs == null) {
				return 1;
			}
			while (rs.next()) {
				id = rs.getInt("id") + 1;
			}
			connection.close();
		} catch (final SQLException e) {
			try {
				connection.rollback();
			} catch (final SQLException e1) {
				throw new DAOException(e1.getMessage(), e1.getCause());
			}
			e.printStackTrace();
		} finally {
			ConnexionBDD.fermerConnexion(connection);
		}
		return id;
	}

	/**
	 * Methode pour recuperer la date d'aujourdhui
	 * 
	 * @return date sql
	 */
	public Date genererDate() {
		final java.util.Date utilDate = new java.util.Date();
		final java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
}
