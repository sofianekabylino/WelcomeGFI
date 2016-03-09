package mywebapp.services;

import java.util.Map;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.dao.ICommandeDAO;
import mywebapp.utils.MyFactory;

/**
 * Classe qui contient l'implementation des methodes de l'interface
 * ICommandeServices pour les operations sur les commandes.
 */
public class CommandeServices implements ICommandeServices {

	private static ICommandeServices instance = new CommandeServices();

	/**
	 * Constructeur private pour construir le singleton.
	 */
	private CommandeServices() {
		// Constructeur vide
	}

	public static ICommandeServices getInstance() {
		return instance;
	}

	@Override
	public void creerCommande(final Map<Integer, Integer> panier) throws DAOException {
		ICommandeDAO commandeDAO = (ICommandeDAO) MyFactory.getInstance(ICommandeDAO.class);
		commandeDAO.creerCommandeBDD(panier);
	}
}
