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

		Categorie catFind = categorieDao.getCategorieById(cat);

		if (catFind.getAttAgent().getId() == a.getId()) {

			return catFind;

		} else {

			return null;
		}
	}

	// TODO deleteCategorie
	@Override
	public Categorie deleteCategorie(Categorie cat, Agent a) {

		Categorie catDel = categorieDao.deleteCategorie(cat);

		if (catDel.getAttAgent().getId() == a.getId()) {

			return catDel;

		} else {

			return null;
		}
	}

	@Override
	public Categorie updateCategorie(Categorie cat, Agent a) {

		Categorie catUp = categorieDao.updateCategorie(cat);

		if (catUp.getAttAgent().getId() == a.getId()) {

			return catUp;

		} else {

			return null;
		}
	}

	// TODO addCategorie
	@Override
	public Categorie addCategorie(Categorie cat) {

		return categorieDao.addCategorie(cat);
	}

	// TODO getAllCategorie
	@Override
	public List<Categorie> getAllCategorie(Agent a) {

		return categorieDao.getAllCategorie(a);
	}

}
