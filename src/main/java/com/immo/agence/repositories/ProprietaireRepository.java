package com.immo.agence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.immo.agence.model.Proprietaire;

@Repository
public interface ProprietaireRepository  extends JpaRepository<Proprietaire, Long>{

}
