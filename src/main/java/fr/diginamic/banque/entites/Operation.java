package fr.diginamic.banque.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OPERATION")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length=10, nullable = false)
	private int id;
	
	@Column(name = "DATE", columnDefinition =  "timestamp default current_timestamp" )
	private LocalDateTime date;
	
	@Column(name = "MONTANT", length = 20, nullable = false)
	private double montant;
	
	@Column(name = "MOTIF", length = 255, nullable = true)
	private String motif;
	
	@ManyToOne
	@JoinColumn(name = "ID_COM")
	private Compte compte;

	public Operation() {
	}
	
	
}
