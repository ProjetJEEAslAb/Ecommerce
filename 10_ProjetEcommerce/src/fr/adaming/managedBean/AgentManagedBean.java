package fr.adaming.managedBean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fr.adaming.model.Agent;
import fr.adaming.service.IAgentService;

@ManagedBean(name="aMB")
@RequestScoped
public class AgentManagedBean implements Serializable {

	// ============ 1. Injection de d�pendance Service ============
	@EJB
	private IAgentService agentService;

	// ============ 2. Attributs ============
	// Dans la page
	private Agent agent;

	// ============ 3. Constructeur vide ============
	public AgentManagedBean() {
		this.agent = new Agent();
	}

	// ============ 4. Getters et Setters ============
	public IAgentService getAgentService() {
		return agentService;
	}

	public void setAgentServce(IAgentService agentService) {
		this.agentService = agentService;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	// ============ 5. M�thodes ============
	// TODO seConnecter
	public String seConnecter() {

		try {

			Agent agentOut = agentService.isExist(this.agent);

			// Ajouter l'agent dans la session
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agentSession", agentOut);

			return "accueilAgent";

		} catch (Exception e) {

			// Envoyer un message d'erreur
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Identifiant et/ou mot de passe incorrect"));

			return "accueilGeneral";
		}

	}

	// TODO seDeconnecter
	public String seDeconnecter() {

		// R�cup�rer la session
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "accueilGeneral";
	}

}
