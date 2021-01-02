package com.immo.agence.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Potho")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String titre;
	private String description;
	private String url;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "appartement_id")
	private Appartement appartement;

	public Photo() {}

	public Photo(String titre, String description, String url, Appartement appartement) {
		this.titre = titre;
		this.description = description;
		this.url = url;
		this.appartement = appartement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Appartement getAppartement() {
		return appartement;
	}

	public void setAppartement(Appartement appartement) {
		this.appartement = appartement;
	}

	@Override
	public String toString() {
		return "Photo [id=" + id + ", titre=" + titre + ", description=" + description + ", url=" + url
				+ ", appartement=" + appartement + "]";
	}

}
