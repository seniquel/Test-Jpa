package fr.diginamic.jpa.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", length=10, nullable=false)
	private int id;
	@Column(name="NOM", length=50, nullable=false)
	private String nom;
	@Column(name="PRENOM", length=50, nullable=false)
	private String prenom;
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts = new HashSet<Emprunt>();
	
	public Client() {
	}
	
	/** Constructeur
	 * @param id identifiant
	 * @param nom Nom
	 * @param prenom Prénom
	 * @param emprunts Liste des emprunts
	 */
	public Client(int id, String nom, String prenom, Set<Emprunt> emprunts) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.emprunts = emprunts;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	/** Setter
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
}
