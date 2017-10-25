package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

@Stateful
public class AgentServiceImpl implements IAgentService {

	// Injecter un EJB Dao (injection de dépendance)
	@EJB
	private IAgentDao agentDao;

	public IAgentDao getAgentDao() {
		return agentDao;
	}

	public void setAgentDao(IAgentDao agentDao) {
		this.agentDao = agentDao;
	}

	// TODO isExist
	@Override
	public Agent isExist(Agent a) throws Exception {

		return agentDao.isExist(a);
	}

	// TODO addAgent
	@Override
	public Agent addAgent(Agent a) throws Exception {
		
		return agentDao.addAgent(a);
	}

}
