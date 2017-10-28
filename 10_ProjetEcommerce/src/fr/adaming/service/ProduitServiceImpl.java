package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IProduitDao;
import fr.adaming.dao.ProduitDaoImpl;
import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateful
public class ProduitServiceImpl implements IProduitService {

	@EJB
	private IProduitDao produitDao = new ProduitDaoImpl();

	// =======================================================================//

	@Override
	public List<Produit> GetAllProduits() {
		return produitDao.GetAllProduits();
	}

	@Override
	public Produit getProduitById(Produit pro) {
		return produitDao.getProduitById(pro);
	}

	@Override
	public int deleteProduit(Produit pro) {
		return produitDao.deleteProduit(pro);
	}

	@Override
	public Produit addProduitByLc(Produit pro) {
		return produitDao.addProduitByLc(pro);
	}
	
	// ============ Méthodes pour Agent ============
	// TODO getProduitByIdByAgent
	@Override
	public Produit getProduitByIdByAgent(Produit pro, Agent a) throws Exception {

		Produit proFind = produitDao.getProduitByIdByAgent(pro);

		if (proFind.getAttAgent().getId() == a.getId()) {
			System.out.println("Service" + proFind.getDesignation());
			return proFind;

		} else {

			return null;
		}
	}

	// TODO deleteProduitByAgent
	@Override
	public Produit deleteProduitByAgent(Produit pro, Agent a) {

		Produit proDel = produitDao.deleteProduitByAgent(pro);

		if (proDel.getAttAgent().getId() == a.getId()) {

			return proDel;

		} else {

			return null;
		}
	}

	// TODO updateProduitByAgent
	@Override
	public Produit updateProduitByAgent(Produit pro, Agent a) {

		Produit proUp = produitDao.updateProduitByAgent(pro);

		if (proUp.getAttAgent().getId() == a.getId()) {

			return proUp;

		} else {

			return null;
		}
	}

	// TODO addProduitByAgent
	@Override
	public Produit addProduitByAgent(Produit pro) {

		return produitDao.addProduitByAgent(pro);
	}

	// TODO getAllProduitByAgent
	@Override
	public List<Produit> getAllProduitByAgent(Agent a) {

		return produitDao.getAllProduitByAgent(a);
	}



}
