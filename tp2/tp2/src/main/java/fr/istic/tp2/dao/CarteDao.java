package fr.istic.tp2.dao;

import java.util.List;

import fr.istic.tp2.dao.generic.AbstractJpaDao;
import fr.istic.tp2.test.testjpa.domain.Carte;

public class CarteDao extends AbstractJpaDao<Long, Carte>{

	public CarteDao() {
		super();
		setClazz(Carte.class);
	}
	
	
	public String toStringbyId(Long carteId) {
		String res = "";
		CarteDao cartedao = new CarteDao();
		Carte carte = cartedao.findOne(carteId);
		res = "tache : "+carte.getTache();
		
		return res;
	}
	
}
