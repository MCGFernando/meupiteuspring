package com.mfernando.meupiteu.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Producto obj INNER JOIN obj.categorias cat WHERE obj.descricao LIKE %:descricao% AND cat IN :categorias")
	Page<Producto> search(@Param("descricao") String descricao, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	//Page<Producto> findDistinctByDescricaoContainingAndCategoriasIn(String descricao, List<Categoria> categorias, Pageable pageRequest);
}
