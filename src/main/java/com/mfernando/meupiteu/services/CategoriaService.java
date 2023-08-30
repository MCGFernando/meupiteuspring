package com.mfernando.meupiteu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria procurarPorId(Integer id) {
		Optional<Categoria> opt = repo.findById(id);
		return opt.orElse(null);
	}
}
