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
	
	/** Ajoute un nouveau client à la liste des clients
	 * @param nvClient Nouveau client
	 */
	public void addClient(Client nvClient) {
		clients.add(nvClient);
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
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/** Setter
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
}
