package fr.adaming.service;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

public interface IClientService {

	public Client isExist(Client cl);
	public Client addClient(Client cl);
	public int updateClient (Client cl);
	public int deleteClient (Client cl);
}
