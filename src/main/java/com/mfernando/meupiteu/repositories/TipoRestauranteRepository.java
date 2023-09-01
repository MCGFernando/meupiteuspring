package com.mfernando.meupiteu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfernando.meupiteu.domain.TipoRestaurante;

@Repository
public interface TipoRestauranteRepository extends JpaRepository<TipoRestaurante, Integer>{

}
