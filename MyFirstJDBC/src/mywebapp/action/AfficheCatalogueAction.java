package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mywebapp.services.IPanierServices;
import mywebapp.services.IProduitServices;
import mywebapp.services.ProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Affiche le catalogue des produits et initialise le panier.
 * 
 */
public class AfficheCatalogueAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res) {
		IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		IProduitServices produitService = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		final String resultat = "succes";
		final HttpSession session = req.getSession();
		Map<Integer, Integer> panier = (Map<Integer, Integer>) session.getAttribute("panier");
		if (panier == null) {
			panier = panierServices.initPanier();
			session.setAttribute("panier", panier);
		}
		final int nbArticles = panierServices.nbArticleDansPanier(panier);
		req.setAttribute("nbArticles", nbArticles);
		req.setAttribute("catalogue", produitService.recupererCatalogue());
		return mapping.findForward(resultat);
	}
}
