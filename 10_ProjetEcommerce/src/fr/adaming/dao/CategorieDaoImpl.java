package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	// ============ 1. Injecter un EntityManager ============
	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;

	// ============ 2. Méthodes ============
	// TODO getCategorieById
	@Override
	public Categorie getCategorieById(Categorie cat) throws Exception {

		// 1. Requête
		String req = "SELECT cat FROM Categorie cat WHERE cat.idCategorie =:pIdCategorie";
		Query query = em.createQuery(req);

		// 2. Paramètres
		query.setParameter("pIdCategorie", cat.getIdCategorie());

		// 3. Résultat
		Categorie catFind = (Categorie) query.getSingleResult();
		return catFind;
	}

	// TODO addCategorie
	@Override
	public Categorie addCategorie(Categorie cat) {

		em.persist(cat);
		return cat;
	}

	// TODO deleteCategorie
	@Override
	public Categorie deleteCategorie(Categorie cat) {

		Categorie catDel = em.find(Categorie.class, cat.getIdCategorie());
		em.remove(catDel);

		return catDel;
	}

	// updateCategorie
	@Override
	public Categorie updateCategorie(Categorie cat) {

		em.merge(cat);

		return cat;
	}

	// TODO getAllCategorie
	@Override
	public List<Categorie> getAllCategorie(Agent a) {

		// 1. Requête JPQL
		String req = "SELECT cat FROM Categorie cat WHERE cat.attAgent.id=:pIdCategorie";

		// 2. Création de Query
		Query query = em.createQuery(req);

		// 3. Passage de paramètres
		query.setParameter("pIdCategorie", a.getId());

		// 4. Récupérer le résultat
		List<Categorie> liste = (List<Categorie>) query.getResultList();

		return liste;
	}

}
