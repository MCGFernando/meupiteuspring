package com.mfernando.meupiteu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.dto.CategoriaDTO;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.services.exceptions.DataIntegrityException;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria procurarPorId(Integer id) {
		Optional<Categoria> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
				));
	}

	public Categoria inserir(Categoria obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		return repo.saveAndFlush(obj);
	}

	public Categoria actualizar(Categoria obj) {
		// TODO Auto-generated method stub
		procurarPorId(obj.getId());
		return repo.save(obj);
	}

	public void remover(Integer id) {
		// TODO Auto-generated method stub
		procurarPorId(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui productos");
		}
		
	}

	public List<Categoria> procuraTodos() {
		return  repo.findAll();
	}
	
	public Page<Categoria> procuraPagina(Integer page, Integer linesPerPage, String orderDirection, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(orderDirection), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO (CategoriaDTO obj) {
		return new Categoria(obj.getId(), obj.getNome());
	}
}
