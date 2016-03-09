package mywebapp.bean.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * Permet de recuperer les donnees du formulaire de login, valider et remettre a
 * 0.
 * 
 */
public class LoginForm extends ActionForm {

	private static final long serialVersionUID = -7573051799731655035L;

	String nomUtilisateur;
	String mdpUtilisateur;

	/**
	 * Getter mdpUtilisateur
	 * 
	 * @return mdpUtilisateur le mot de passe de l'utilisateur
	 */
	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	/**
	 * Setter mdpUtilisateur
	 * 
	 * @param mdpUtilisateur
	 *            le mot de passe de l'utilisateur
	 */
	public void setMdpUtilisateur(final String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	/**
	 * Getter nomUtilisateur
	 * 
	 * @return nomUtilisateur le nom de l'utilisateur
	 */
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	/**
	 * Setter nomUtilisateur
	 * 
	 * @param nomUtilisateur
	 *            le nom de l'utilisateur
	 */
	public void setNomUtilisateur(final String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
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

		if ((nomUtilisateur == null) || (nomUtilisateur.length() == 0))
			errors.add("nomUtilisateur", new ActionMessage("erreur.nomutilisateur.obligatoire"));
		else if (!nomUtilisateur.equals("xyz"))
			errors.add("nomUtilisateur", new ActionMessage("erreur.nomutilisateur.incorrect"));

		if ((mdpUtilisateur == null) || (mdpUtilisateur.length() == 0))
			errors.add("mdpUtilisateur", new ActionMessage("erreur.mdputilisateur.obligatoire"));
		else if (!mdpUtilisateur.equals("xyz"))
			errors.add("mdpUtilisateur", new ActionMessage("erreur.mdputilisateur.incorrect"));

		return errors;
	}

	/**
	 * Remet a 0 le formulaire
	 * 
	 * @param mapping
	 *            voir la classe @link{ActionMapping}
	 * @param request
	 *            la requete HTTP
	 */
	public void reset(final ActionMapping mapping, final HttpServletRequest request) {
		this.mdpUtilisateur = null;
		this.nomUtilisateur = null;
	}
}