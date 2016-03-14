package mywebapp.services;

import java.util.Map;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.exceptions.DAOException;

/**
 * Interface qui regroupe les services concernant les operations sur les
 * commandes.
 */
public interface ICommandeServices {

	/**
	 * Creer une commande
	 * @param panier
	 * @throws DAOException
	 */
	void creerCommande(Map<Integer, Integer> panier, Map<Integer, ProduitDTO> catalogue) throws DAOException;
}
