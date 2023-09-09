package com.mfernando.meupiteu.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.services.UtilizadorService;

@RestController
@RequestMapping(value = "/utilizadores")
public class UtilizadorResource {
	@Autowired
	private UtilizadorService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Utilizador obj = service.procurarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}
