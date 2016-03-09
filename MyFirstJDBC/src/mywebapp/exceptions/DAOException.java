package mywebapp.exceptions;

/**
 * Classe qui gere les exceptions lors de l'interaction avec la base de donnees
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 4379231955068919913L;

	/*
	 * Constructeurs
	 */
	public DAOException(final String message) {
		super(message);
	}

	public DAOException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public DAOException(final Throwable cause) {
		super(cause);
	}
}
