package mywebapp.persistance.data;

import java.sql.Date;
import java.util.Set;

public class CommandeDO {

	private int id;
	private Date date;
	private Set<CommandeProduitDO> listeCommandeProduit;

	public CommandeDO() {
		// Constructeur vide.
	}

	public CommandeDO(final Date date, final Set<CommandeProduitDO> listeCommandeProduit) {
		this.listeCommandeProduit = listeCommandeProduit;
		this.date = date;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(final Date date) {
		this.date = date;
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
	 * @return the listeCommandeProduit
	 */
	public Set<CommandeProduitDO> getListeCommandeProduit() {
		return listeCommandeProduit;
	}

	/**
	 * @param listeCommandeProduit
	 *            the listeCommandeProduit to set
	 */
	public void setListeCommandeProduit(final Set<CommandeProduitDO> listeCommandeProduit) {
		this.listeCommandeProduit = listeCommandeProduit;
	}
}
