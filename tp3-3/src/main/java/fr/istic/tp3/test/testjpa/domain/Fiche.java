package fr.istic.tp3.test.testjpa.domain;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Fiche implements Serializable{

	private int id;
	
	private String libelle;
	
	private Date dateButoire;
	
	private String utilisateur;
	
	private int temps;
	
	private ArrayList<String> tags;
	
	private String lieu;
	
	private String url;
	
	private Carte carte;

	
	public Fiche(String libelle, Date dateButoire, 
			String utilisateur, int temps, ArrayList<String> tags,String lieu, String url, Carte carte) {
		
		this.libelle=libelle;
		this.dateButoire=dateButoire;
		this.utilisateur=utilisateur;
		this.temps=temps;
		this.tags=tags;
		this.lieu=lieu;
		this.url=url;
		this.carte=carte;
	}
	
	public Fiche() {}
	
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateButoire() {
		return dateButoire;
	}

	public void setDateButoire(Date dateButoire) {
		this.dateButoire = dateButoire;
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(String utilisateur) {
		this.utilisateur = utilisateur;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
		this.temps = temps;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToOne
	public Carte getCarte() {
		return carte;
	}


	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
}
