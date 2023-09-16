package com.mfernando.meupiteu.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.dto.UtilizadorDTO;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Utilizador>  lstUtilizador = service.procuraTodos();
		List<UtilizadorDTO>  lstObj = lstUtilizador.stream().map(u -> new UtilizadorDTO(u)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lstObj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<?> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderDirection", defaultValue = "DESC") String orderDirection, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		Page<Utilizador>  lstUtilizador = service.procuraPagina(page, linesPerPage, orderDirection, orderBy);
		Page<UtilizadorDTO>  lstObj = lstUtilizador.map(c -> new UtilizadorDTO(c));
		return ResponseEntity.ok().body(lstObj);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> insert(@Valid @RequestBody UtilizadorDTO objDTO) {
		Utilizador obj = service.fromDTO(objDTO);
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UtilizadorDTO objDTO	, @PathVariable Integer id){
		Utilizador obj = service.fromDTO(objDTO);
		obj.setId(id);
		service.actualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.remover(id);
		return ResponseEntity.noContent().build();
	}
}
