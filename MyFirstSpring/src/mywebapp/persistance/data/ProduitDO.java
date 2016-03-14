package mywebapp.persistance.data;

public class ProduitDO {

	private int id;
	private String libelle;
	private float prix;

	public ProduitDO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur ProduitDO
	 * 
	 * @param id
	 * @param libelle
	 * @param prix
	 */
	public ProduitDO(int id, String libelle, float prix) {
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
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
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(final String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the prix
	 */
	public float getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(final float prix) {
		this.prix = prix;
	}
}
