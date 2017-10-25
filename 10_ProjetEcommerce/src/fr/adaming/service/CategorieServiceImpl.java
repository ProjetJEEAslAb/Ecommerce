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

	@Override
	public Categorie getCategorieById(Categorie cat, Agent a) throws Exception {

		if (cat.getAttAgent().getId() == a.getId()) {

			return categorieDao.getCategorieById(cat);

		} else {

			return null;
		}
	}

	@Override
	public Categorie deleteCategorie(Categorie cat, Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie updateCategorie(Categorie cat, Agent a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie addCategorie(Categorie cat) {
		
			return categorieDao.addCategorie(cat);
	}

}
