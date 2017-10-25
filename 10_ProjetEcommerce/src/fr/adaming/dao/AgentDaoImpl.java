package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.model.Agent;
import fr.adaming.model.Produit;

@Stateless
public class AgentDaoImpl implements IAgentDao {

	// ============ 1. Injecter un EntityManager ============
	@PersistenceContext(unitName = "PU_EC")
	EntityManager em;

	// ============ 2. Méthode de gestion d'Agent ============
	@Override
	public Agent isExist(Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent addAgent(Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

}
