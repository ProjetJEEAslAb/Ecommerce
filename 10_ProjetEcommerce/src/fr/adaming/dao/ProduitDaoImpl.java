package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao{

	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;
	
	@Override
	public List<Produit> GetAllProduits(Client cl) {
		
		//requete jpql
		
		String req = "SELECT pro FROM Produit pro WHERE cl.id=:pId";
		
		//creation du query
		Query query = em.createQuery(req);
		
		//passage des parametres
		query.setParameter("pId", cl.getId());
		
		List<Produit> liste = (List<Produit>) query.getResultList();
		
		return liste;
	}

	@Override
	public int deleteProduit(Produit pro) {
		
		String req= " DELETE Produit pro WHERE pro.idProduit=:pId";	
		Query query = em.createQuery(req);
		query.setParameter("pId", pro.getIdProduit());
		int verif=query.executeUpdate();
		return verif;
	}

	
	
}
