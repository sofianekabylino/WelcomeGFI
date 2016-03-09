package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.services.IPanierServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Vide le panier et renvoie la page de transfert
 * 
 */
public class ViderPanierAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req, final HttpServletResponse res) {
		IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		final Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession().getAttribute("panier");
		panierServices.viderPanier(panier);
		req.getSession().setAttribute("panier", panier);
		return mapping.findForward("succes");
	}
}