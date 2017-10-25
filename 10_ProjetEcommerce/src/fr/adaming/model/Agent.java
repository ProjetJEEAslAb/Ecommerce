package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agents")
public class Agent implements Serializable {

	// ============ 1. Attributs ============
	@Id
	@Column(name = "id_a")
	private int id;

	@Column(name = "mail_a")
	private String mail;
	@Column(name = "mdp_a")
	private String mdp;

	// ============ 2. Constructeurs ============
	// Vide
	public Agent() {
		super();
	}

	// Sans id
	public Agent(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	// Avec id
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

	// ============ 4. Méthode toString ============
	@Override
	public String toString() {
		return "Agent [id=" + id + ", mail=" + mail + ", mdp=" + mdp + "]";
	}

}
