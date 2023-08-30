package com.mfernando.meupiteu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfernando.meupiteu.domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{

}
