package mywebapp.bean.data;

public class Produit {

	private int idReference;
	private String nomProduit;

	public Produit(int idReference, String nomProduit) {
		this.idReference = idReference;
		this.nomProduit = nomProduit;
	}

	public int getIdReference() {
		return idReference;
	}

	public void setIdReference(final int idReference) {
		this.idReference = idReference;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(final String nomProduit) {
		this.nomProduit = nomProduit;
	}
}
