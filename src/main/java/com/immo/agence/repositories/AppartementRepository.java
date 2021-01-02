package com.immo.agence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.immo.agence.model.Appartement;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long>{

	
	@Query(value = "SELECT * FROM APPARTEMENT WHERE UPPER(ADRESSE) LIKE UPPER(:adresse) ", nativeQuery = true)
    public List<Appartement> searchAppartements(@Param("adresse") String adresse);
}
