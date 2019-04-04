package dev.biblio;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt
{
	//attribut
	@Id
	@Column(name="ID")
	private int id;

	@Column(name="DATE_DEBUT")
	private LocalDateTime debut;

	@Column(name="DATE_FIN")
	private LocalDateTime fin;
	
	@Column(name="DELAI")
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="compo",
				joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
				inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID") )
	private List<Livre> books;
	
	//methode
	public String toString()
	{
		String sortie = new String();
		for (Livre livre:books)
		{
			sortie +="titre : " +  livre.getTitre() + ", auteur : " + livre.getAuteur() + " | ";
		}
		return sortie;
	}
	
	//getter
	public int getId()
	{
		return id;
	}

	public LocalDateTime getDebut()
	{
		return debut;
	}

	public LocalDateTime getFin()
	{
		return fin;
	}

	public int getDelai()
	{
		return delai;
	}

	public Client getClient()
	{
		return client;
	}

	public List<Livre> getLivre()
	{
		return books;
	}
		

}
