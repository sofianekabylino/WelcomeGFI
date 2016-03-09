package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mywebapp.exceptions.DAOException;
import mywebapp.services.ICommandeServices;
import mywebapp.utils.MyFactory;

public class ValiderCommandeAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		ICommandeServices commandeServices = (ICommandeServices) MyFactory.getInstance(ICommandeServices.class);
		Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession()
				.getAttribute(LoginAction.ATTR_PANIER_SESSION);
		String resultat = LoginAction.MSG_SUCCES;
		try {
			commandeServices.creerCommande(panier);
			panier.clear();
		} catch (DAOException e) {
			req.setAttribute(LoginAction.ATTR_MESSAGE, e.getMessage());
			resultat = LoginAction.MSG_ECHEC;
			req.setAttribute(LoginAction.ATTR_MESSAGE, e.getMessage());
			e.printStackTrace();
		}
		return mapping.findForward(resultat);
	}
}
