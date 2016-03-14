package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.bean.form.LoginForm;
import mywebapp.services.IPanierServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Traite le formulaire et renvoie la page de transfert.
 * 
 */
public final class LoginAction extends Action {

	final static String MSG_SUCCES = "succes";
	final static String MSG_ECHEC = "echec";
	final static String ATTR_MESSAGE = "message";
	static final String ATTR_PANIER_SESSION = "panier";
	

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		final IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		String resultat = null;
		final String nomUtilisateur = ((LoginForm) form).getNomUtilisateur();
		final String mdpUtilisateur = ((LoginForm) form).getMdpUtilisateur();

		if (nomUtilisateur.equals("xyz") && mdpUtilisateur.equals("xyz")) {
			resultat = MSG_SUCCES;
		} else {
			resultat = MSG_ECHEC;
		}
		Map<Integer, Integer> panier = panierServices.initPanier();
		req.getSession().setAttribute(ATTR_PANIER_SESSION, panier);
		return mapping.findForward(resultat);
	}
}