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
@Local(fr.adaming.dao.IClientDao.class)
public class ClientDaoImpl implements IClientDao {

//=======================================================================//

	@PersistenceContext(unitName="PU_EC") //cette annotation sert a injecte une entiteManager : le conteneur EJB va l'instancier et me le donnera quand j'en aurait besoin 
	EntityManager em; //entityManager est une interface
	
//=======================================================================//
	// Méthode de gestion d'Agent
		@Override
		public Client isExist(Client cl) {
			//requete jpql
			String req="SELECT cl FROM Client cl WHERE cl.mail=:pMail AND cl.mdp=:pMdp";
			
			//creation du query recuperer a partir de l'entite manager
			Query query=em.createQuery(req);
			
			//passage des param
			query.setParameter("pMail", cl.getMail());
			query.setParameter("pMdp", cl.getMdp());
			
			//envoyer la requete et recuperer le resultat
			Client cl_rec= (Client) query.getSingleResult();
			System.out.println("-------------------- "+cl_rec.getMail());
			System.out.println("-------------------- "+cl_rec.getMdp());
			return cl_rec;
			
		}	
//=======================================================================//

	@Override
	public Client addClient(Client cl) {

		em.persist(cl);
		return cl; // jpa a synchronisé le client avec le context. en sortant a
					// un id
	}

//=======================================================================//

	@Override
	public int updateClient(Client cl) {
		
		return 0;
	}
//=======================================================================//

	@Override
	public int deleteClient(Client cl) {
	
		return 0;
	}

	

}
