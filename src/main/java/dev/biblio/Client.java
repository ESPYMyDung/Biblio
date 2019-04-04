package dev.biblio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client
{
	//attribut
	@Id
	@Column(name="ID")
	private int id;
		
	@Column(name="NOM")
	private String nom;
		
	@Column(name="PRENOM")
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private List<Emprunt> empr;
	
	//methode
	public String toString()
	{
		String sortie = new String();
		for (Emprunt loan:empr)
		{
			sortie +="date debut : " +  loan.getDebut() + ", date fin : " + loan.getFin() + ", delai : " + loan.getDelai() + " | ";
		}
		return sortie;
	}
	
	//getter
	public int getId()
	{
		return id;
	}
	
	public String getNom()
	{
		return nom;
	}

	public String getPrenom()
	{
		return prenom;
	}

	public List<Emprunt> getEmprunt()
	{
		return empr;
	}
	
}
