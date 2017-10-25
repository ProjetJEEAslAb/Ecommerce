package fr.adaming.service;

import java.util.List;

import javax.ejb.Local;

import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;

@Local
public interface ICategorieService {
	
	// ============= Méthodes pour Agent =============
	// TODO getAllClient
	public List<Categorie> getAllCategoriesByAgent(Agent a);

}
