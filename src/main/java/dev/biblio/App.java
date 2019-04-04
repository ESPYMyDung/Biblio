package dev.biblio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



//import dev.Livre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //creer un EntityManagerFactory
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Biblio");
    	
    	//creer une unite de travail
    	EntityManager travail = factory.createEntityManager();
    	
    	//Livre bouquin = travail.find(Livre.class,4);
    	//System.out.println(bouquin.getAuteur());

    	
    	TypedQuery<Livre> requete = travail.createQuery(
    			"select l from Livre l where TITRE=:ref", Livre.class);
    	requete.setParameter("ref", "Germinal");
    	
    	List<Livre> liste = requete.getResultList();

    	liste.forEach(bouquin -> {
			System.out.println(bouquin.getId() + " - "  + bouquin.getTitre() + " - " + bouquin.getAuteur());
		});
    			
    	// fin
    	travail.close();
    	factory.close();
    	
    }
}
