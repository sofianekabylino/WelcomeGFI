package mywebapp.persistance.dao;

import java.util.Map;

import mywebapp.exceptions.DAOException;

/**
 * Interface qui regroupe les operations sur la base de données pour les
 * commandes.
 */
public interface ICommandeDAO {

	/**
	 * Creer une commande dans la base de donnees
	 * 
	 * @param idProduit
	 * @param quantite
	 * @throws DAOException
	 */
	void creerCommandeBDD(Map<Integer, Integer> panier) throws DAOException;

}
