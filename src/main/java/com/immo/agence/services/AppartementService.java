package com.immo.agence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.immo.agence.model.Appartement;
import com.immo.agence.repositories.AppartementRepository;

@Service
public class AppartementService {
	
	private AppartementRepository appartementRepository;
	
	public AppartementService(AppartementRepository appartementRepository) {
		this.appartementRepository = appartementRepository;
	}

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
		return appartementRepository.save(appartement);
	}
	
	public void deleteAppartement(long idAppart) {
		appartementRepository.deleteById(idAppart);
	}
	
	public AppartementRepository getAppartementRepository() {
		return appartementRepository;
	}

	public void setAppartementRepository(AppartementRepository appartementRepository) {
		this.appartementRepository = appartementRepository;
	}

	

	
}
