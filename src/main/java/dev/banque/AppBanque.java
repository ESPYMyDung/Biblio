package dev.banque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppBanque
{

	public static void main(String[] args)
	{
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev.banque");
    	EntityManager travail = factory.createEntityManager();
	
    	// --- mise en place de la bdd --- 
    	// --objet--
    	Banque bq2 = new Banque("Avalanche");
    	
    	Adresse ad2 = new Adresse(23, "Allée Mecano", 56482, "Rocket Town");
    	Cust c2 = new Cust("Highwind", "Cid", "1984-08-25", ad2);
    	   	
    	Adresse ad3 = new Adresse(86, "Rue Hive", 07245, "Edge");
    	Cust c3 = new Cust("Lockheart", "Tifa", "1992-12-18", ad3);
    	Cust c4 = new Cust("Strife", "Cloud", "1993-11-30", ad3);
    	
    	Compte cp2 = new Compte("146136", 15200);
    	Compte cp4 = new Compte("123485", 11540);
    	Compte assVie = new AssuranceVie("168656", 15632, "2000-05-16", 0.05);
    	Compte lA = new LivretA("135618", 1642, 0.10);
    	
    	Operation op2 = new Operation("2001-09-24T10:46:39", -1000, " achat matos");
    	Operation op3 = new Operation("2005-07-15T07:15:46", 250, "benefice");
    	Operation op4 = new Operation("2001-12-30T21:12:15", 100, "commision");
    	Virement v1 = new Virement("2001-12-30T21:12:15", 100, "commision", "Cid Highwind");
    	
    	// --association entre objets (one to mnay et autre)--
    	// client/banque
    	List<Cust> listeCliBq = new ArrayList<>(); listeCliBq.add(c4); listeCliBq.add(c3); listeCliBq.add(c2);
    	bq2.setClients(listeCliBq);
    	c4.setBanque(bq2);
    	c3.setBanque(bq2);
    	c2.setBanque(bq2);
    	
    	//compte/client
    	List<Cust> listeCliCp4 = new ArrayList<>(); listeCliCp4.add(c4); listeCliCp4.add(c3);
    	cp4.setCust(listeCliCp4); 
    	
    	List<Cust> listeCloud = new ArrayList<>(); listeCloud.add(c4);
    	assVie.setCust(listeCloud); lA.setCust(listeCloud);
    	
    	List<Compte> listeCompteC4 = new ArrayList<>();
    	listeCompteC4.add(cp4); listeCompteC4.add(assVie); listeCompteC4.add(lA);
    	c4.setComptes(listeCompteC4);
    	
    	List<Compte> listeCompteC3 = new ArrayList<>();listeCompteC4.add(cp4);
    	c3.setComptes(listeCompteC3);
    	
    	List<Cust> listeCid = new ArrayList<>(); listeCid.add(c2);
    	cp2.setCust(listeCid);

    	//operation/compte
    	op2.setCompte(cp2); op3.setCompte(cp4); op4.setCompte(cp4); v1.setCompte(cp4);
    	
    	List<Operation> listeOps = new ArrayList<>();
    	listeOps.add(op3); listeOps.add(op4); listeOps.add(v1);
    	cp4.setOps(listeOps);
    	
    	List<Operation> listeOpsCid = new ArrayList<>();
    	listeOps.add(op2);
    	cp4.setOps(listeOpsCid);

    	// --- persistance des objets --- 
    	EntityTransaction transaction = travail.getTransaction();
    	transaction.begin();
    	
    	travail.persist(bq2);
    	travail.persist(c2);
    	travail.persist(c3);
    	travail.persist(c4);
    	travail.persist(cp2);
    	travail.persist(cp4);
    	travail.persist(assVie);
    	travail.persist(lA);
    	travail.persist(op2);
    	travail.persist(op3);
    	travail.persist(op4);
    	travail.persist(v1);
    	
    	transaction.commit();

    	
    	// fin   	
    	travail.close();
    	factory.close();

	}

}


/*//autre donnée potentiellement utilisable
Banque bq1 = new Banque("Shinra");
    	    	
Adresse ad1 = new Adresse(45, "Place Doric", 00125, "Midgard");
Cust c1 = new Cust("Demesderius", "Lazare", "1985-03-05", ad1);
    	
Compte cp1 = new Compte("123546", 12000);
Compte cp3 = new Compte("124865", 1250);

Operation op1 = new Operation("1998-12-30T21:12:15", 2500, "salaire");
 	
 */
