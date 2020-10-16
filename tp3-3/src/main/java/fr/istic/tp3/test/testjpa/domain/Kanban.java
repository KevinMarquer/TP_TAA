package fr.istic.tp3.test.testjpa.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Kanban implements Serializable{

	private Long id;
	
	private List<Section> sections;
	
	/*private List<Carte> enAttente;
	
	private List<Carte> enCours;
	
	private List<Carte> realise;*/
	
	public Kanban() {}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "kanban", cascade = CascadeType.PERSIST)
	public List<Section> getSections(){
		return this.sections;
	}
	
	public void setSections(List<Section> sections2) {
		this.sections=sections2;
	}
	
	
}
