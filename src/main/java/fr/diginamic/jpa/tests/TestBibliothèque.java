package fr.diginamic.jpa.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.entites.Client;
import fr.diginamic.jpa.entites.Emprunt;
import fr.diginamic.jpa.entites.Livre;

public class TestBibliothèque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa-pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
		TypedQuery<Livre> queryLivresEmprunt = em.createQuery("select l from Livre l join l.emprunts e where e.id=1", Livre.class);
		System.out.println("Livres de l'emprunt d'ID=1 :");
		queryLivresEmprunt.getResultList().forEach(l -> System.out.println("Titre : "+l.getTitre()+"\tAuteur : "+l.getAuteur()));
		
		//Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.
		Client c1 = em.find(Client.class, 1);
		TypedQuery<Emprunt> queryEmpruntsClient = em.createQuery("select e from Emprunt e join e.client c where c.nom=?1", Emprunt.class);
		queryEmpruntsClient.setParameter(1, c1.getNom());
		System.out.println("Emprunts de "+c1.getPrenom()+" "+c1.getNom()+" :");
		queryEmpruntsClient.getResultList().forEach(e -> System.out.println("Id : "+e.getId()+"\t Date début : "+e.getDateDebut()));
		
		
		em.close();
		entityManagerFactory.close();
	}

}
