package mywebapp.services;

import java.util.Map;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.exceptions.DAOException;

/**
 * Interface qui regroupe les operations qui s effectues sur les produits.
 */
public interface IProduitServices {

	/**
	 * Méthode qui permet de récupérer la liste des produits du catalogue
	 * 
	 * @return liste des produits avec leur clé
	 * @throws DAOException
	 */
	Map<Integer, ProduitDTO> recupererCatalogue() throws DAOException;

	/**
	 * Méthode qui permet de créer un produit et le rajouter dans le catalogue
	 * 
	 * @param id
	 * @param nom
	 * @param prix
	 * @throws DAOException
	 */
	void creerProduit(int id, String nom, double prix) throws DAOException;

}