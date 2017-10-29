package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.LigneCommande;


@Local
public interface ILigneCommandeDao {

	public List<LigneCommande> GetAllLigneCommande();
	
	public LigneCommande getLigneCommande(LigneCommande lc);
	
	public LigneCommande addLigneCommandePanier(LigneCommande lc);
	
	public int deleteLigneCommandePanier(LigneCommande lc);
	
	
}
