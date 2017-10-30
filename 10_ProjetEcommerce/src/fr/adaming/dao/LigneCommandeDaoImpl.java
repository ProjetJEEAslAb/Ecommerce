package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Produit;

@Stateless
public class LigneCommandeDaoImpl implements ILigneCommandeDao{
	
	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;

//=======================================================================//

	@Override
	public List<LigneCommande> GetAllLigneCommande(Client c) {

		// requete jpql
		String req = "SELECT lc FROM LigneCommande lc";

		// creation du query
		Query query = em.createQuery(req);
		List<LigneCommande> liste = query.getResultList();

		return liste;
	}

//=======================================================================//
	
	@Override
	public LigneCommande getLigneCommande(LigneCommande lc) {
		
		// requete jpql
		String req = "SELECT lc FROM LigneCommande lc WHERE lc.id_lc=:pIdLc";
		
		// creation du query
		Query query = em.createQuery(req);
		query.setParameter("pIdLc", lc.getId_lc());
		LigneCommande lc_out = (LigneCommande) query.getSingleResult();
		
		return lc_out;
	}

//=======================================================================//

	@Override
	public LigneCommande addLigneCommandePanier(LigneCommande lc) {
		em.persist(lc);
		return lc;
	}

	
//=====================================================================//
	@Override
	public int deleteLigneCommandePanier(LigneCommande lc) {
		String req = " DELETE LigneCommande lc WHERE lc.id_lc=:pId_lc";
		Query query = em.createQuery(req);
		query.setParameter("pId_lc", lc.getId_lc());
		int verif = query.executeUpdate();
		return verif;
	}

	@Override
	public LigneCommande updateLigneCommande(LigneCommande lc) {
		em.merge(lc);
		return lc;
	}

	
	
	

}
