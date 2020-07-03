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
}
