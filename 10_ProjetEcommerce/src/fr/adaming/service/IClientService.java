package fr.adaming.service;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

public interface IClientService {

	public Client addClient(Client cl);
	public Client isExist(Client cl);
}
