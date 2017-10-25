package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Stateless
public class ClientDaoImpl implements IClientDao {

	// ========== 1. Injecter un EntityManager ==========
	
	// Le conteneur EJB va l'instancier et le donner au besoin
	@PersistenceContext(unitName = "PU_TP")
	EntityManager em;

	
	// ========== 2. Méthodes ==========
	
	// TODO addClient
	@Override
	public Client addClient(Client c) {

		em.persist(c);
		return c;
		
	}

	
	// TODO deleteClient
	@Override
	public Client deleteClient(Client c) {

		Client cFind = em.find(Client.class, c.getId());
		em.remove(cFind);
		
		return cFind;

	}
	
	// TODO findClient
	@Override
	public Client findClient(Client c) {

		String req = "SELECT c FROM Client c WHERE c.id=:pIdClient AND c.agent.id=:pIdAgent";

		// Création de Query
		Query query = em.createQuery(req);

		// Passage de paramètres
		query.setParameter("pIdClient", c.getId());
		query.setParameter("pIdAgent", c.getAgent().getId());

		Client cFind = (Client) query.getSingleResult();

		return cFind;
	}

	
	// TODO UpdateClient
	@Override
	public Client updateClient(Client c) {
		
		em.merge(c);

		return c;
	}

	
	// TODO getAllClient
	@Override
	public List<Client> getAllClient(Agent a) {

		// 1. Requête JPQL
		String req = "SELECT c FROM Client c WHERE c.agent.id=:pIdAgent";

		// 2. Création de Query
		Query query = em.createQuery(req);

		// 3. Passage de paramètres
		query.setParameter("pIdAgent", a.getId());

		// 4. Récupérer le résultat
		List<Client> liste = (List<Client>) query.getResultList();

		return liste;
	}

}
