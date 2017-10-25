package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {

	// ============= Méthodes pour Agent =============

	// TODO getCategorieById
	public Categorie getCategorieById(Categorie cat, Agent a) throws Exception;

	// TODO addCategorie
	public Categorie addCategorie(Categorie cat);

	// TODO deleteCategorie
	public Categorie deleteCategorie(Categorie cat, Agent a);

	// TODO updateCategorie
	public Categorie updateCategorie(Categorie cat, Agent a);

	// TODO getAllCategorie
	public List<Categorie> getAllCategorie(Agent a);

//	// TODO getProduitById
//	public Produit getProduitById(Produit pro, Agent a) throws Exception;
//
//	// TODO addCategorie
//	public Produit addProduit(Produit pro);
//
//	// TODO deleteCategorie
//	public Produit deleteProduit(Produit pro, Agent a);
//
//	// TODO updateCategorie
//	public Produit updateProduit(Produit pro, Agent a);
//
//	// TODO getAllCategorie
//	public List<Produit> getAllProduit(Agent a);

}
