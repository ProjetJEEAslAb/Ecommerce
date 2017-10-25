package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IClientService;

@ManagedBean(name = "aMB")
@RequestScoped
public class AgentManagedBean implements Serializable {

	// Injecter un EJB Service (injection de dépendance)
	@EJB
	private IAgentService agentService;
	@EJB
	private IClientService clientService;

	// Attributs utilisés dans la page
	private Agent agent;
	private List<Client> listeClients;

	// Constructeur vide
	public AgentManagedBean() {
		this.agent = new Agent();
	}

	// Getters et Setters
	public IAgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(IAgentService agentService) {
		this.agentService = agentService;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	// Méthodes

	// TODO seConnecter
	public String seConnecter() {

		try {

			Agent agentOut = agentService.isExist(this.agent);

			// Récupération de la liste des clients
			List<Client> liste = clientService.getAllClient(agentOut);
			
			// Ajouter la liste des clients dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientsListe", liste);
			
			// Ajouter l'agent dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agentSession", agentOut);

			return "succes";

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Identifiant et/ou mot de passe incorrect"));

			return "echec";
		}

	}

	// TODO inscrire
	public String inscrire() {

		try {
			agentService.addAgent(this.agent);

			return "login";

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Echec de l'inscription"));

			return "register";
		}

	}
	
	// TODO seDeconnecter
	public String seDeconnecter(){
		
		// Récupérer la session
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		return "login";
	}

}
