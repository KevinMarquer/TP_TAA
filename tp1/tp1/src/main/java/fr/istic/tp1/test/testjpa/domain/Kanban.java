package fr.istic.tp1.test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.istic.tp1.test.testjpa.domain.Section;


@Entity
public class Kanban {

	private Long id;
	
	private ArrayList<Section> sections;
	
	public Kanban() {
		
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	@OneToMany
	public List<Section> getSections(){
		return this.sections;
	}
	
	public void setSections(ArrayList<Section> sections) {
		this.sections=sections;
	}
	
	
	
}
