package fr.diginamic.banque.entites;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "OPERATION")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length=10, nullable = false)
	private int id;
	
	@Column(name = "DATE", columnDefinition =  "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" )
	private LocalDateTime date;
	
	@Column(name = "MONTANT", length = 20, nullable = false)
	private double montant;
	
	@Column(name = "MOTIF", length = 255, nullable = true)
	private String motif;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_COM")
	private Compte compte;

	public Operation() {
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
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/** Setter
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/** Getter
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
}
