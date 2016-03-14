package mywebapp.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.exceptions.DAOException;
import mywebapp.persistance.dao.ICommandeDAO;
import mywebapp.persistance.dao.IProduitDAO;
import mywebapp.persistance.data.CommandeDO;
import mywebapp.persistance.data.CommandeProduitDO;
import mywebapp.persistance.data.ProduitDO;
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
	public void creerCommande(final Map<Integer, Integer> panier, final Map<Integer, ProduitDTO> catalogue) throws DAOException {
		final ICommandeDAO commandeDAO = (ICommandeDAO) MyFactory.getInstance(ICommandeDAO.class);
		final IProduitDAO produitDAO = (IProduitDAO) MyFactory.getInstance(IProduitDAO.class);
		final Set<CommandeProduitDO> listeCommandeProduitDO = new HashSet<CommandeProduitDO>();
		for (Integer key : panier.keySet()) {
			ProduitDO produitDO = produitDAO.recupererProduitBDD(key);
			CommandeProduitDO commandeProduitDO = new CommandeProduitDO(produitDO, panier.get(key));
			listeCommandeProduitDO.add(commandeProduitDO);
		}
		CommandeDO commandeDO = new CommandeDO(genererDate(), listeCommandeProduitDO);
		commandeDAO.creerCommandeBDD(commandeDO);
	}

	public Date genererDate() {
		final java.util.Date utilDate = new java.util.Date();
		final java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
}
