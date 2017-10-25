package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;

@Local
public interface ICategorieDao {

	// ============= M�thodes pour Agent =============
	// TODO getAllClient
	public List<Categorie> getAllCategoriesByAgent(Agent a);

	// ============= M�thodes pour Client =============
	public List<Categorie> getAllCategories();

	public Client getProduitByCategories(Categorie ca);

}
