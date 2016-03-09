package mywebapp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.exceptions.DAOException;
import mywebapp.services.IPanierServices;
import mywebapp.services.IProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mywebapp.exceptions.ActionException;

/**
 * 
 * Traite les modifications de produits et renvoie la page de transfert.
 * 
 */
public class ModifiePanierAction extends Action {

	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws ActionException {
		final IPanierServices panierServices = (IPanierServices) MyFactory.getInstance(IPanierServices.class);
		final IProduitServices produitServices = (IProduitServices) MyFactory.getInstance(IProduitServices.class);
		String resultat = LoginAction.MSG_SUCCES;
		int idProduit = 0;
		try {
			idProduit = Integer.parseInt(req.getParameter("reference"));
		} catch (final NumberFormatException nfe) {
			resultat = LoginAction.MSG_ECHEC;
			final String message = "Le string ne peut pas etre converti en entier.";
			req.setAttribute(LoginAction.ATTR_MESSAGE, message);
			throw new ActionException(message);
		}
		final Map<Integer, Integer> panier = (Map<Integer, Integer>) req.getSession().getAttribute(LoginAction.ATTR_PANIER_SESSION);
		Map<Integer, ProduitDTO> listeProduits = null;
		try {
			listeProduits = produitServices.recupererCatalogue();
		} catch (final DAOException e) {
			resultat = LoginAction.MSG_ECHEC;
			req.setAttribute(LoginAction.ATTR_MESSAGE, e.getMessage());
			e.printStackTrace();
		}

		if ("ajoutProduit".equals(mapping.getName()) && listeProduits.containsKey(idProduit)) {
			panierServices.ajouterDansPanier(panier, idProduit);
		} else if ("suppressionProduit".equals(mapping.getName())) {
			panierServices.retirerDuPanier(panier, idProduit);
		}
		req.setAttribute(LoginAction.ATTR_CATALOGUE, listeProduits);
		return mapping.findForward(resultat);
	}
}