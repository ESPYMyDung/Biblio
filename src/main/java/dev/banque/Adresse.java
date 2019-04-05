package dev.banque;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse
{
	//attribut
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	
	//getter
	public int getNumero()
	{
		return numero;
	}
	
	public String getRue()
	{
		return rue;
	}
	
	public int getCodePostal()
	{
		return codePostal;
	}
	
	public String getVille()
	{
		return ville;
	}
	
	
	//setter
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public void setRue(String rue)
	{
		this.rue = rue;
	}
	
	public void setCodePostal(int codePostal)
	{
		this.codePostal = codePostal;
	}
	
	public void setVille(String ville)
	{
		this.ville = ville;
	}
}
