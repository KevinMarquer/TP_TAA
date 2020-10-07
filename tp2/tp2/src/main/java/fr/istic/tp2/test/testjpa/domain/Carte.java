package fr.istic.tp2.test.testjpa.domain;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.istic.tp2.dao.CarteDao;

@Entity
public class Carte implements Serializable{

	private Long id;
	
	private Section section;
	
	private User user;
	
	private String tache;
		
	//private Fiche fiche;

	public Carte(Section section, User user, String tache) {
		this.section=section;
		this.user=user;
		this.tache=tache;
	}
	
	public Carte(Section section, String tache) {
		this.section=section;
		this.tache=tache;
	}
	
	public Carte() {
	}
	
	@Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@ManyToOne
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTache() {
		return tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}
	
	public String afficheCarte() {
		return getUser().getFirstName()+" : "+"\n"+getTache()+"\n";
		
	}
	
}
