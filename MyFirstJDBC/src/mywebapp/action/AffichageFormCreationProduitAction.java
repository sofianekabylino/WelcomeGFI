package mywebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action qui sert à afficher le formulaire de création d'un produit
 * 
 */
public class AffichageFormCreationProduitAction extends Action {

	/**
	 * renvoi succes pour éxécuter un forward qui va nous afficher le formulaire
	 * de création de produit
	 */
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {

		return mapping.findForward(LoginAction.MSG_SUCCES);
	}
}
