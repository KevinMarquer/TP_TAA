package fr.istic.tp1.test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	
	private Long id;
	
	private String firstName;
	
	List<Carte> listCarte;

	
	public User(String first) {
		this.firstName=first;
	}
	
	public User() {}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	public List<Carte> getListCarte() {
		return listCarte;
	}

	public void setListCarte(ArrayList<Carte> listCarte) {
		this.listCarte = listCarte;
	}
	
}
