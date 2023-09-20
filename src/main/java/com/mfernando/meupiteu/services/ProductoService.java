package com.mfernando.meupiteu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Producto;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.ProductoRepository;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Producto procurarPorId(Integer id) {
		Optional<Producto> opt = repo.findById(id);
		System.out.println("Chegou 1");
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Producto.class.getName()
				));
	}
	
	public Page<Producto> search(String descricao, List<Integer> ids, Integer page, Integer linesPerPage, String orderDirection, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(orderDirection), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		System.out.println("Chegou 2");
		return repo.search(descricao, categorias, pageRequest);
	}
}
