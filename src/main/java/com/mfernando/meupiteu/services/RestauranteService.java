package com.mfernando.meupiteu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Restaurante;
import com.mfernando.meupiteu.repositories.RestauranteRepository;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class RestauranteService {
	@Autowired
	private RestauranteRepository repo;
	
	public Restaurante procurarPorId(Integer id) {
		Optional<Restaurante> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Restaurante.class.getName()
				));
	}
}
