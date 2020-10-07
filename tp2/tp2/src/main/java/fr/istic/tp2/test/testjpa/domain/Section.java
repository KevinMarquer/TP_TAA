package fr.istic.tp2.test.testjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.istic.tp2.test.testjpa.domain.Carte;
import fr.istic.tp2.test.testjpa.domain.Kanban;

@Entity
public class Section implements Serializable{

	private Long id;

	private String nom;
	
	private Kanban kanban;

	private List<Carte> listCarte;

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

	@ManyToOne
	public Kanban getKanban() {
		return this.kanban;
	}

	public void setKanban(Kanban kanban) {
		this.kanban = kanban;
	}
	
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
	public List<Carte> getListCarte() {
		return listCarte;
	}

	public void setListCarte(List<Carte> listCarte) {
		this.listCarte = listCarte;
	}
}
