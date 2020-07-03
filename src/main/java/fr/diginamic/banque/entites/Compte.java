package fr.diginamic.banque.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
	
	/** Ajoute un nouveau client dans la liste des clients
	 * @param nvClient Nouveau client
	 */
	public void addClient(Client nvClient) {
		clients.add(nvClient);
	}
	
	/** Ajoute une nouvelle opération dans la liste des opérations
	 * @param nvOperation Nouvelle opération
	 */
	public void addOperation(Operation nvOperation) {
		operations.add(nvOperation);
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
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
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

	/** Getter
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/** Setter
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	
}
