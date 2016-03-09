package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.services.IPanierServices;
import mywebapp.services.IProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Affiche le panier de produits et renvoie la page de transfert.
 * 
 */
public class AffichePanierAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res) {
		final IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		final IProduitServices produitServices = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		final String resultat = "succes";
		Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession().getAttribute("panier");
		req.setAttribute("nbArticles", panierServices.nbArticleDansPanier(panier));
		req.getSession().setAttribute("catalogue", produitServices.recupererCatalogue());
		req.setAttribute("panier", panier);
		return mapping.findForward(resultat);
	}
}
