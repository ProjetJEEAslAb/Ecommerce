package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

@Stateful
public class AgentServiceImpl implements IAgentService {

	// ============ 1. Injection de dépendance Dao ============
	@EJB
	private IAgentDao agentDao;
	
	// ============ 2. Getter et Setter Dao ============
	public IAgentDao getAgentDao() {
		return agentDao;
	}

	public void setAgentDao(IAgentDao agentDao) {
		this.agentDao = agentDao;
	}

	@Override
	public Agent isExist(Agent a) throws Exception {
		
		return agentDao.isExist(a);
	}

}
