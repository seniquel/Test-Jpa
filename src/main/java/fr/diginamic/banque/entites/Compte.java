package fr.diginamic.banque.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length=10, nullable = false)
	private int id;
	
	@Column(name = "SOLDE", length=20, nullable = false)
	private double solde = 0;
	
	@ManyToMany(mappedBy = "comptes")
	private Set<Client> clients = new HashSet<>();
	
	@OneToMany(mappedBy = "compte")
	private Set<Operation> operations = new HashSet<>();

	public Compte() {
	}

	
}
