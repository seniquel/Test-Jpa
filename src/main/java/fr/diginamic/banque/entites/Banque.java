package fr.diginamic.banque.entites;

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
@Table(name = "BANQUE")
public class Banque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 10,  nullable = false)
	private int id;
	
	@Column(name = "NOM", length = 20, nullable = false)
	private String nom;
	
	@OneToMany(mappedBy = "banque")
	private Set<Client> clients = new HashSet<>();

	public Banque() {
	}
	
}
