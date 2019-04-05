package dev.banque;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation
{
	//attibut
	@Id
	private int id;
	private LocalDateTime date;
	private double montant;
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;
	
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
