package mywebapp.persistance.data;

public class CommandeProduitDO {

	private int id;
	private ProduitDO produitDO;
	private int quantite;

	public CommandeProduitDO() {
		// Constructeur vide
	}
	public CommandeProduitDO(final ProduitDO produitDO, final int quantite) {
		this.produitDO = produitDO;
		this.quantite = quantite;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the produitDO
	 */
	public ProduitDO getProduitDO() {
		return produitDO;
	}

	/**
	 * @param produitDO
	 *            the produitDO to set
	 */
	public void setProduitDO(ProduitDO produitDO) {
		this.produitDO = produitDO;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
