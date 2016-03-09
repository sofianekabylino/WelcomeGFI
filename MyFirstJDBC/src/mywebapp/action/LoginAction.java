package mywebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.bean.form.LoginForm;

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
	static final String ATTR_PANIER = "panier";
	static final String ATTR_Nb_ARTICLE = "nbArticles";
	static final String ATTR_CATALOGUE = "catalogue";

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {
		String resultat = null;
		final String nomUtilisateur = ((LoginForm) form).getNomUtilisateur();
		final String mdpUtilisateur = ((LoginForm) form).getMdpUtilisateur();

		if (nomUtilisateur.equals("xyz") && mdpUtilisateur.equals("xyz")) {
			resultat = MSG_SUCCES;
		} else {
			resultat = MSG_ECHEC;
		}
		return mapping.findForward(resultat);
	}
}