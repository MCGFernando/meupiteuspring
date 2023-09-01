package com.mfernando.meupiteu.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mfernando.meupiteu.domain.TipoRestaurante;
import com.mfernando.meupiteu.services.TipoRestauranteService;

@RestController
@RequestMapping(value = "/cozinhas")
public class TipoRestauranteResource {
	@Autowired
	private TipoRestauranteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		TipoRestaurante obj = service.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
