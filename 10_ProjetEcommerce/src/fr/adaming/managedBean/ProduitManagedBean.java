package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name="pMB")
@ViewScoped
public class ProduitManagedBean implements Serializable{

//=======================================================================//
	//injection dependance
	@EJB
	private IProduitService produitService;
	
//=======================================================================//
	//attributs
	private Produit produit;
	private List<Produit> listeProduit;
	private Client client;
	private LigneCommande ligneCommande;
	private List<Produit> selectedProduits;
	private HttpSession clientSession;
	
	// Pour l'affichage des tables
	private boolean indice = false;
//=======================================================================//
	//constructeur vide

	public ProduitManagedBean() {
		this.client=new Client();
		this.produit=new Produit();
	}
//=======================================================================//
	public void init() {
		
		// Récupération du contexte
		FacesContext context = FacesContext.getCurrentInstance();
		
		// Récupération de la session
		this.clientSession=(HttpSession) context.getExternalContext().getSession(false);
		
		//recuperation du client a partir de la session
		this.client=(Client) clientSession.getAttribute("clientSession");
		this.listeProduit=produitService.GetAllProduits(this.client);
	}

//=======================================================================//
		//getters et setters
	
	public IProduitService getProduitService() {
		return produitService;
	}
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public List<Produit> getListeProduit() {
		return listeProduit;
	}
	public void setListeProduit(List<Produit> listeProduit) {
		this.listeProduit = listeProduit;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}
	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}
	public List<Produit> getSelectedProduits() {
		return selectedProduits;
	}
	public void setSelectedProduits(List<Produit> selectedProduits) {
		this.selectedProduits = selectedProduits;
	}
	public HttpSession getClientSession() {
		return clientSession;
	}
	public void setClientSession(HttpSession clientSession) {
		this.clientSession = clientSession;
	}
	public boolean isIndice() {
		return indice;
	}
	public void setIndice(boolean indice) {
		this.indice = indice;
	}	

//=======================================================================//

	//les methodes
	public String deleteProduit(){
		
		this.client=(Client) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clientsession");
		
		try{
		
		return null;
		}catch(Exception e){
			
		}
		return null;
		
	}
	
	
	
}
