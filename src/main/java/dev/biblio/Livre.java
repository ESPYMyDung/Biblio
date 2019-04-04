package dev.biblio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Livre
{
	//attribut
	@Id
	@Table
	private int id;

}
