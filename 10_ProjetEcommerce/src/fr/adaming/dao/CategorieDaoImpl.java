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

@Stateless
public class CategorieDaoImpl implements ICategorieDao {

	// ============ 1. Injecter un EntityManager ============
	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;

	@Override
	public List<Categorie> getAllCategoriesByAgent(Agent a) {
		
		// 1. Requ�te JPQL
		String req = "SELECT cat FROM Categorie cat WHERE cat.attAgent.id=:pIdAgent";

		// 2. Cr�ation de Query
		Query query = em.createQuery(req);

		// 3. Passage de param�tres
		query.setParameter("pIdAgent", a.getId());

		// 4. R�cup�rer le r�sultat
		List<Categorie> listeCategorie = query.getResultList();

		return listeCategorie;
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getProduitByCategories(Categorie ca) {
		// TODO Auto-generated method stub
		return null;
	}

}
