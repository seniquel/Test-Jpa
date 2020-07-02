package fr.diginamic.jpa.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	@Id
	@Column(name = "ID", length = 10, nullable = false)
	private int id;
	
	@Column(name = "TITRE", length = 255, nullable = false) 
	private String titre;
	
	@Column(name = "AUTEUR", length = 50, nullable = false) 
	private String auteur;
	
	@ManyToMany(mappedBy = "livres")
	private Set<Emprunt> emprunts = new HashSet<Emprunt>();
	

	public Livre() {
	}
	
	


	/** Constructeur
	 * @param id Identifiant
	 * @param titre Titre
	 * @param auteur Auteur
	 */
	public Livre(int id, String titre, String auteur) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	/** Constructeur
	 * @param id Identifiant
	 * @param titre Titre
	 * @param auteur Auteurs
	 * @param emprunts Liste des emprunts
	 */
	public Livre(int id, String titre, String auteur, Set<Emprunt> emprunts) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}


	/** Setter
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}


	/** Getter
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}


	/** Setter
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
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
