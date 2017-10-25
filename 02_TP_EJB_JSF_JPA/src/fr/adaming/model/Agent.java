package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent implements Serializable {

	// ============ 1. Attributs ============
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agent")
	private int id;

	@Column(name = "mail_agent")
	private String mail;

	@Column(name = "mdp_agent")
	private String mdp;

	// Association UML avec plusieurs Client
	@OneToMany(mappedBy = "agent", cascade=CascadeType.REMOVE)
	private List<Client> listeClients;

	// ============ 2. Constructeurs ============
	public Agent() {
		super();
	}

	public Agent(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Agent(int id, String mail, String mdp) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
	}

	// ============ 3. Getters et Setters ============
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	// ============ 4. Autres méthodes ============

}
