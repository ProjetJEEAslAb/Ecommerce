package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Local
public interface IClientService {

	public Client addClient(Client c, Agent a);

	public Client deleteClient(Client c, Agent a);

	public Client findClient(Client c, Agent a);

	public Client updateClient(Client c, Agent a);

	public List<Client> getAllClient(Agent a);

}
