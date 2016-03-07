package mywebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mywebapp.bean.data.Catalogue;

public class AfficherPanierAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		req.setAttribute(CatalogueAction.ATTR_CATALOGUE, Catalogue.getInstance().getListeProduits());
		req.setAttribute(LoginAction.ATTR_PANIER, req.getSession().getAttribute(LoginAction.ATTR_PANIER));
		return mapping.findForward(LoginAction.ATTR_PANIER);
	}
}
