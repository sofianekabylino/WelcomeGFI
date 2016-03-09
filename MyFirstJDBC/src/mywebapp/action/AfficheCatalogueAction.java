package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mywebapp.exceptions.DAOException;
import mywebapp.services.IPanierServices;
import mywebapp.services.IProduitServices;
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
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		final IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		final IProduitServices produitService = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		String resultat = LoginAction.MSG_SUCCES;
		final HttpSession session = req.getSession();
		Map<Integer, Integer> panier = (Map<Integer, Integer>) session.getAttribute(LoginAction.ATTR_PANIER_SESSION);
		if (panier == null) {
			panier = panierServices.initPanier();
			session.setAttribute(LoginAction.ATTR_PANIER, panier);
		}
		final int nbArticles = panierServices.nbArticleDansPanier(panier);
		req.setAttribute(LoginAction.ATTR_Nb_ARTICLE, nbArticles);
		try {
			req.setAttribute(LoginAction.ATTR_CATALOGUE, produitService.recupererCatalogue());
		} catch (final DAOException e) {
			e.printStackTrace();
			resultat = LoginAction.MSG_ECHEC;
			req.setAttribute(LoginAction.ATTR_MESSAGE, e.getMessage());
		}
		return mapping.findForward(resultat);
	}
}
