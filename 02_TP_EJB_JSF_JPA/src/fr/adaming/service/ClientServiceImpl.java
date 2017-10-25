package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService {

	// Injecter un EJB Dao (injection de dépendance)
	@EJB
	private IClientDao clientDao;

	// Getters et Setters
	public IClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	// Autres méthodes
	@Override
	public Client addClient(Client c, Agent a) {
		c.setAgent(a);
		return clientDao.addClient(c);

	}

	@Override
	public Client deleteClient(Client c, Agent a) {

		if (c.getAgent().getId() == a.getId()) {

			return clientDao.deleteClient(c);

		} else {

			return null;
		}

	}

	@Override
	public Client findClient(Client c, Agent a) {

		c.setAgent(a);
		return clientDao.findClient(c);

	}

	@Override
	public Client updateClient(Client c, Agent a) {

		System.out.println("service" + c);

		if (c.getAgent().getId() == a.getId()) {

			return clientDao.updateClient(c);

		} else {

			return null;
		}
	}

	@Override
	public List<Client> getAllClient(Agent a) {

		return clientDao.getAllClient(a);
	}

}
