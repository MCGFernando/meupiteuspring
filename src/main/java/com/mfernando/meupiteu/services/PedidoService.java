package com.mfernando.meupiteu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Pedido;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.PedidoRepository;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	
	public Pedido procurarPorId(Integer id) {
		Optional<Pedido> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
				));
	}
}
