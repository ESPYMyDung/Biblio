package dev.banque;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Compte
{
	//attribut
	@Id
	private String numero;
	private double solde;
	
	@OneToMany(mappedBy="compte")
	private List<Operation> op;
	
	@ManyToMany
	@JoinTable(name="compt_cli",
				joinColumns=@JoinColumn(name="id_compte",referencedColumnName="numero"),
				inverseJoinColumns=@JoinColumn(name="id_client",referencedColumnName="id") )
	private List<Cust> custs;
	
	
	//getter
	public String getNumero()
	{
		return numero;
	}
	
	public double getSolde()
	{
		return solde;
	}
	
	//setter
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public void setSolde(double solde)
	{
		this.solde = solde;
	}

}
