package mywebapp.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mywebapp.exceptions.DAOException;
import mywebapp.persistance.data.ProduitDO;
import mywebapp.utils.ApplicationContextHolder;
import mywebapp.utils.ConnexionSession;

/**
 * Classe qui implémente les méthodes qui pérmettent de gérer les
 * intérractions avec la base de données pour les produits.
 */
public class ProduitDAO implements IProduitDAO {

	private static IProduitDAO instance = new ProduitDAO();
	private SessionFactory sessionFactory = (SessionFactory) ApplicationContextHolder.getBean("sessionFactory");

	/**
	 * Constructeur prive pour construir un singleton
	 */
	private ProduitDAO() {
		// Constructeur vide
	}

	public static IProduitDAO getInstance() {
		return instance;
	}

	@Override
	public void creerProduitBDD(final ProduitDO produit) throws DAOException {
		final Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ProduitDO personne = new ProduitDO(produit.getId(), produit.getLibelle(), produit.getPrix());
			session.save(personne);
			session.flush();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		sessionFactory.close();
	}

	@Override
	public List<ProduitDO> recupereCatalogueBDD() throws DAOException {
		List<ProduitDO> listeProduits = new ArrayList<ProduitDO>();
		final Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from ProduitDO");
			listeProduits = query.list();
		} catch (final HibernateException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			session.close();
		}
		ConnexionSession.fermerConnexionSession(sessionFactory);
		return listeProduits;
	}

	@Override
	public ProduitDO recupererProduitBDD(int id) throws DAOException {
		final Session session = sessionFactory.openSession();
		ProduitDO produitDO = new ProduitDO();
		try {
			produitDO = (ProduitDO) session.get(ProduitDO.class, id);
		} catch (final HibernateException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage(), e.getCause());
		} finally {
			session.close();
		}
		return produitDO;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}