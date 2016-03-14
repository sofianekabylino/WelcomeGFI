package mywebapp.persistance.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.data.CommandeDO;
import mywebapp.utils.ConnexionSession;

/**
 * Classe qui implemente les methodes qui permettent de gerer les interactions
 * avec la base de donn�es pour les commandes.
 */
public class CommandeDAO implements ICommandeDAO {

	private static ICommandeDAO instance = new CommandeDAO();
	private SessionFactory sessionFactory;

	/**
	 * Constructeur private pour construir le singleton
	 */
	private CommandeDAO() {
		// Constructeur vide
	}

	public static ICommandeDAO getInstance() {
		return instance;
	}

	@Override
	public void creerCommandeBDD(final CommandeDO commandeDO) throws DAOException {

		try {

			final Session session = sessionFactory.openSession();
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(commandeDO);
				session.flush();
				tx.commit();
			} catch (final HibernateException e) {
				try {
					tx.rollback();
				} catch (final HibernateException e1) {
					throw new DAOException(e1.getMessage(), e1.getCause());
				}
				e.printStackTrace();
			} finally {
				session.close();
			}
		} finally {
			ConnexionSession.fermerConnexionSession(sessionFactory);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}