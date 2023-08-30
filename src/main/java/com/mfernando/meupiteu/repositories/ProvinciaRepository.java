package com.mfernando.meupiteu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfernando.meupiteu.domain.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer>{

}
