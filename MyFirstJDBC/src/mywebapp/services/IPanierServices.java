package mywebapp.services;

import java.util.Map;

/**
 * Interface qui regroupe les services concernant les operations sur le panier.
 */
public interface IPanierServices {

	/**
	 * initialise un panier
	 * 
	 * @return un panier
	 */
	Map<Integer, Integer> initPanier();

	/**
	 * vide un panier
	 * 
	 * @param panier
	 */
	void viderPanier(Map<Integer, Integer> panier);

	/**
	 * Ajoute un produit dans le panier.
	 * 
	 * @param panier
	 *            le panier ciblé.
	 * @param reference
	 *            la référence à ajouter.
	 */
	void ajouterDansPanier(Map<Integer, Integer> panier, int reference);

	/**
	 * supprimmer un produit d'un panier
	 * 
	 * @param panier
	 * @param reference
	 */
	void retirerDuPanier(Map<Integer, Integer> panier, int reference);

	/**
	 * retourne le nombre d'article dans un panier
	 * 
	 * @param panier
	 * @return nombre d'article dans un panier
	 */
	int nbArticleDansPanier(Map<Integer, Integer> panier);

}