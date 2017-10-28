package fr.adaming.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.LigneCommandeServiceImpl;


@ManagedBean(name="lcMB")
@ViewScoped
public class LigneCommandeManagedBean {

// =======================================================================//
	// injection dependance
	@EJB
	private ILigneCommandeService ligneCommandeService;
	
// =======================================================================//
	// attributs
	
	private Panier attPanier;
	private List<LigneCommande> listeLigneCommande;
	private LigneCommande ligneCommande;
	
	// Pour l'affichage des tables
	private boolean indice = false;
// =======================================================================//
	// constructeur vide	
	
	public LigneCommandeManagedBean() {
		this.attPanier=new Panier();
		this.ligneCommande = new LigneCommande();
	}
	
// =======================================================================//
	
	@PostConstruct
	public void init() {	
		FacesContext context = FacesContext.getCurrentInstance();
	this.listeLigneCommande = ligneCommandeService.GetAllLigneCommande();
	}


// =======================================================================//
	// getters et setters
	
	public ILigneCommandeService getLigneCommandeService() {
		return ligneCommandeService;
	}

	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	public Panier getAttPanier() {
		return attPanier;
	}

	public void setAttPanier(Panier attPanier) {
		this.attPanier = attPanier;
	}

	public List<LigneCommande> getListeLigneCommande() {
		return listeLigneCommande;
	}

	public void setListeLigneCommande(List<LigneCommande> listeLigneCommande) {
		this.listeLigneCommande = listeLigneCommande;
	}

	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	 
// =======================================================================//
	//methodes

	public String getLigneCommande(LigneCommande lc){
		
		try {
			// trouver le la ligne de commande que l'on cherche
			this.ligneCommande = ligneCommandeService.getLigneCommande(this.ligneCommande);
			this.indice = true;
			return "rechercheLigneCommande";

		} catch (Exception e) {
			this.indice = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la recherche de la ligne de commande a échoué"));
			return "rechercheLigneCommande";
		}

	}
	
	public String addLigneCommande(LigneCommande lc) {

		try {
			// Ajouter les informations dans this.panier
			this.ligneCommande = ligneCommandeService.addLigneCommandePanier(this.ligneCommande);
			return "accueilClient";

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout a échoué"));
			return "ajoutLigneCommande";

		}

	}
}
