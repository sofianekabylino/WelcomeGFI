package mywebapp.bean.data;

import java.util.HashMap;
import java.util.Map;

/**
 *classe qui definie la liste des produits
 */
public class Catalogue {

	private static final Catalogue INSTANCE = new Catalogue();
	private Map<Integer, Produit> listeProduits = new HashMap<Integer, Produit>();

	private Catalogue() {
		//setListeProduits(new HashMap<Integer, Produit>());
		initListeProduit();
	}

	/**
	 * initialise la liste des produits
	 */
	private void initListeProduit() {
		listeProduits.put(1, new Produit(1, "iPhone 6"));
		listeProduits.put(2, new Produit(2, "HTC 620"));
		listeProduits.put(3, new Produit(3, "SAMSUNG S6"));
		listeProduits.put(4, new Produit(4, "Microsoft Lumia"));
	}

	public static Catalogue getInstance() {
		return INSTANCE;
	}

	public Map<Integer, Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(final Map<Integer, Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
}
