package fr.diginamic.banque.entites;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	
	@ManyToOne
	@JoinColumn(name = "ID_BNQ")
	private Banque banque;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns= @JoinColumn(name="ID_CLI", referencedColumnName = "ID"),
			inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName = "ID"))
	private Set<Compte> comptes = new HashSet<>();

	public Client() {
	}

	
}
