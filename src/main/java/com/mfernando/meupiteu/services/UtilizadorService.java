package com.mfernando.meupiteu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.UtilizadorRepository;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class UtilizadorService {
	@Autowired
	private UtilizadorRepository repo;
	
	public Utilizador procurarPorId(Integer id) {
		Optional<Utilizador> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Utilizador.class.getName()
				));
	}
}
