package fr.adaming.managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name="catMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {

	// ============ 1. Injection de d�pendance Service ============
	@EJB
	private ICategorieService categorieService;

	// ============ 2. Attributs ============
	private Agent agent;
	private Categorie categorie;
	
	private HttpSession agentSession;

	// ============ 3. Constructeur vide ============
	public CategorieManagedBean() {
		this.agent = new Agent();
		this.categorie = new Categorie();
	}

	// Ex�cuter la m�thode juste apr�s l'instanciation du MB
	@PostConstruct
	public void init() {

		// R�cup�ration du contexte
		FacesContext context = FacesContext.getCurrentInstance();

		// R�cup�ration de la session
		this.agentSession = (HttpSession) context.getExternalContext().getSession(false);
		// R�cup�ration de l'agent � partir de la session
		this.agent = (Agent) agentSession.getAttribute("agentSession");

	}

	// ============ 4. Getters et Setters ============
	public ICategorieService getCategorieService() {
		return categorieService;
	}

	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	// ============ 5. M�thodes ============

}
