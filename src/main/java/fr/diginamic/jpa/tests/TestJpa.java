package fr.diginamic.jpa.tests;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.jpa.entites.Livre;

public class TestJpa {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test-jpa-pu");
		
		//Réalisez un find simple permettant d’extraire un livre en fonction de son identifiant et
		//affichez son titre et son auteur.
		EntityManager em = entityManagerFactory.createEntityManager();	
		Livre livre = em.find(Livre.class, 1);
		if (livre!=null) {
			System.out.println("Titre : "+livre.getTitre()+"\tAuteur : "+livre.getTitre());	
		}

		//Insérez un nouveau Livre de votre choix en base de données
		EntityTransaction et = em.getTransaction();
		et.begin();
		Livre nvLivre = new Livre();
		nvLivre.setTitre("Oui-Oui code en Java");
		nvLivre.setAuteur("Léo Sénique");
		em.persist(nvLivre);
		
		//Modifiez le titre du livre d’identifiant 5 qui possède une erreur : le nouveau titre doit être
		//« Du plaisir dans la cuisine » au lieu de « 1001 recettes de Cuisine ».
		Livre livreAModifier = em.find(Livre.class, 5);
		livreAModifier.setTitre("Du plaisir dans la cuisine");
		
		//Faites une requête JPQL pour extraire de la base un livre en fonction de son titre.
		TypedQuery<Livre> query1 = em.createQuery("select l1 from Livre as l1 where titre='Germinal'",Livre.class);
		Livre livreGerminal = query1.getResultList().get(0);
		if(livreGerminal!=null) {
			System.out.println("Auteur de Germinal : "+livreGerminal.getAuteur());
		}
		
		//Faites une requête JPQL pour extraire de la base un livre en fonction de son auteur.
		TypedQuery<Livre> query2 = em.createQuery("select l1 from Livre as l1 where auteur='Gaston Pouet'",Livre.class);
		Livre livrePouet = query2.getResultList().get(0);
		if(livreGerminal!=null) {
			System.out.println("Titre du livre de Gaston Pouet : "+livrePouet.getTitre());
		}
		
		//Supprimez un livre de votre choix en base de données.
		Livre livreASupprimer = em.find(Livre.class, 3);
		if(livreASupprimer!=null) {
			em.remove(livreASupprimer);
		}
		
		//Affichez la liste de tous les livres présents en base de données (titre et auteur).
		TypedQuery<Livre> query3 = em.createQuery("select l1 from Livre as l1",Livre.class);
		query3.getResultList().forEach(l -> System.out.println("Titre : "+l.getTitre()+"\tAuteur : "+l.getAuteur()));
		
		et.commit();
		em.close();
		entityManagerFactory.close();
	}

}
