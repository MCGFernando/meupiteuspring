package com.mfernando.meupiteu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Restaurante;
import com.mfernando.meupiteu.domain.TipoRestaurante;
import com.mfernando.meupiteu.repositories.TipoRestauranteRepository;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class TipoRestauranteService {
	@Autowired
	private TipoRestauranteRepository repo;
	
	public TipoRestaurante procurarPorId(Integer id) {
		Optional<TipoRestaurante> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoRestaurante.class.getName()
				));
	}
}
