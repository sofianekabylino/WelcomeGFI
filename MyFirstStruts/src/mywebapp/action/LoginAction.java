package mywebapp.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mywebapp.bean.form.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class LoginAction extends Action {

	public final static String ATTR_SUCCES = "succes";
	public final static String ATTR_ECHEC = "echec";
	public final static String ATTR_PANIER = "panier";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		String resultat = null;
		final LoginForm loginForm = (LoginForm) form;
		final String nomUtilisateur = loginForm.getNomUtilisateur();
		final String mdpUtilisateur = loginForm.getMdpUtilisateur();
		final Map<Integer, Integer> panier = new HashMap<Integer, Integer>();

		HttpSession session = req.getSession();
		session.setAttribute(ATTR_PANIER, panier);

		if (nomUtilisateur.equals("xyz") && mdpUtilisateur.equals("xyz")) {
			resultat = ATTR_SUCCES;
		} else {
			resultat = ATTR_ECHEC;
		}

		return mapping.findForward(resultat);
	}
}