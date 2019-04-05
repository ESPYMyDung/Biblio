package dev.banque;

public class Virement extends Operation
{
	//attribut
	private String beneficiaire;

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
