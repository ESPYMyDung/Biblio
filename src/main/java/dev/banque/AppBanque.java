package dev.banque;

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
	
    	
    	//Adresse ad3 = new Adresse(86, "Rue Hive", 07245, "Edge");
    	//Cust c4 = new Cust("Strife", "Cloud", "1993-11-30", ad3);
    	
    	Compte assVie = new AssuranceVie("168656", 15632, "2000-05-16", 0.05);
    	Compte lA = new LivretA("135618", 1642, 0.10);


    	EntityTransaction transaction = travail.getTransaction();
    	transaction.begin();
    	
    	travail.persist(assVie);
    	travail.persist(lA);
    	
    	
    	transaction.commit();
    	
    	
    	
    	// fin
    	
    	travail.close();
    	factory.close();

	}

}

// ---- Mise en place de la base de données ----
/*
// on peut le mettre directement dans le code
Banque bq1 = new Banque("Shinra");
Banque bq2 = new Banque("Avalanche");
    	    	
Adresse ad1 = new Adresse(45, "Place Doric", 00125, "Midgard");
Cust c1 = new Cust("Demesderius", "Lazare", "1985-03-05", ad1);
   	
Adresse ad2 = new Adresse(23, "Allée Mecano", 56482, "Rocket Town");
Cust c2 = new Cust("Highwind", "Cid", "1984-08-25", ad2);
   	
Adresse ad3 = new Adresse(86, "Rue Hive", 07245, "Edge");
Cust c3 = new Cust("Lockheart", "Tifa", "1992-12-18", ad3);
Cust c4 = new Cust("Strife", "Cloud", "1993-11-30", ad3);
    	
Compte cp1 = new Compte("123546", 12000);
Compte cp2 = new Compte("146136", 15200);
Compte cp3 = new Compte("124865", 1250);
Compte cp4 = new Compte("123485", 11540);

Operation op1 = new Operation("1998-12-30T21:12:15", 2500, "salaire");
    	Operation op2 = new Operation("2001-09-24T10:46:39", -1000, " achat matos");
    	Operation op3 = new Operation("2005-07-15T07:15:46", 250, "benefice");
    	Operation op4 = new Operation("2001-12-30T21:12:15", 100, "commision");
	
	// à mettre dans le sdl
insert into compt_cli VALUES ("146136", 1);
insert into compt_cli VALUES ("123546", 2);
insert into compt_cli VALUES ("124865", 3);
insert into compt_cli VALUES ("123485", 4);

	// les persists
	 * travail.persist(bq1);
    	travail.persist(bq2);
    	travail.persist(c1);
    	travail.persist(c2);
    	travail.persist(c3);
    	travail.persist(c4);
    	travail.persist(cp1);
    	travail.persist(cp2);
    	travail.persist(cp3);
    	travail.persist(cp4);
    	travail.persist(op1);
    	travail.persist(op2);
    	travail.persist(op3);
    	travail.persist(op4);



    	
 */
