package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.services.IPanierServices;
import mywebapp.services.IProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Traite les modifications de produits et renvoie la page de transfert.
 * 
 */
public class ModifiePanierAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res) {
		IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		IProduitServices produitServices = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		String resultat = "succes";
		int reference = 0;
		try {
			reference = Integer.parseInt(req.getParameter("reference"));
		} catch (final NumberFormatException nfe) {
			resultat = "echec";
			final String message = "Le string ne peut pas etre converti en entier.";
			req.setAttribute("message", message);
		}
		final Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession().getAttribute("panier");
		final Map<Integer, ProduitDTO> listeProduits = produitServices.recupererCatalogue();

		if ("ajoutProduit".equals(mapping.getName()) && listeProduits.containsKey(reference)) {
			panierServices.ajouterDansPanier(panier, reference);
		} else if ("suppressionProduit".equals(mapping.getName())) {
			panierServices.retirerDuPanier(panier, reference);
		}
		req.setAttribute("catalogue", listeProduits);
		return mapping.findForward(resultat);
	}
}