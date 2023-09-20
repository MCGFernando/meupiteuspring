package com.mfernando.meupiteu.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mfernando.meupiteu.domain.Producto;
import com.mfernando.meupiteu.dto.ProductoDTO;
import com.mfernando.meupiteu.resources.utils.URL;
import com.mfernando.meupiteu.services.ProductoService;

@RestController
@RequestMapping(value = "/productos")
public class ProductoResource {
	@Autowired
	private ProductoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Producto obj = service.procurarPorId(id);
		System.out.println("Request 1");
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProductoDTO>> findPage(
			@RequestParam(value = "descricao", defaultValue = "") String descricao, 
			@RequestParam(value = "categorias", defaultValue = "") String categorias, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderDirection", defaultValue = "DESC") String orderDirection, 
			@RequestParam(value = "orderBy", defaultValue = "descricao") String orderBy) {
		System.out.println("Request 2");
		String nomeDecoded = URL.decodeParam(descricao);
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Producto>  lst = service.search(nomeDecoded, ids, page, linesPerPage, orderDirection, orderBy);
		Page<ProductoDTO>  lstObj = lst.map(p -> new ProductoDTO(p));
		return ResponseEntity.ok().body(lstObj);
	}
	
}
