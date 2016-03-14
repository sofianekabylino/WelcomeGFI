package mywebapp.persistance.dao;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.data.CommandeDO;

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
	void creerCommandeBDD(CommandeDO commandeDO) throws DAOException;

}
