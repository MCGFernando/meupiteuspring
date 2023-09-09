package com.mfernando.meupiteu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfernando.meupiteu.domain.Utilizador;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer>{

}
