package fr.istic.tp1.test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Section {

	private Long id;

	private String nom;

	private List<Carte> listCarte;
	
	private Kanban kanban;

	public Section() {

	}

	public Section(String nom) {
		this.nom = nom;
		this.listCarte = new ArrayList<Carte>();
	}

	public Section(String nom, Kanban kanban) {
		this.nom = nom;
		this.listCarte = new ArrayList<Carte>();
		this.kanban=kanban;
	}
	
	public Section(String nom, List<Carte> listcarte) {
		this.nom = nom;
		this.listCarte = listcarte;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
	public List<Carte> getListCarte() {
		return listCarte;
	}

	public void setListCarte(ArrayList<Carte> listCarte) {
		this.listCarte = listCarte;
	}
	
	
	@ManyToOne
	public Kanban getKanban() {
		return this.kanban;
	}
	
	public void setKanban(Kanban kanban) {
		this.kanban=kanban;
	}
}
