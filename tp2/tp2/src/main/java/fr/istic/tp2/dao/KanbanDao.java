package fr.istic.tp2.dao;

import fr.istic.tp2.dao.generic.AbstractJpaDao;
import fr.istic.tp2.test.testjpa.domain.Kanban;

public class KanbanDao extends AbstractJpaDao<Long, Kanban>{

	public KanbanDao() {
		super();
		setClazz(Kanban.class);
	}

}
