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
    	
    	//--trouver un livre a partir de son id--
    	Livre bouquin = travail.find(Livre.class,4);
    	System.out.println(bouquin.getAuteur());

    	//--requete pour extraire un livre a partie du titre--
    	TypedQuery<Livre> requeteLivre = travail.createQuery(
    			"select l from Livre l where TITRE=:ref", Livre.class);
    	requeteLivre.setParameter("ref", "Germinal");
    	
    	List<Livre> listeLivre = requeteLivre.getResultList();
    	listeLivre.forEach(books -> {
			System.out.println(books.getId() + " - "  + books.getTitre() + " - " + books.getAuteur());
		});
    	
    	//--requete pour extraire un emprunt et ses livres--
    	TypedQuery<Emprunt> requeteEmprunt = travail.createQuery(
    			"select e from Emprunt e where ID=:ref", Emprunt.class);
    	requeteEmprunt.setParameter("ref", 2);
    	
    	List<Emprunt> listeEmprunt = requeteEmprunt.getResultList();
    	
    	for (Emprunt empr:listeEmprunt)
    	{
    		System.out.println(empr);
    	}
    	
    	//--requete pour extraire les emprunts d'un client-- 	
    	TypedQuery<Client> requete = travail.createQuery(
    			"select c from Client c where ID=:ref", Client.class);
    	requete.setParameter("ref", 2);
    	
    	List<Client> liste = requete.getResultList();
    	
    	for (Client cust:liste)
    	{
    		//System.out.println(cust.getNom() + " " + cust.getPrenom());
    		System.out.println(cust);
    	}

    			
    	// fin
    	travail.close();
    	factory.close();
    	
    }
}
