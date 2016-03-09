package mywebapp.persistance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.data.ProduitDO;
import mywebapp.utils.ConnexionBDD;

/**
 * Classe qui implémente les méthodes qui pérmettent de gérer les intérractions
 * avec la base de données pour les produits.
 */
public class ProduitDAO implements IProduitDAO {

	private static IProduitDAO instance = new ProduitDAO();

	/**
	 * Constructeur prive pour construir un singleton
	 */
	private ProduitDAO() {
		// Constructeur vide
	}

	public static IProduitDAO getInstance() {
		return instance;
	}

	@Override
	public void creerProduitBDD(final ProduitDO produit) throws DAOException {
		Connection connection = ConnexionBDD.getConnection();
		String requete = "INSERT INTO produit VALUES (?,?,?)";
		try {
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setInt(1, produit.getId());
			preparedStatement.setString(2, produit.getLibelle());
			preparedStatement.setDouble(3, produit.getPrix());
			int nbMaj = preparedStatement.executeUpdate(); 
			connection.commit();
			if (nbMaj == 0) {
				throw new DAOException("Échec de la création du produit, aucune ligne ajoutée dans la table.");
			}
			System.out.println("nombre de mise a jour = " + nbMaj);
		} catch (final SQLException e) {
			try {
				connection.rollback();
			} catch (final SQLException e1) {
				throw new DAOException("le rollback de la connexion n'a pas pu s'effectuer", e1.getCause());
			}
			e.printStackTrace();
			throw new DAOException("Échec de la création du produit, aucune ligne ajoutée dans la table.", e.getCause());
		} finally {
			ConnexionBDD.fermerConnexion(connection);
		}
	}

	@Override
	public List<ProduitDO> recupereCatalogueBDD() throws DAOException {
		List<ProduitDO> listeProduits = new ArrayList<ProduitDO>();
		Connection connection = ConnexionBDD.getConnection();
		String requete = "SELECT * FROM produit";
		try {
			connection.setAutoCommit(false);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			connection.commit();
			if (rs == null) {
				throw new DAOException("Echec de recuperation de la liste des produits");
			}
			while (rs.next()) {
				int id = rs.getInt("id");
				String libelle = rs.getString("libelle");
				float prix = rs.getFloat("prix");

				listeProduits.add(new ProduitDO(id, libelle, prix));
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
		return listeProduits;
	}
}