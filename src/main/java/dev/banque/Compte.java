package dev.banque;

import java.util.List;

//import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
	
	//constructeur
	public Compte(){}
	
	public Compte(String num, double solde)
	{
		this.numero = num;
		this.solde = solde;
	}
	
	
	//getter
	public String getNumero()
	{
		return numero;
	}
	
	public double getSolde()
	{
		return solde;
	}
	
	public List<Operation> getOps()
	{
		return op;
	}
	
	public List<Cust> getClients()
	{
		return custs;
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
	
	public void setOps(List<Operation> op)
	{
		this.op = op;
	}
	
	public void setCust(List<Cust> custs)
	{
		this.custs = custs;
	}

}
