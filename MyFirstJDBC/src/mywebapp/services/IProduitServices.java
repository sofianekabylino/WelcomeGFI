package mywebapp.services;

import java.util.Map;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.exceptions.DAOException;

/**
 * Interface qui regroupe les operations qui s effectues sur les produits.
 */
public interface IProduitServices {

	/**
	 * M�thode qui permet de r�cup�rer la liste des produits du catalogue
	 * 
	 * @return liste des produits avec leur cl�
	 * @throws DAOException
	 */
	Map<Integer, ProduitDTO> recupererCatalogue() throws DAOException;

	/**
	 * M�thode qui permet de cr�er un produit et le rajouter dans le catalogue
	 * 
	 * @param id
	 * @param nom
	 * @param prix
	 * @throws DAOException
	 */
	void creerProduit(int id, String nom, double prix) throws DAOException;

}