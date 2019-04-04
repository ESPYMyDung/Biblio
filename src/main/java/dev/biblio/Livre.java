package dev.biblio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre
{
	//attribut
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="TITRE")
	private String titre;
	
	@Column(name="AUTEUR")
	private String auteur;
	
	@ManyToMany(mappedBy="books")
	private List<Emprunt> loan;
	
	
	//getter
	public int getId()
	{
		return id;
	}
	
	public String getTitre()
	{
		return titre;
	}
	
	public String getAuteur()
	{
		return auteur;
	}

	public List<Emprunt> getEmprunt()
	{
		return loan;
	}
	

}
