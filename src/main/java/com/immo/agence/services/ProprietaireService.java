package com.immo.agence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.immo.agence.model.Proprietaire;
import com.immo.agence.repositories.ProprietaireRepository;

@Service
public class ProprietaireService {
	
	private ProprietaireRepository proprietaireRepository;
	
	/// Constructeur
	public ProprietaireService(ProprietaireRepository proprietaireRepository) {
		this.proprietaireRepository = proprietaireRepository;
	}

/////////////////// Les mothodes pour les web service //////////////////
	public List<Proprietaire> findAllProprietaires() {
		return proprietaireRepository.findAll();
	}

	public Optional<Proprietaire> findProprietaireById(long id) {
		return proprietaireRepository.findById(id);
	}

/////////////////// Fin des mothodes pour les web service //////////////////
	
/////////////////// Getters / setters //////////////////
	public ProprietaireRepository getProprietaireRepository() {
		return proprietaireRepository;
	}

	public void setProprietaireRepository(ProprietaireRepository proprietaireRepository) {
		this.proprietaireRepository = proprietaireRepository;
	}

}
