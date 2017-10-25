package fr.adaming.dao;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Produit;

@Local
public interface IAgentDao {
	
	public Agent isExist(Agent a);
	
	public Agent addAgent(Agent a);
	
	public Produit getAllProduit(Agent a);
	
	public Produit findProduitById(Produit p, Agent a);
	
	public Produit addProduit(Produit p, Agent a);
	
	public Produit deleteProduit(Produit p, Agent a);
	
	public Produit updateProduit(Produit p, Agent a);

}
