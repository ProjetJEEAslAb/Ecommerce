package fr.adaming.dao;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Local
public interface IClientDao {

	// Ici, on donne juste les clients
	// On passera l'agent dans la couche Service

	// Les méthodes retournent des objets
	// On profite de l'ORM qui synchronise les données et les objets

	public Client addClient(Client c);

	public Client deleteClient(Client c);

	public Client findClient(Client c);

	public Client updateClient(Client c);

	public List<Client> getAllClient(Agent a);

}
