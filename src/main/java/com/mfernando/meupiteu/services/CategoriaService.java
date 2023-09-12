package com.mfernando.meupiteu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
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
}
