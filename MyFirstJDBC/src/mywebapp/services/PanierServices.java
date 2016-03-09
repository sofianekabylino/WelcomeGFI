package mywebapp.services;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe qui contient l'implementation des methodes de l'interface
 * IPanierServices
 */
public class PanierServices implements IPanierServices {

	private static IPanierServices instance = new PanierServices();

	/**
	 * Constructeur private pour construir un singleton
	 */
	private PanierServices() {
		// Constructeur vide
	}

	public static IPanierServices getInstance() {
		return instance;
	}

	@Override
	public Map<Integer, Integer> initPanier() {
		return new HashMap<Integer, Integer>();
	}

	@Override
	public void viderPanier(final Map<Integer, Integer> panier) {
		panier.clear();
	}

	@Override
	public void ajouterDansPanier(final Map<Integer, Integer> panier, final int idProduit) {
		if (panier.get(idProduit) == null) {
			panier.put(idProduit, 1);
		} else {
			panier.put(idProduit, panier.get(idProduit) + 1);
		}
	}

	@Override
	public void retirerDuPanier(final Map<Integer, Integer> panier, final int idProduit) {
		final Integer quantite = panier.get(idProduit);
		if (quantite != null) {
			if (quantite > 1) {
				panier.put(idProduit, quantite - 1);
			} else if (quantite == 1) {
				panier.remove(idProduit);
			}
		}
	}

	@Override
	public int nbArticleDansPanier(final Map<Integer, Integer> panier) {
		int nbArticles = 0;
		if (panier != null) {
			for (Integer quantite : panier.values()) {
				nbArticles += quantite;
			}
		}
		return nbArticles;
	}
}