package mywebapp.bean.form;

import javax.servlet.http.HttpServletRequest;

import mywebapp.exceptions.DAOException;
import mywebapp.services.IProduitServices;
import mywebapp.utils.MyFactory;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * Permet de recuperer les donnees du formulaire de creation de produit, valider
 * et remettre a 0.
 * 
 */
public class CreerProduitForm extends ActionForm {

	private static final long serialVersionUID = -5192149732549672997L;

	String idProduit;
	String nomProduit;
	String prixProduit;

	/**
	 * @return the reference
	 */
	public String getidProduit() {
		return idProduit;
	}

	/**
	 * @param reference
	 *            the reference to set
	 */
	public void setidProduit(final String idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the nom
	 */
	public String getNomProduit() {
		return nomProduit;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNomProduit(final String nomProduit) {
		this.nomProduit = nomProduit;
	}

	/**
	 * @return the prix
	 */
	public String getPrixProduit() {
		return prixProduit;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrixProduit(final String prixProduit) {
		this.prixProduit = prixProduit;
	}

	/**
	 * Valide ou non le formulaire en renvoyant les erreurs
	 * 
	 * @param mapping
	 *            voir la classe @link{ActionMapping}
	 * @param request
	 *            la requete HTTP
	 */
	public ActionErrors validate(final ActionMapping mapping, final HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		final IProduitServices produitServices = (IProduitServices) MyFactory.getInstance(IProduitServices.class);

		if ((idProduit == null) || (idProduit.length() == 0)) {
			errors.add("idProduit", new ActionMessage("erreur.reference.obligatoire"));
		} else {
			try {
				int refEntree = Integer.parseInt(idProduit);
				if (produitServices.recupererCatalogue().get(refEntree) != null) {
					errors.add("reference", new ActionMessage("erreur.reference.existeDeja"));
				}
			} catch (final NumberFormatException nfe) {
				errors.add("idProduit", new ActionMessage("erreur.reference.incorrect"));
			} catch (final DAOException e) {
				e.printStackTrace();
			}
		}

		if ((nomProduit == null) || (nomProduit.length() == 0)) {
			errors.add("nomProduit", new ActionMessage("erreur.nom.obligatoire"));
		}

		if ((prixProduit == null) || (prixProduit.length() == 0)) {
			errors.add("prixProduit", new ActionMessage("erreur.prix.obligatoire"));
		} else {
			try {
				Double.parseDouble(prixProduit);
			} catch (final NumberFormatException nfe) {
				errors.add("prixProduitProduit", new ActionMessage("erreur.prix.incorrect"));
			}
		}

		return errors;
	}
}
