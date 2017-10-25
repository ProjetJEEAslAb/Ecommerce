package fr.adaming.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.jms.Session;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name = "cMB")
@RequestScoped
public class ClientManagedBean implements Serializable {

	// Injecter un EJB Service (injection de dépendance)
	@EJB
	private IClientService clientService;

	// Attributs utilisés dans la page
	private Agent agent;
	private Client client;

	private boolean indice = false;

	// 1.3 Récupérer la session
	HttpSession agentSession;

	// Constructeur vide
	public ClientManagedBean() {
		agent = new Agent();
		client = new Client();
	}

	// Exécuter la méthode juste après l'instanciation du MB
	@PostConstruct
	public void init() {

		// Récupération du contexte
		FacesContext context = FacesContext.getCurrentInstance();

		// Récupération de la session
		this.agentSession = (HttpSession) context.getExternalContext().getSession(false);
		// Récupération de l'agent à partir de la session
		this.agent = (Agent) agentSession.getAttribute("agentSession");

	}

	// Getters et Setters
	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public HttpSession getAgentSession() {
		return agentSession;
	}

	public void setAgentSession(HttpSession agentSession) {
		this.agentSession = agentSession;
	}

	public boolean isIndice() {
		return indice;
	}

	public void setIndice(boolean indice) {
		this.indice = indice;
	}

	// Autres méthodes

	// TODO addClient
	public String addClient() {

		this.agent = (Agent) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agentSession");
		Client cAdd = clientService.addClient(this.client, this.agent);

		if (cAdd.getId() != 0) {
			// Actualiser la liste à afficher
			List<Client> liste = clientService.getAllClient(this.agent);
			agentSession.setAttribute("clientsListe", liste);

			return "index";

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout a échoué"));
			return "add";
		}

	}

	// TODO deleteClient
	public String deleteClient() {

		this.agent = (Agent) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agentSession");

		try {
			Client cDel = clientService.findClient(this.client, this.agent);
			Client cVerif = clientService.deleteClient(cDel, this.agent);

			if (cVerif != null) {
				// Actualiser la liste à afficher
				List<Client> liste = clientService.getAllClient(this.agent);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientsListe", liste);

				return "index";

			} else {

				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La suppression a échoué"));
				return "delete";
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le client n'existe pas"));
			return "delete";
		}
	}

	// TODO findClient
	public String findClient() {

		this.agent = (Agent) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agentSession");

		try {
			this.client = clientService.findClient(this.client, this.agent);
			this.indice = true;
			return "find";

		} catch (Exception e) {

			this.indice = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le client n'existe pas"));
			return "find";
		}
	}

	// TODO updateClient
	public String updateClient() {

		this.agent = (Agent) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agentSession");

		try {
			Client cModif = clientService.findClient(this.client, this.agent);

			cModif.setNom(this.client.getNom());
			cModif.setPrenom(this.client.getPrenom());
			cModif.setDateNaissance(this.client.getDateNaissance());
			clientService.updateClient(cModif, this.agent);

			System.out.println("MB" + cModif);

			// Actualiser la liste à afficher
			List<Client> liste = clientService.getAllClient(this.agent);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clientsListe", liste);

			return "index";

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le client n'existe pas"));
			return "update";
		}
	}

}
