package mywebapp.persistance.dao;

import java.util.List;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.data.ProduitDO;

/**
 * Interface qui regroupe les operations sur la base de données pour les
 * produits.
 */
public interface IProduitDAO {

	/**
	 * Méthode qui pérmet la création d'un produit dans la base de données
	 * 
	 * @param produit
	 *            .
	 * @throws DAOException
	 */
	void creerProduitBDD(ProduitDO produit) throws DAOException;

	/**
	 * Méthode qui pérmet de récuperer la liste des peroduits dans la base de
	 * données.
	 * 
	 * @return liste de produitDTO
	 * @throws DAOException
	 */
	List<ProduitDO> recupereCatalogueBDD() throws DAOException;

	/**
	 * Methode qui recupere un element de la base de donnees a partir d'un id
	 * 
	 * @param key
	 * @return ProduitDO
	 * @throws DAOException 
	 */
	ProduitDO recupererProduitBDD(int id) throws DAOException;
}