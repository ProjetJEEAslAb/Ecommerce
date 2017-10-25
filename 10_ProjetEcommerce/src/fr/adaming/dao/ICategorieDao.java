package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public interface ICategorieDao {

	public List<Categorie> GetAllCategories();
	public List<Produit> GetAllProduits();
	
	public Client getProduitByCategories( Categorie ca);
	

}
