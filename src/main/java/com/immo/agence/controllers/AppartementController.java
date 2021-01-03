package com.immo.agence.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.immo.agence.model.Appartement;
import com.immo.agence.services.AppartementService;

@RestController
@RequestMapping("/appartements")
public class AppartementController {
	
	private AppartementService appartementService;
	
	public AppartementController(AppartementService appartementService) {
		this.appartementService = appartementService;
	}

	@GetMapping
	public List<Appartement> findAllAppartements () {
		return appartementService.findAllAppartements();
	}
	
	@GetMapping("/{idAppart}")
	public Optional<Appartement> findAppartementById (@PathVariable long idAppart) {
		return appartementService.findAppartementById(idAppart);
	}
	
	@GetMapping("/search")
	public List<Appartement> searchAppartements(@RequestParam String adresse) {
		return appartementService.searchAppartements(adresse);
	}
	
	
	@PostMapping
	public Appartement saveAppartement (@RequestBody Appartement appartement) {
		return appartementService.saveAppartement(appartement);
	}
	
	
	@DeleteMapping("/{idAppart}")
	public void deleteAppartement(@PathVariable long idAppart) {
		appartementService.deleteAppartement(idAppart);
	}
	
	@PutMapping("/{idAppartUpdate}")
	public Appartement updateAppartement(@PathVariable(name = "idAppartUpdate") long idAppartUpdate, @RequestBody Appartement appartement) {
		return appartementService.updateAppartement(idAppartUpdate,  appartement);
	}
	

	public AppartementService getAppartementService() {
		return appartementService;
	}

	public void setAppartementService(AppartementService appartementService) {
		this.appartementService = appartementService;
	}
}
