package fr.adaming.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name="cMB")
@RequestScoped
public class ClientManagedBean implements Serializable{
	
	@EJB
	private IClientService clientService;

//=======================================================================//
	
	//les attributs utilisés dans la page 	
	
	private Client client;
	
//=======================================================================//
	
	//Constructeur vide
	public ClientManagedBean() {
		this.client = new Client();//instanciation du client sinon erreur no target unreachable;
	}

//=======================================================================//
	
	// getters et setters

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
//=======================================================================//
	//les methodes metiers
	public String seConnecterClient() {

		try {
			Client client_out = clientService.isExist(this.client);

			// ajouter le client dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientSession", client_out);

			return null;
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("l'identifiant et/ou le mot de passe est erroné"));
		}
		return "echec";
	}
	
//=======================================================================//
	// la mùethode pour se deconnecter

		public String seDeconnecterClient() {

			// recuperer la session et la fermé

			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
			return "login";

		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
