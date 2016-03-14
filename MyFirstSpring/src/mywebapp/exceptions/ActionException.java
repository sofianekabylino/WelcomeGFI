package mywebapp.exceptions;

/**
 * 
 * ActionException est une Exception servant a toutes les classes action.
 *
 */
public class ActionException extends Exception {

	private static final long serialVersionUID = -7041408215429393280L;

	/**
	 * Constructeur avec message et cause.
	 * @param message le message d'erreur informatif.
	 * @param cause exception d'origine ayant provoque l'erreur.
	 */
	public ActionException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructeur avec message sans cause.
	 * @param message le message d'erreur informatif.
	 */
	public ActionException(final String message) {
		super(message);
	}

}
