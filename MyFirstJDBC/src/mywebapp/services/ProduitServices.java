package mywebapp.services;

import java.util.HashMap;
import java.util.Map;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.persistance.dao.IProduitDAO;
import mywebapp.utils.MyFactory;

/**
 * Classe qui contient l'implementation des methodes de l'interface
 * IProduitServices
 */
public class ProduitServices implements IProduitServices {
	private static IProduitServices instance = new ProduitServices();
	private static final Map<Integer, ProduitDTO> catalogue = new HashMap<Integer, ProduitDTO>();

	/**
	 * constructeur priv� pour construir un singleton
	 */
	private ProduitServices() {
		// Constructeur vide
	}

	public static IProduitServices getInstance() {
		return instance;
	}

	@Override
	public Map<Integer, ProduitDTO> recupererCatalogue() {
		initCatalogue();
		return catalogue;
	}

	private void initCatalogue() {
		catalogue.put(1, new ProduitDTO(1, "iPhone 6", 700));
		catalogue.put(2, new ProduitDTO(2, "HTC 620", 220.50));
		catalogue.put(3, new ProduitDTO(3, "SAMSUNG S6", 650));
		catalogue.put(4, new ProduitDTO(4, "Microsoft Lumia", 400));
	}

	@Override
	public void creerProduit(int id, String nom, double prix) {
		final ProduitDTO produit = new ProduitDTO(id, nom, prix);
		IProduitDAO produitDAO = (IProduitDAO) MyFactory.getInstance(IProduitDAO.class);
		produitDAO.creerProduitBDD(produit);
	}

}