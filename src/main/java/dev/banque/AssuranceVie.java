package dev.banque;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte
{
	//attribut
	private LocalDate dateFin;
	private double taux;
	
	//constructeur
	public AssuranceVie(){}
	
	public AssuranceVie(String num, double solde, String date, double taux)
	{
		super(num,solde);
		this.dateFin = LocalDate.parse(date);
		this.taux = taux;
	}
	
	//getter
	public LocalDate getDateFin()
	{
		return dateFin;
	}
	
	public double getTaux()
	{
		return taux;
	}
	
	//setter
	public void setDateFin(LocalDate dateFin)
	{
		this.dateFin = dateFin;
	}
	
	public void setTaux(double taux)
	{
		this.taux = taux;
	}
}
