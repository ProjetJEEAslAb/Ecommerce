package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ILigneCommandeDao;
import fr.adaming.dao.LigneCommandeDaoImpl;
import fr.adaming.model.LigneCommande;

@Stateful
public class LigneCommandeServiceImpl implements ILigneCommandeService {

	@EJB
	private ILigneCommandeDao LigneCommandeDao= new LigneCommandeDaoImpl();
	
// =======================================================================//

	@Override
	public List<LigneCommande> GetAllLigneCommande() {
		return LigneCommandeDao.GetAllLigneCommande();
	}

	@Override
	public LigneCommande getLigneCommande(LigneCommande lc) {
		return LigneCommandeDao.getLigneCommande(lc);
	}

	@Override
	public LigneCommande addLigneCommandePanier(LigneCommande lc) {
		
		return LigneCommandeDao.addLigneCommandePanier(lc);
	}
	
	
}
