package dev.banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Cust
{
	//attribut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	@Embedded
	private Adresse adresse;
	
	@ManyToMany(mappedBy="custs")
	private List<Compte> comptes;
	
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banq;
	
	//constructeur
	public Cust(){}
	
	public Cust(String nom, String prenom, String date, Adresse adr)
	{
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = LocalDate.parse(date);
		this.adresse = adr;
	}
	
	//getter
	public String getNom()
	{
		return nom;
	}
	
	public String getPrenom()
	{
		return prenom;
	}
	
	public LocalDate getDateNss()
	{
		return dateNaissance;
	}
	
	
	//setter
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}
	
	public void setDateNss(LocalDate dateNaissance)
	{
		this.dateNaissance = dateNaissance;
	}

}
