package dev.biblio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	//getter
	public String getTitre()
	{
		return titre;
	}
	
	public String getAuteur()
	{
		return auteur;
	}

	public int getId()
	{
		return id;
	}
	
	/*
	//setter
	public void setTitre(String titre)
	{
		this.titre = titre;
	}
	
	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
	}
	*/
	
	

}
