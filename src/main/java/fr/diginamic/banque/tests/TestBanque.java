package fr.diginamic.banque.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.Client;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;
import fr.diginamic.banque.entites.Virement;

public class TestBanque {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-pu");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		et.begin();	
		
		Banque banque1 = new Banque();
		banque1.setNom("Crédit Bananier");
		
		Client client1 = new Client();
		client1.setDateNaissance(LocalDate.of(1980, 01, 01));
		client1.setNom("Jean-Pierre Banane");
		client1.setAdresse(new Adresse(1,"Rue des bananes",012345,"Bananeville"));
		client1.setBanque(banque1);
		banque1.addClient(client1);
		em.persist(client1);
		
		Client client2 = new Client();
		client2.setDateNaissance(LocalDate.of(1990, 02, 02));
		client2.setNom("Jean-François Haricot");
		client2.setAdresse(new Adresse(1,"Rue des haricots",012345,"Los Haricots"));
		client2.setBanque(banque1);
		banque1.addClient(client2);
		em.persist(client2);
		
		//insérer un compte associé à 2 clients
		Compte compteDouble = new Compte();
		compteDouble.setSolde(2000);
		compteDouble.addClient(client1);
		compteDouble.addClient(client2);
		client1.addCompte(compteDouble);
		client2.addCompte(compteDouble);
		em.persist(compteDouble);
		
		//insérer un client avec plusieurs comptes
		Client client3 = new Client();
		client3.setDateNaissance(LocalDate.of(1970, 03, 01));
		client3.setNom("Jean-Baptiste Aimelescomptes");
		client3.setAdresse(new Adresse(5,"Avenue des comptes",23456,"Compte City"));
		client3.setBanque(banque1);
		banque1.addClient(client3);
		em.persist(client3);
		
		LivretA livretA = new LivretA();
		livretA.setSolde(5000);
		livretA.setTaux(0.1);
		livretA.addClient(client3);
		client3.addCompte(livretA);
		em.persist(livretA);
		
		AssuranceVie assVie = new AssuranceVie();
		assVie.setSolde(1500);
		assVie.setDateFin(LocalDate.of(2030, 01, 01));
		assVie.setTaux(0.5);
		assVie.addClient(client3);
		client3.addCompte(assVie);
		em.persist(assVie);
		
		//insérer des opérations de type virements sur un compte
		Virement v1 = new Virement();
		v1.setCompte(compteDouble);
		v1.setMontant(2.5);
		v1.setBeneficiaire("Jean-François Haricot");
		v1.setMotif("Remboursement boîte de haricots");
		compteDouble.addOperation(v1);
		em.persist(v1);
		
		Virement v2 = new Virement();
		v2.setCompte(compteDouble);
		v2.setMontant(-500);
		v2.setBeneficiaire("Jean-François Banane");
		v2.setMotif("Banane en or");
		compteDouble.addOperation(v2);
		em.persist(v2);
		
		//insérer des opérations de type opérations sur un compte
		Operation op1 = new Operation();
		op1.setCompte(livretA);
		op1.setMontant(200);
		op1.setDate(LocalDateTime.of(2015, 12, 24, 12, 0));
		op1.setMotif("Noël");
		livretA.addOperation(op1);
		em.persist(op1);
		
		Operation op2 = new Operation();
		op2.setCompte(livretA);
		op2.setMontant(100);
		op2.setDate(LocalDateTime.of(2012, 04, 12, 23, 59));
		livretA.addOperation(op2);
		em.persist(op2);
		
		et.commit();
		em.close();
		entityManagerFactory.close();

	}

}
