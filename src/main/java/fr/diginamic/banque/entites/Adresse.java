package fr.diginamic.banque.entites;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	@Column(name = "NUMERO", length = 10, nullable = false)
	private int numero;
	
	@Column(name = "RUE", length = 255, nullable = false)
	private String rue;
	
	@Column(name = "CODE_POSTAL", length = 10, nullable = false)
	private int codePostal;
	
	@Column(name = "VILLE", length = 100, nullable = false)
	private String ville;

	public Adresse() {
	}

	public Adresse(int numero, String rue, int codePostal, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/** Getter
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/** Setter
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/** Getter
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/** Setter
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/** Getter
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/** Setter
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
}
