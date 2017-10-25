package fr.adaming.managedBean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.service.ICategorieService;

@ManagedBean(name = "catMB")
@RequestScoped
public class CategorieManagedBean implements Serializable {

	// ============ 1. Injection de dépendance Service ============
	@EJB
	private ICategorieService categorieService;

	// ============ 2. Attributs ============
	private Agent agent;
	private Categorie categorie;

	private HttpSession agentSession;

	// Pour l'affichage des tables
	private boolean indice = false;

	// ============ 3. Constructeur vide ============
	public CategorieManagedBean() {
		this.agent = new Agent();
		this.categorie = new Categorie();
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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

	// ============ 5. Méthodes ============

	// TODO getCategorieById

	public String getCategorieById() {

		// Récupérer l'agent de la session
		this.agent = (Agent) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("agentSession");
		this.categorie.setAttAgent(this.agent);
		
		try {

			this.categorie = categorieService.getCategorieById(this.categorie, this.agent);
			System.out.println(this.categorie);
			this.indice = true;

			return "findAgent";

		} catch (Exception e) {

			this.indice = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("La catégorie n'existe pas"));
			return "find";

		}

	}

}
