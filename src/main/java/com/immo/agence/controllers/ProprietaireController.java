package com.immo.agence.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immo.agence.model.Proprietaire;
import com.immo.agence.services.ProprietaireService;

@RestController
@RequestMapping("/proprietaires")
public class ProprietaireController {
	
	private ProprietaireService proprietaireService;

	/// Constructeur
	public ProprietaireController(ProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
/////////////////// Les mothodes pour les web service //////////////////	
	
	@GetMapping
	public List<Proprietaire> findAllProprietaires() {
		return proprietaireService.findAllProprietaires();
	}
	
	@GetMapping("/{id}")
	public Optional<Proprietaire> findProprietaireById(@PathVariable long id) {
		return proprietaireService.findProprietaireById(id);
	}
	
/////////////////// Fin des mothodes pour les web service //////////////////
	
/////////////////// Getters / setters //////////////////
	public ProprietaireService getProprietaireService() {
		return proprietaireService;
	}

	public void setProprietaireService(ProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}
	
}
