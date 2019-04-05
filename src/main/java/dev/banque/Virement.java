package dev.banque;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Virement extends Operation
{
	//attribut
	private String beneficiaire;
	
	//constructeur
	public Virement(){}
	
	public Virement(String date, double montant, String motif, String benef)
	{
		super(date,montant, motif);
		this.beneficiaire = benef;
	}

	//getter
	public String getBeneficiaire()
	{
		return beneficiaire;
	}

	//setter
	public void setBeneficiaire(String beneficiaire)
	{
		this.beneficiaire = beneficiaire;
	}

}
