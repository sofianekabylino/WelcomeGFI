package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Affiche le panier de produits et renvoie la page de transfert.
 * 
 */
public class AffichePanierAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws DAOException {
		final IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		final IProduitServices produitServices = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		final String resultat = LoginAction.MSG_SUCCES;
		final Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession().getAttribute(LoginAction.ATTR_PANIER_SESSION);
		req.setAttribute(LoginAction.ATTR_Nb_ARTICLE, panierServices.nbArticleDansPanier(panier));
		req.getSession().setAttribute(LoginAction.ATTR_CATALOGUE, produitServices.recupererCatalogue());
		req.setAttribute(LoginAction.ATTR_PANIER, panier);
		return mapping.findForward(resultat);
	}
}
