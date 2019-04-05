package dev.banque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppBanque
{

	public static void main(String[] args)
	{
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev.banque");
    	EntityManager travail = factory.createEntityManager();
    	
    	
    	// fin
    	travail.close();
    	factory.close();

	}

}
