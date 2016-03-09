/**
 * 
 */
package mywebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Affiche la page de creation de produit et renvoie la page de transfert.
 * 
 */
public class AfficheCreationProduitAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		return mapping.findForward(LoginAction.MSG_SUCCES);
	}
}
