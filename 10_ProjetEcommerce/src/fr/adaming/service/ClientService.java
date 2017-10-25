package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Stateful
public class ClientService implements IClientService {
	
	@EJB
	private IClientDao clientDao= new ClientDaoImpl();

//=======================================================================//
	@Override
	public Client isExist(Client cl) {
		return clientDao.isExist(cl);
	}
	
	@Override
	public Client addClient(Client cl) {
		return clientDao.addClient(cl);
	}

	@Override
	public int updateClient(Client cl) {
		return  clientDao.updateClient(cl);
	}

	@Override
	public int deleteClient(Client cl) {
		return clientDao.deleteClient(cl);
	}

	

	
	
	
	
	
}
