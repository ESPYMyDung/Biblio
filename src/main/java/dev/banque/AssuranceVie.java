package dev.banque;

import java.time.LocalDate;

public class AssuranceVie extends Compte
{
	//attribut
	private LocalDate dateFin;
	private double taux;
	
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
