package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mywebapp.bean.data.Catalogue;

public class CatalogueAction extends Action {

	public final static String ATTR_CATALOGUE = "catalogue";

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		Map<Integer, Integer> mapPanier = (Map<Integer, Integer>) req.getSession()
				.getAttribute(LoginAction.ATTR_PANIER);
		int taillePanier = 0;
		for (Integer key : mapPanier.keySet()) {
			taillePanier += mapPanier.get(key); 
		}
		req.setAttribute("taillePanier", taillePanier);
		req.setAttribute(ATTR_CATALOGUE, Catalogue.getInstance().getListeProduits());
		return mapping.findForward(ATTR_CATALOGUE);
	}
}
