package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.dao.ProduitDaoImpl;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService{
	
	@EJB
	private IProduitDao produitDao=new ProduitDaoImpl();
	
//=======================================================================//	
	
	@Override
	public List<Produit> GetAllProduits() {
		return produitDao.GetAllProduits();
	}

	@Override
	public int deleteProduit(Produit pro) {
		return produitDao.deleteProduit(pro);
	}

	@Override
	public Produit getProduitById(Produit produit) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
