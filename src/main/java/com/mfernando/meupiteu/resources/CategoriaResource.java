package com.mfernando.meupiteu.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mfernando.meupiteu.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		List<Categoria> lst = new ArrayList<>();
		Categoria cat1 = new Categoria(1, "Bebidas");
		Categoria cat2 = new Categoria(1, "Pizzas");
		lst.add(cat1);
		lst.add(cat2);
		return lst;
	}
}
