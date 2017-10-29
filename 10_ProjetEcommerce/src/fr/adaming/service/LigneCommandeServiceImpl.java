package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.dao.LigneCommandeDaoImpl;
import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService {

	@EJB
	private ILigneCommandeDao LigneCommandeDao;
	
// =======================================================================//

	@Override
	public List<LigneCommande> GetAllLigneCommande(Client c) {
		
		return LigneCommandeDao.GetAllLigneCommande(c);
	}

	@Override
	public LigneCommande getLigneCommande(LigneCommande lc) {
		return LigneCommandeDao.getLigneCommande(lc);
	}

	@Override
	public LigneCommande addLigneCommandePanier(LigneCommande lc) {
		return LigneCommandeDao.addLigneCommandePanier(lc);
	}

	@Override
	public int deleteLigneCommandePanier(LigneCommande lc) {
		
		return LigneCommandeDao.deleteLigneCommandePanier(lc) ;
	}

	@Override
	public LigneCommande updateLigneCommande(LigneCommande lc) {
		return LigneCommandeDao.updateLigneCommande(lc);
	}
	
	
}
