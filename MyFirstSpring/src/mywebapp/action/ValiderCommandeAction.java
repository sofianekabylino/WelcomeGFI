package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.exceptions.DAOException;
import mywebapp.services.ICommandeServices;
import mywebapp.services.IProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ValiderCommandeAction extends Action {

	final static String ATTR_MESSAGE = "message";

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		final ICommandeServices commandeServices = (ICommandeServices) MyFactory.getInstance(ICommandeServices.class);
		final IProduitServices produitService = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		final Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession().getAttribute(LoginAction.ATTR_PANIER_SESSION);
		String resultat = LoginAction.MSG_SUCCES;
		try {
			commandeServices.creerCommande(panier, produitService.recupererCatalogue());
			panier.clear();
		} catch (DAOException e) {
			req.setAttribute(LoginAction.ATTR_MESSAGE, e.getMessage());
			resultat = LoginAction.MSG_ECHEC;
			req.setAttribute(ATTR_MESSAGE, e.getMessage());
			e.printStackTrace();
		}
		return mapping.findForward(resultat);
	}
}
