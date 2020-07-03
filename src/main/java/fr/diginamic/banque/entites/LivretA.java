package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRET_A")
public class LivretA extends Compte {
	
	@Column(name = "TAUX", length = 10, nullable = false)
	private double taux;

	public LivretA() {
	}

	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
}
