package com.immo.agence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.immo.agence.model.Photo;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo, Long>{

}
