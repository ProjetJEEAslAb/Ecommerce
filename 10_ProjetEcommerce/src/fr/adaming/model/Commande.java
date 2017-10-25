package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande implements Serializable{
	
	
	
	//les attributs 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private long id_com;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	
//=======================================================================//
	
	// les constructeurs

	// constructeur vide

	public Commande() {
		super();
	}

	// constructeur sans id

	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	// constructeur avec id

	public Commande(long id_com, Date dateCommande) {
		super();
		this.id_com = id_com;
		this.dateCommande = dateCommande;
	}


//=======================================================================//

	//getteurs et setters
	
	public long getId_com() {
		return id_com;
	}

	public void setId_com(long id_com) {
		this.id_com = id_com;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	
//=======================================================================//
	
	//methode to string
	
	@Override
	public String toString() {
		return "Commande [id_com=" + id_com + ", dateCommande=" + dateCommande + "]";
	}

	

}
