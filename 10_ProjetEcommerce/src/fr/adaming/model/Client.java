package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable {

	// declaration des attributs

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long id;
	private String nom;
	private String Client;
	private String mail;
	private String tel;
	
	
//=======================================================================//
	
	//transformation de l'association uml en java
	@OneToMany(mappedBy="client")
	private List<Commande> listeCommande;
	
//=======================================================================//
	
	// declarations des constructeurs

	public Client() {
		super();
	}

	// constructeur sans id
	public Client(String nom, String client, String mail, String tel) {
		super();
		this.nom = nom;
		Client = client;
		this.mail = mail;
		this.tel = tel;
	}

	// constructeur avec id

	public Client(Long id, String nom, String client, String mail, String tel) {
		super();
		this.id = id;
		this.nom = nom;
		Client = client;
		this.mail = mail;
		this.tel = tel;
	}
	
//=======================================================================//

	// declaration des getters et setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


//=======================================================================//
	//methode toString
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", Client=" + Client + ", mail=" + mail + ", tel=" + tel + "]";
	}

}
