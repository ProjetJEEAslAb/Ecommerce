package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Local
public interface ICategorieDao {

	// ============= M�thodes pour Agent =============
	
	// TODO getCategorieById
	public Categorie getCategorieById(Categorie cat) throws Exception;

	// TODO addCategorie
	public Categorie addCategorie(Categorie cat);

	// TODO deleteCategorie
	public Categorie deleteCategorie(Categorie cat);

	// TODO updateCategorie
	public Categorie updateCategorie(Categorie cat);

	// ============= M�thodes pour Client =============

}
