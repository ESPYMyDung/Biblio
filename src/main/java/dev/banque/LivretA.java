package dev.banque;

import javax.persistence.Entity;

@Entity
public class LivretA extends Compte
{
	//attribut
	private double taux;
	
	//constructeur
	public LivretA(){}
	
	public LivretA(String num, double solde,double taux)
	{
		super(num,solde);
		this.taux = taux;
	}

	//getter
	public double getTaux()
	{
		return taux;
	}

	//setter
	public void setTaux(double taux)
	{
		this.taux = taux;
	}
}
