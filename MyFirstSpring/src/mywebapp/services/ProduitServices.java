package mywebapp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mywebapp.bean.data.ProduitDTO;
import mywebapp.exceptions.DAOException;
import mywebapp.persistance.dao.IProduitDAO;
import mywebapp.persistance.dao.ProduitDAO;
import mywebapp.persistance.data.ProduitDO;
import mywebapp.utils.MyFactory;

/**
 * Classe qui contient l'implementation des methodes de l'interface
 * IProduitServices
 */
public class ProduitServices implements IProduitServices {
	private static IProduitServices instance = new ProduitServices();
	private IProduitDAO produitDAO = ProduitDAO.getInstance();

	/**
	 * constructeur privé pour construir un singleton
	 */
	private ProduitServices() {
		// Constructeur vide
	}

	public static IProduitServices getInstance() {
		return instance;
	}

	@Override
	public Map<Integer, ProduitDTO> recupererCatalogue() throws DAOException {

		final Map<Integer, ProduitDTO> catalogue = new HashMap<Integer, ProduitDTO>();
		final List<ProduitDO> listeProduitDO = produitDAO.recupereCatalogueBDD();
		for (ProduitDO p : listeProduitDO) {
			ProduitDTO produitDTO = new ProduitDTO(p.getId(), p.getLibelle(), p.getPrix());
			catalogue.put(produitDTO.getIdProduit(), produitDTO);
		}
		return catalogue;
	}

	@Override
	public void creerProduit(int id, String nom, float prix) throws DAOException {
		final ProduitDTO produit = new ProduitDTO(id, nom, prix);
		final IProduitDAO produitDAO = (IProduitDAO) MyFactory.getInstance(IProduitDAO.class);
		ProduitDO produitDO = new ProduitDO(produit.getIdProduit(), produit.getNomProduit(), produit.getPrixProduit());
		produitDAO.creerProduitBDD(produitDO);
	}

	public void setProduitDAO(IProduitDAO produitDAO) {
		this.produitDAO = produitDAO;
	}

}