package com.immo.agence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.immo.agence.model.Appartement;
import com.immo.agence.repositories.AppartementRepository;

@Service
public class AppartementService {
	
	private AppartementRepository appartementRepository;
	
	// Constructeur
	public AppartementService(AppartementRepository appartementRepository) {
		this.appartementRepository = appartementRepository;
	}
	
///////////////////  Les mothodes pour les web service //////////////////
	public List<Appartement> findAllAppartements () {
		return appartementRepository.findAll();
	}
	
	public Optional<Appartement> findAppartementById (long idAppart) {
		return appartementRepository.findById(idAppart);
	}
	
	public List<Appartement> searchAppartements(String adresse) {
		String adresseLike = "%"+adresse+"%";
		return appartementRepository.searchAppartements(adresseLike);
	}
	
	public Appartement saveAppartement(Appartement appartement) {
		
		appartement.getPhotos().forEach(photo -> {
			appartement.addPhoto(photo);
		});
		
		
		return appartementRepository.save(appartement);
	}
	
	public Appartement updateAppartement(long idAppart, Appartement appartement) {
		appartement.setId(idAppart);
		return appartementRepository.save(appartement);
	}

	public void deleteAppartement(long idAppart) {
		appartementRepository.deleteById(idAppart);
	}
/////////////////// Fin des mothodes pour les web service //////////////////
	
/////////////////// Getters / setters //////////////////
	public AppartementRepository getAppartementRepository() {
		return appartementRepository;
	}

	public void setAppartementRepository(AppartementRepository appartementRepository) {
		this.appartementRepository = appartementRepository;
	}
	
}
