package com.oussema.stage.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

@Entity
@Table(name="trajectoire")
public class Trajectoire {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;

	/*@Column(name="emplacement")
	private Emplacement[] emplacementTab;*/
	
	@ManyToMany
	@JoinTable(name = "emplacement_trajectoire",
    joinColumns = { @JoinColumn(name = "trajectoire_id") },
	inverseJoinColumns = { @JoinColumn(name = "emplacement_id") })
    private List<Emplacement> emplacements;

	 @OneToMany(mappedBy = "trajectoire")
	 private Collection<AgentSecurity> agent;

	public Trajectoire(int id, String nom, List<Emplacement> emplacements, Collection<AgentSecurity> agent) {
		super();
		this.id = id;
		this.nom = nom;
		this.emplacements = emplacements;
		this.agent = agent;
	}


	public Trajectoire() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Emplacement> getEmplacements() {
		return emplacements;
	}


	public void setEmplacements(List<Emplacement> emplacements) {
		this.emplacements = emplacements;
	}

	@JsonIgnore
	public Collection<AgentSecurity> getAgent() {
		return agent;
	}


	public void setAgent(Collection<AgentSecurity> agent) {
		this.agent = agent;
	}
	
	
	
	
	
}
