package fr.istic.tp2.dao;

import fr.istic.tp2.dao.generic.AbstractJpaDao;
import fr.istic.tp2.test.testjpa.domain.Carte;
import fr.istic.tp2.test.testjpa.domain.Section;

public class SectionDao extends AbstractJpaDao<Long, Section>{

	public SectionDao() {
		super();
		setClazz(Section.class);
	}
	
	
	public String toString(Long SectionId) {
		SectionDao sectdao = new SectionDao();
		return sectdao.findOne(SectionId).getNom();
	}
	
	public boolean isEmpty() {
		SectionDao sectdao = new SectionDao();
		return sectdao.findAll().isEmpty();
	}
}
