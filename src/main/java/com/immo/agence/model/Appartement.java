package com.immo.agence.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Appartement")
public class Appartement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String adresse;
	private String complementAdresse;
	private String etage;
	private String ville;
	private int nbrPieces;
	private String description;
	private double prix;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "proprietaire_id")
	private Proprietaire proprietaire;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "appartement", orphanRemoval = true)
	private Set<Photo> photos;

	public Appartement() {}

	public Appartement(String adresse, String complementAdresse, String etage, String ville, int nbrPieces,
			String description, double prix, Proprietaire proprietaire, Set<Photo> photos) {
		this.adresse = adresse;
		this.complementAdresse = complementAdresse;
		this.etage = etage;
		this.ville = ville;
		this.nbrPieces = nbrPieces;
		this.description = description;
		this.prix = prix;
		this.proprietaire = proprietaire;
		this.photos = photos;
	}

	public void addPhoto(Photo photo) {
		photos.add(photo);
        photo.setAppartement(this);
    }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getComplementAdresse() {
		return complementAdresse;
	}

	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}

	public String getEtage() {
		return etage;
	}

	public void setEtage(String etage) {
		this.etage = etage;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNbrPieces() {
		return nbrPieces;
	}

	public void setNbrPieces(int nbrPieces) {
		this.nbrPieces = nbrPieces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Appartement [id=" + id + ", adresse=" + adresse + ", complementAdresse=" + complementAdresse
				+ ", etage=" + etage + ", ville=" + ville + ", nbrPieces=" + nbrPieces + ", description=" + description
				+ ", prix=" + prix + ", proprietaire=" + proprietaire + ", photos=" + photos + "]";
	}
	
}
