package dev.banque;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@DiscriminatorValue("O")
public class Operation
{
	//attibut
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date;
	private double montant;
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;
	
	//constructeur
	public Operation(){}
	
	public Operation(String date, double montant, String motif)
	{
		this.date = LocalDateTime.parse(date);
		this.montant = montant;
		this.motif = motif;
	}
	
	//getter
	public LocalDateTime getDate()
	{
		return date;
	}
	
	public double getMontant()
	{
		return montant;
	}
	
	public String getMotif()
	{
		return motif;
	}
	
	
	//setter
	public void setDate(LocalDateTime date)
	{
		this.date = date;
	}
	
	public void setMontant(double montant)
	{
		this.montant = montant;
	}
	
	public void setMotif(String motif)
	{
		this.motif = motif;
	}
}
