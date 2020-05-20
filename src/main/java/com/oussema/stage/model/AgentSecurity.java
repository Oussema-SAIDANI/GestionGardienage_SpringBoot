package com.oussema.stage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="agent")
public class AgentSecurity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="agent_id")
	private int agent_id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="matricule")
	private int matricule;
	
	@Column(name="cin")
	private int cin;
	
	@Column(name="adresse")
	private String adresse;
	
    @JoinColumn(name = "trajectoire_id", referencedColumnName = "id")
	@ManyToOne
    private Trajectoire trajectoire;
	
	public AgentSecurity() {
		
	}

	public AgentSecurity(int agent_id, String nom, String prenom, int matricule, int cin, String adresse,
			Trajectoire trajectoire) {
		super();
		this.agent_id = agent_id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.cin = cin;
		this.adresse = adresse;
		this.trajectoire = trajectoire;
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Trajectoire getTrajectoire() {
		return trajectoire;
	}

	public void setTrajectoire(Trajectoire trajectoire) {
		this.trajectoire = trajectoire;
	}
	
	
}
