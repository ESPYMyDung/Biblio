package dev.banque;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque
{
	//attribut
	@Id
	private int id;
	
	private String nom;
	
	@OneToMany(mappedBy="banq")
	private List<Cust> custs;
	

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
