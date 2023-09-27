package com.mfernando.meupiteu.services;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Endereco;
import com.mfernando.meupiteu.domain.ItemPedido;
import com.mfernando.meupiteu.domain.Pedido;
import com.mfernando.meupiteu.domain.Restaurante;
import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.domain.enums.EstadoPedido;
import com.mfernando.meupiteu.dto.PedidoNovoDTO;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.EnderecoRepository;
import com.mfernando.meupiteu.repositories.ItemPedidoRepository;
import com.mfernando.meupiteu.repositories.PedidoRepository;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private ProductoService productoService;
	@Autowired
	private UtilizadorService utilizadorService;
	@Autowired
	private RestauranteService restauranteService;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	/*@Autowired
	private EmailService emailService;*/
	public Pedido procurarPorId(Integer id) {
		Optional<Pedido> opt = repo.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()
				));
	}
	@Transactional
	public Pedido inserir(Pedido obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		obj.setDataCriacao(new Date());
		//obj.setCodigoPedido("P001");
		obj.setEstadoPedido(EstadoPedido.CRIADO);
		Optional<Endereco> endereco = enderecoRepository.findById((obj.getEndereco().getId()));
		obj.setEndereco(endereco.get());
		obj.setRestaurante(restauranteService.procurarPorId(obj.getRestaurante().getId()) );
		obj.setTaxaFrete(obj.getTaxaFrete());
		obj.setUtilizador(utilizadorService.procurarPorId(obj.getUtilizador().getId()));
		repo.save(obj);
		for (ItemPedido item : obj.getItens()) {
			item.setDesconto(item.getDesconto());
			item.setIva(item.getIva());
			item.setObservacoes(item.getObservacoes());
			item.setPreco(productoService.procurarPorId(item.getProducto().getId()).getPreco());
			item.setProducto(productoService.procurarPorId(item.getProducto().getId()));
			item.setQuantidade(item.getQuantidade());
			item.setTotal(item.getTotal());
			
			item.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		//System.out.println(obj);
		//emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
	public Pedido fromDTO(PedidoNovoDTO objDTO) {
		// TODO Auto-generated method stub
		System.out.println(objDTO.toString());
		
		
		Utilizador utilizador = new Utilizador(objDTO.getIdUtilizador(), null, null, null, null, null, null, null, null);
		Endereco endereco = new Endereco(objDTO.getIdEndereco(), null, null, null, null, null, null);
		Restaurante restaurante = new Restaurante(objDTO.getIdRestaurante(), null, null, null, null, null, null, null, null, null);
		Pedido pedido = new Pedido(null, objDTO.getTaxaFrete(), new Date(), null, null, null, EstadoPedido.toEnum(objDTO.getEstadoPedido()) , utilizador , endereco, restaurante);
		pedido.getItens().addAll(objDTO.getItens());
		
		return pedido;
	}
}
