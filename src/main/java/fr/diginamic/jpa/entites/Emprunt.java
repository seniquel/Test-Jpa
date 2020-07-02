package fr.diginamic.jpa.entites;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", length=10, nullable=false)
	private int id;
	
	@Column(name="DATE_DEBUT", nullable=false)
	private LocalDateTime dateDebut;
	
	@Column(name="DELAI", length=10, nullable=true)
	private int delai;
	
	@Column(name="DATE_FIN", nullable=true)
	private LocalDateTime dateFin;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName = "ID"),
			inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres = new HashSet<Livre>();

	public Emprunt() {
	}

	/** Constructeur
	 * @param id Identifiant
	 * @param dateDebut Date du début
	 * @param delai Délai
	 * @param dateFin Date de fin
	 * @param client Client
	 * @param livres Liste des livres
	 */
	public Emprunt(int id, LocalDateTime dateDebut, int delai, LocalDateTime dateFin, Client client,
			Set<Livre> livres) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.delai = delai;
		this.dateFin = dateFin;
		this.client = client;
		this.livres = livres;
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/** Setter
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	/** Getter
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/** Getter
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/** Setter
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
}
