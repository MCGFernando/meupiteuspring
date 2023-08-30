package com.mfernando.meupiteu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfernando.meupiteu.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
