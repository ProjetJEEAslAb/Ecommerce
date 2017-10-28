package fr.adaming.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.adaming.model.Categorie;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;
import fr.adaming.service.LigneCommandeServiceImpl;


@ManagedBean(name="lcMB")
@ViewScoped
public class LigneCommandeManagedBean {

// =======================================================================//
	// injection dependance
	@EJB
	private ILigneCommandeService ligneCommandeService;
	@EJB
	private IProduitService prodService;
// =======================================================================//
	// attributs
	
	private Panier attPanier;
	private List<LigneCommande> listeLigneCommande;
	private Long id_produit;
	private LigneCommande ligneCommande;
	
	// Pour l'affichage des tables
	private boolean indice = false;
// =======================================================================//
	// constructeur vide	
	
	public LigneCommandeManagedBean() {
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
	 
	public boolean isIndice() {
		return indice;
	}

	public void setIndice(boolean indice) {
		this.indice = indice;
	}

	public Long getId_produit() {
		return id_produit;
	}

	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}

// =======================================================================//
	//methodes


	public String rechercherLigneCommande(){
		
		try {
			// trouver le la ligne de commande que l'on cherche
			this.ligneCommande = ligneCommandeService.getLigneCommande(this.ligneCommande);
			this.indice = true;
			return "rechercherLigneCommande";

		} catch (Exception e) {
			this.indice = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("la recherche de la ligne de commande a échoué"));
			return "rechercherLigneCommande";
		}

	}
	
	public String ajouterLigneCommande() {

		try {
			// Ajouter les informations dans this.panier
			Produit prodAjout = new Produit();
			prodAjout.setIdProduit(this.id_produit);
			this.ligneCommande.setAttProduit(prodAjout);
			prodAjout=prodService.getProduitById(prodAjout);
			this.ligneCommande.setPrix(prodAjout.getPrix()*this.ligneCommande.getQuantite());
			this.ligneCommande = ligneCommandeService.addLigneCommandePanier(this.ligneCommande);
			return "panier";

		} catch (Exception e) {

			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("L'ajout a échoué"));
			return "ajouterLigneCommande";

		}

	}
	
	public String Valider() {

		this.listeLigneCommande = ligneCommandeService.GetAllLigneCommande();

		double sommePrixTotal = 0;
		for (LigneCommande ligne : this.listeLigneCommande) {
			if (!ligne.isValide()) {

				Produit prodValide = ligne.getAttProduit();
				prodValide = prodService.getProduitById(prodValide);

				prodValide.setQuantite(prodValide.getQuantite() - ligne.getQuantite());
				if (prodValide.getQuantite() > 0) {

					sommePrixTotal = sommePrixTotal + ligne.getPrix();
					ligne.setValide(true);
					

				} else if (prodValide.getQuantite() == 0) {

					sommePrixTotal = sommePrixTotal + ligne.getPrix();
					ligne.setValide(true);
					prodService.deleteProduit(prodValide);
					

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("stock epuise"));
					return "panier";
				}
			}else{
				continue;
			}

		}
		return "accueilGeneral";
		
	}
}