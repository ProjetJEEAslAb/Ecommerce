package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.adaming.dao.ICategorieDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Categorie;

@Stateful
public class CategorieServiceImpl implements ICategorieService {

	// ============ 1. Injection de dépendance Dao ============
	@EJB
	private ICategorieDao categorieDao;

	// ============ 2. Getter et Setter Dao ============

	public ICategorieDao getCategorieDao() {
		return categorieDao;
	}

	public void setCategorieDao(ICategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	// ============ 3. Méthodes ============
	// TODO getAllCategoriesByAgent
	@Override
	public List<Categorie> getAllCategoriesByAgent(Agent a) {
		
		return categorieDao.getAllCategories();
		
	}

}
