package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.Produit;

public interface IClientDao {

	public Client isExist(Client cl);
	public Client addClient(Client cl);
	public int updateClient (Client cl);
	public int deleteClient (Client cl);

	
}
