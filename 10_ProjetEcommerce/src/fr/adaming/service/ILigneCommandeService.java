package fr.adaming.service;

import java.util.List;

import fr.adaming.model.LigneCommande;

public interface ILigneCommandeService {

	public List<LigneCommande> GetAllLigneCommande();

	public LigneCommande getLigneCommande(LigneCommande lc);
	
	public LigneCommande addLigneCommandePanier(LigneCommande lc);
}
