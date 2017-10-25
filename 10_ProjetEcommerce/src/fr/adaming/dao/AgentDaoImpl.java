package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.Produit;

@Stateless
public class AgentDaoImpl implements IAgentDao {

	// ============ 1. Injecter un EntityManager ============
	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;

	// ============ 2. Méthode de gestion d'Agent ============
	// TODO Existence de l'agent
	@Override
	public Agent isExist(Agent a) throws Exception {
		
		// 1. Création de la requête JPQL
		String req = "SELECT a FROM Agent a WHERE a.mail=:pMail AND a.mdp=:pMdp";
		
		// 2. Query
		Query query = em.createQuery(req);
		
		// 3. Paramètres
		query.setParameter("pMail", a.getMail());
		query.setParameter("pMdp", a.getMdp());
		
		// 4. Récupérer le résultat
		Agent aRec = (Agent) query.getSingleResult();		
		return aRec;
	}

}
