package fr.istic.tp2.test.testjpa.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name="user")
public class User implements Serializable{

	
	private Long id;
	
	private String firstName;
	
	List<Carte> cartes;

	
	public User(String first) {
		this.firstName=first;
		this.cartes = new ArrayList<Carte>();
	}
	
	public User() {}
	
	@Id
	@GeneratedValue
	@XmlElement(name="id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name="firstName")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@XmlElementWrapper(name = "cartes")
    @XmlElement(name = "carte")
	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}
	
}
