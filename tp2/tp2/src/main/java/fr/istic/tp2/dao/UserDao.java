package fr.istic.tp2.dao;

import java.util.Collection;
import java.util.List;

import fr.istic.tp2.dao.generic.AbstractJpaDao;
import fr.istic.tp2.test.testjpa.domain.Carte;
import fr.istic.tp2.test.testjpa.domain.User;

public class UserDao extends AbstractJpaDao<Long, User>{

	public UserDao() {
		super();
		setClazz(User.class);
	}
	
	
	public List<Carte> addCarteToUser(Long userId, Long idCarte){
		CarteDao carteDao = new CarteDao();
		Carte carte = carteDao.findOne(idCarte);
		User user = this.findOne(userId);
		user.getCartes().add(carte);
		carte.setUser(user);
		carteDao.update(carte);
		return user.getCartes();
	}
	
	
	public boolean userExistbyName(String name) {
		boolean recherche = false;
		UserDao userdao = new UserDao();
		for(User user : userdao.findAll()) {
			if(name.equals(user.getFirstName())) {
				recherche = true;
				break;
			}
		}
		return recherche;
	}
	
	public User findUserbyName(String name) {
		UserDao userdao = new UserDao();
		User uresult = new User();
		for(User user : userdao.findAll()) {
			if(name.equals(user.getFirstName())) {
				uresult = user;
				break;
			}
		}
		return uresult;
	}
	
}
