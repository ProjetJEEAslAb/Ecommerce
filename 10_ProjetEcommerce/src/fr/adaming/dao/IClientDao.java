package fr.adaming.dao;

import java.util.List;


import fr.adaming.model.Client;


public interface IClientDao {

	public Client isExist(Client cl);
	public Client addClient(Client cl);
	public int updateClient (Client cl);
	public int deleteClient (Client cl);

	
}
