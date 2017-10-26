package fr.adaming.dao;

import java.util.List;
import javax.ejb.Local;

import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Local
public interface IProduitDao {
	
	public List<Produit> GetAllProduits();
	
	public int deleteProduit (Produit pro);

		

}
