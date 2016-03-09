package mywebapp.persistance.dao;

import mywebapp.bean.data.ProduitDTO;

public interface IProduitDAO {

	void creerProduitBDD(ProduitDTO produit);
	
	void recupereCatalogueBDD();
}
