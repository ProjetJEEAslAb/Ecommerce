package fr.adaming.service;

import java.util.List;

import javax.ejb.Stateless;

import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateless
public interface IProduitService {

	public List<Produit> GetAllProduits();
	public int deleteProduit (Produit pro);
	public Produit getProduitById(Produit produit);
	

	
	
}
