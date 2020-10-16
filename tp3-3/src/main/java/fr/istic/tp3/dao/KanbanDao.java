package fr.istic.tp3.dao;

import fr.istic.tp3.dao.generic.AbstractJpaDao;
import fr.istic.tp3.test.testjpa.domain.Kanban;

public class KanbanDao extends AbstractJpaDao<Long, Kanban>{

	public KanbanDao() {
		super();
		setClazz(Kanban.class);
	}

}
