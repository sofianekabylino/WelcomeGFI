package mywebapp.bean.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm {
	String nomUtilisateur;

	String mdpUtilisateur;

	public String getMdpUtilisateur() {
		return mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
//		if (nomUtilisateur == null || nomUtilisateur.length() < 1){
//			errors.add("nomUtilisateur", new ActionMessage("erreur.nomutilisateur.obligatoire"));
//		}
		return errors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.mdpUtilisateur = null;
		this.nomUtilisateur = null;
	}
}