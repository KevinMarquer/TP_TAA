package fr.istic.tp1.test.testjpa.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Carte {

	private Long id;
	
	private Section section;
	
	private User user;
	
	//private Fiche fiche;
	
	private String tache;

	public Carte(Section section, User user) {
		this.section=section;
		this.user=user;
	}
	
	public Carte(Section section, User user, String tache) {
		this.section=section;
		this.user=user;
		this.tache=tache;
	}
	
	public Carte(Section section) {
		this.section=section;
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
	
/*
	@OneToOne
	public Fiche getFiche() {
		return fiche;
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}*/

	
}
