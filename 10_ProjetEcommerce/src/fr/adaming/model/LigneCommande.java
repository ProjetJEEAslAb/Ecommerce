package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ligneComandes")
public class LigneCommande {

	
	//les attributs 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_lic")
	private int id_lc;
	
	@Column(name="qn_lc")
	private int quantite;
	
	@Column(name="prix_lc")
	private int prix;
	

	// associations avec un produit
	@ManyToOne
	@JoinColumn(name="produit_id", referencedColumnName="id_pro")
	private Produit attProduit;
	
	//association avec un panier
	@Transient
	private Panier attPanier;
//=======================================================================//
	
	// les constructeurs

	
	public LigneCommande() {
		super();
	}
	
	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}


	public LigneCommande(int id_lc, int quantite, int prix) {
		super();
		this.id_lc = id_lc;
		this.quantite = quantite;
		this.prix = prix;
	}

//=======================================================================//
	
	//getteurs et setters

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public int getId_lc() {
		return id_lc;
	}

	public void setId_lc(int id_lc) {
		this.id_lc = id_lc;
	}

	public Produit getAttProduit() {
		return attProduit;
	}

	public void setAttProduit(Produit attProduit) {
		this.attProduit = attProduit;
	}

	public Panier getAttPanier() {
		return attPanier;
	}

	public void setAttPanier(Panier attPanier) {
		this.attPanier = attPanier;
	}
	
//=======================================================================//
	


	
}
