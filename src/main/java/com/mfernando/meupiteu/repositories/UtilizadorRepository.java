package com.mfernando.meupiteu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mfernando.meupiteu.domain.Utilizador;

@Repository
public interface UtilizadorRepository extends JpaRepository<Utilizador, Integer>{
	@Transactional(readOnly = true)
	Utilizador findByEmail(String email);
}
