package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ViderPanierAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Map<Integer, Integer> mapPanier = (Map<Integer, Integer>) req.getSession()
				.getAttribute(LoginAction.ATTR_PANIER);
		mapPanier.clear();
		req.setAttribute(LoginAction.ATTR_PANIER, mapPanier);
		return mapping.findForward(LoginAction.ATTR_PANIER);
	}
}
