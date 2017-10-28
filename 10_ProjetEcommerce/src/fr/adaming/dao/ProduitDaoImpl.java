package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateless
public class ProduitDaoImpl implements IProduitDao {

	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;

	@Override
	public List<Produit> GetAllProduits() {

		// requete jpql
		String req = "SELECT pro FROM Produit pro";

		// creation du query
		Query query = em.createQuery(req);
		List<Produit> liste = (List<Produit>) query.getResultList();

		return liste;
	}

	// =======================================================================//

	@Override
	public Produit getProduitById(Produit pro) {
		String req = "SELECT pro FROM Produit pro WHERE pro.idProduit=:pIdProduit";
		Query query = em.createQuery(req);
		query.setParameter("pIdProduit", pro.getIdProduit());
		Produit pro_out = (Produit) query.getSingleResult();
		return pro_out;
	}

	// =======================================================================//

	@Override
	public int deleteProduit(Produit pro) {

		String req = " DELETE Produit pro WHERE pro.idProduit=:pId";
		Query query = em.createQuery(req);
		query.setParameter("pId", pro.getIdProduit());
		int verif = query.executeUpdate();
		return verif;
	}

	@Override
	public Produit addProduitByLc(Produit pro) {
		em.persist(pro);
		return pro;
	}

	// ============= Méthodes pour Agent =============
	
	// TODO getProduitByIdByAgent
	@Override
	public Produit getProduitByIdByAgent(Produit pro) throws Exception {

		// 1. Requête
		String req = "SELECT pro FROM Produit pro WHERE pro.idProduit=:pIdProduit";
		Query query = em.createQuery(req);

		// 2. Paramètres
		query.setParameter("pIdProduit", pro.getIdProduit());

		// 3. Résultat
		Produit proFind = (Produit) query.getSingleResult();
		System.out.println("Dao" + proFind.getDesignation());
		return proFind;
	}

	// TODO addProduit
	@Override
	public Produit addProduitByAgent(Produit pro) {

		em.persist(pro);
		return pro;
	}

	// TODO deleteProduit
	@Override
	public Produit deleteProduitByAgent(Produit pro) {

		Produit proDel = em.find(Produit.class, pro.getIdProduit());
		em.remove(proDel);

		return proDel;
	}

	// updateProduit
	@Override
	public Produit updateProduitByAgent(Produit pro) {

		em.merge(pro);

		return pro;
	}

	// TODO getAllProduit
	@Override
	public List<Produit> getAllProduitByAgent(Agent a) {

		// 1. Requête JPQL
		String req = "SELECT pro FROM Produit pro WHERE pro.attAgent.id=:pIdProduit";

		// 2. Création de Query
		Query query = em.createQuery(req);

		// 3. Passage de paramètres
		query.setParameter("pIdProduit", a.getId());

		// 4. Récupérer le résultat
		List<Produit> liste = (List<Produit>) query.getResultList();

		return liste;
	}

}
