package mywebapp.persistance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.persistance.data.ProduitDO;
import mywebapp.utils.ConnexionBDD;

public class ProduitDAO implements IProduitDAO {

	private static IProduitDAO instance = new ProduitDAO();

	/**
	 * Constructeur priv� pour construir un singleton
	 */
	private ProduitDAO() {
		// Constructeur vide
	}

	public static IProduitDAO getInstance() {
		return instance;
	}

	@Override
	public void creerProduitBDD(final ProduitDTO produit) {
		ProduitDO produitDO = new ProduitDO(produit.getIdProduit(), produit.getNomProduit(), produit.getPrixProduit());
		Connection connection = ConnexionBDD.getConnection();
		String requete = "INSERT INTO produit VALUES (" + produitDO.getId() + ",'" + produitDO.getLibelle() + "',"
				+ produitDO.getPrix() + ")";
		try {
			Statement stmt = connection.createStatement();
			int nbMaj = stmt.executeUpdate(requete);
			System.out.println("nb mise a jour = " + nbMaj);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void recupereCatalogueBDD() {
		Connection connection = ConnexionBDD.getConnection();
		String requete = "SELECT * FROM produit";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()){
				int id = rs.getInt("id");
				String libelle = rs.getString("libelle");
				float prix = rs.getFloat("prix");
				
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		
	}

}
