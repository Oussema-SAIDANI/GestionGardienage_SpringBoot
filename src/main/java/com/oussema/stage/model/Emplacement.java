package com.oussema.stage.model;

import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="emplacement")
public class Emplacement {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="longitude")
	private float longitude;
	
	@Column(name="latitude")
	private float latitude;
	
	@OneToOne
    @JoinColumn(name = "beacon_ref")
    private Beacon beacon;
	
	public Emplacement() {
	
	}

	public Emplacement(int id, String nom, float longitude, float latitude) {
		this.id = id;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
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

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}


	
	

}
