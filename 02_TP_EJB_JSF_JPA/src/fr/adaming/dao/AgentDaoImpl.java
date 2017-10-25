package fr.adaming.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;

@Stateless
public class AgentDaoImpl implements IAgentDao {

	// Injecter un EntityManager
	// Le conteneur EJB va l'instancier et le donner au besoin
	@PersistenceContext(unitName = "PU_TP")
	EntityManager em;

	// TODO isExist
	@Override
	public Agent isExist(Agent a) throws Exception {

		String req = "SELECT a FROM Agent a WHERE a.mail=:pMail AND a.mdp=:pMdp";

		// Création de Query
		Query query = em.createQuery(req);

		// Passage de paramètres
		query.setParameter("pMail", a.getMail());
		query.setParameter("pMdp", a.getMdp());

		// Récupérer le résultat
		Agent aRec = (Agent) query.getSingleResult();

		return aRec;
	
	}

	// addAgent
	@Override
	public Agent addAgent(Agent a) throws Exception {
		
		Agent aAdd = new Agent(a.getMail(), a.getMdp());
		
		em.persist(aAdd);
		
		return aAdd;
		
	}

}
