package fr.diginamic.banque.entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@Table(name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 10,  nullable = false)
	private int id;
	
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;
	
	@Column(name = "DATE_NAISSANCE", nullable = false)
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_BNQ")
	private Banque banque;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="COMPO",
			joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName = "ID"),
			inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName = "ID"))
	private Set<Compte> comptes = new HashSet<>();

	public Client() {
	}
	
	/** Ajoute une nouveau compte dans la liste des comptes
	 * @param nvCompte Nouveau compte
	 */
	public void addCompte(Compte nvCompte) {
		comptes.add(nvCompte);
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/** Getter
	 * @return the comptes
	 */
	public Set<Compte> getComptes() {
		return comptes;
	}

	/** Setter
	 * @param comptes the comptes to set
	 */
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	
}
