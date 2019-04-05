package dev.banque;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Banque
{
	//attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy="banq")
	private List<Cust> custs;
	
	//constructeur
	public Banque(){}
	
	public Banque(String nom)
	{
		this.nom = nom;
	}
	
	//getter
	public String getNom()
	{
		return nom;
	}

	//setter
	public void setNom(String nom)
	{
		this.nom = nom;
	}
}
