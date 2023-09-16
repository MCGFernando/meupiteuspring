package com.mfernando.meupiteu.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.dto.UtilizadorDTO;
import com.mfernando.meupiteu.repositories.UtilizadorRepository;
import com.mfernando.meupiteu.services.exceptions.DataIntegrityException;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class UtilizadorService {
	@Autowired
	private UtilizadorRepository repo;
	
	public Utilizador procurarPorId(Integer id) {
		Optional<Utilizador> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Utilizador.class.getName()
				));
	}

	public Utilizador inserir(Utilizador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Utilizador actualizar(Utilizador obj) {
		Utilizador novoObj = procurarPorId(obj.getId());
		actualizaDados(novoObj, obj);
		return repo.save(novoObj);
	}

	private void actualizaDados(Utilizador novoObj, Utilizador obj) {
		novoObj.setId(obj.getId());
		novoObj.setDataActualizado(new Date());
		//novoObj.setDataCadastro(null);
		novoObj.setEmail(obj.getEmail()!=null?obj.getEmail():novoObj.getEmail());
		novoObj.setNome(obj.getNome()!=null?obj.getNome():novoObj.getNome());
		novoObj.setSenha(obj.getSenha()!=null?obj.getSenha():novoObj.getSenha());
	}

	public void remover(Integer id) {
		procurarPorId(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um utilizador");
		}
	}
	
	public List<Utilizador> procuraTodos() {
		return  repo.findAll();
	}

	public Page<Utilizador> procuraPagina(Integer page, Integer linesPerPage, String orderDirection, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(orderDirection), orderBy);
		return repo.findAll(pageRequest);
	}

	public Utilizador fromDTO(UtilizadorDTO obj) {
		return new Utilizador(obj.getId(), obj.getNome(), obj.getEmail(), obj.getSenha(), null, obj.getDataActualizado(), null, null);
		//throw new UnsupportedOperationException();
	}

	
}
