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

import com.mfernando.meupiteu.domain.Restaurante;
import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.domain.enums.TipoUtilizador;
import com.mfernando.meupiteu.dto.UtilizadorDTO;
import com.mfernando.meupiteu.dto.UtilizadorNovoDTO;
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
		obj.setId(null);
		return repo.save(obj);
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
		novoObj.setEmail(obj.getBi());
		novoObj.setEmail(obj.getEmail());
		novoObj.setNome(obj.getNome());
		novoObj.setSenha(obj.getSenha());
	}

	public void remover(Integer id) {
		Utilizador utilizador= procurarPorId(id);
		
		if(utilizador.getRestaurante() != null) {
			throw new DataIntegrityException("Não é possível excluir um utilizador");
		}
		/*Regra para delecao quando o utilizador tem pedidos no sistema */
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
		return new Utilizador(obj.getId(), obj.getNome(), obj.getBi() , obj.getEmail(), obj.getSenha(), null, obj.getDataActualizado(), null, null);
	}

	public Utilizador fromDTO(UtilizadorNovoDTO obj) {
		Restaurante restaurante = obj.getRestauranteId() == null ? null:new Restaurante(obj.getRestauranteId(), null, null, null, null, null, null, null, null, null);
		Utilizador utilizador =  new Utilizador(null, obj.getNome(), obj.getBi(), obj.getEmail(), obj.getSenha(), new Date(), null, TipoUtilizador.toEnum(obj.getTipoUtilizador()), restaurante);
		for (String telefone : obj.getTelefones()) {
			utilizador.getTelefones().add(telefone);
		}
		
		return utilizador;
	}

	
}
