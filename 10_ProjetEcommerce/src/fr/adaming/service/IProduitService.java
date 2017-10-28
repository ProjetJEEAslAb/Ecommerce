package fr.adaming.service;

import java.util.List;

import javax.ejb.Stateless;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateless
public interface IProduitService {

	public List<Produit> GetAllProduits();

	public int deleteProduit(Produit pro);

	public Produit getProduitById(Produit pro);
	
	public Produit addProduitByLc(Produit pro);
	

	// ============= Méthodes pour Agent =============

	// TODO getProduitByIdByAgent
	public Produit getProduitByIdByAgent(Produit pro, Agent a) throws Exception;

	// TODO addProduitByAgent
	public Produit addProduitByAgent(Produit pro);

	// TODO deleteProduitByAgent
	public Produit deleteProduitByAgent(Produit pro, Agent a);

	// TODO updateProduitByAgent
	public Produit updateProduitByAgent(Produit pro, Agent a);

	// TODO getAllProduitByAgent
	public List<Produit> getAllProduitByAgent(Agent a);

}
