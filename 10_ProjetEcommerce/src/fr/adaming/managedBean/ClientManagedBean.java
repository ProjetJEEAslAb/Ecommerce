package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
	HttpSession session;
	
//=======================================================================//
	
	//Constructeur vide
	public ClientManagedBean() {
		this.client = new Client();//instanciation du client sinon erreur no target unreachable;
	}
	
//=======================================================================//	
//creation de la session client
	
	public void sessionClient(){
		
		// recuperation du context
		FacesContext context = FacesContext.getCurrentInstance();
		// recuperer la session a partir du context
		this.session = (HttpSession) context.getExternalContext().getSession(false);

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

			return "login";
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("l'identifiant et/ou le mot de passe est erroné"));
		}
		return "accueilGeneral";
	}
	

	// la methode pour se deconnecter

		public String seDeconnecterClient() {

			// recuperer la session et la fermé

			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			
			return "login";

		}
	
//=======================================================================//	
		public String ajouterClient(){
			
			//appelle de la methode pour ajouter un client
			Client cl=clientService.addClient(this.client);
			return null;
			
			
			
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
