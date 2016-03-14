package mywebapp.persistance.dao;

import java.util.List;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.data.ProduitDO;

/**
 * Interface qui regroupe les operations sur la base de donn�es pour les
 * produits.
 */
public interface IProduitDAO {

	/**
	 * M�thode qui p�rmet la cr�ation d'un produit dans la base de donn�es
	 * 
	 * @param produit
	 *            .
	 * @throws DAOException
	 */
	void creerProduitBDD(ProduitDO produit) throws DAOException;

	/**
	 * M�thode qui p�rmet de r�cuperer la liste des peroduits dans la base de
	 * donn�es.
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