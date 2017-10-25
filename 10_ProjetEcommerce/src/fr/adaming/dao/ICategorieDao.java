package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Local
public interface ICategorieDao {

	// ============= Méthodes pour Agent =============

	// TODO getCategorieById
	public Categorie getCategorieById(Categorie cat) throws Exception;

	// TODO addCategorie
	public Categorie addCategorie(Categorie cat);

	// TODO deleteCategorie
	public Categorie deleteCategorie(Categorie cat);

	// TODO updateCategorie
	public Categorie updateCategorie(Categorie cat);

	// TODO getAllCategorie
	public List<Categorie> getAllCategorie(Agent a);

//	// TODO getProduitById
//	public Produit getProduitById(Produit pro) throws Exception;
//
//	// TODO addProduit
//	public Produit addCategorie(Categorie cat);
//
//	// TODO deleteProduit
//	public Produit deleteProduit(Categorie cat);
//
//	// TODO updateProduit
//	public Produit updateProduit(Categorie cat);
//
//	// TODO getAllProduit
//	public List<Produit> getAllProduit(Agent a);

	// ============= Méthodes pour Client =============

}
