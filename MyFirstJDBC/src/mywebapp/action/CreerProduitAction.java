package mywebapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.bean.form.CreerProduitForm;
import mywebapp.exceptions.DAOException;
import mywebapp.services.IProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Traite le formulaire et renvoie la page de transfert.
 * 
 */
public class CreerProduitAction extends Action {
	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) {
		final IProduitServices produitServices = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		final int idProduit = Integer.parseInt(((CreerProduitForm) form).getidProduit());
		final String nomProduit = ((CreerProduitForm) form).getNomProduit();
		final double prixProduit = Double.parseDouble(((CreerProduitForm) form).getPrixProduit());
		String resultat = LoginAction.MSG_SUCCES;
		try {
			produitServices.creerProduit(idProduit, nomProduit, prixProduit);
		} catch (final DAOException e) {
			e.printStackTrace();
			resultat = LoginAction.MSG_ECHEC;
			req.setAttribute(LoginAction.ATTR_MESSAGE, e.getMessage());
		}
		return mapping.findForward(resultat);
	}
}
