package com.mfernando.meupiteu.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Endereco;
import com.mfernando.meupiteu.domain.ItemPedido;
import com.mfernando.meupiteu.domain.Municipio;
import com.mfernando.meupiteu.domain.Pedido;
import com.mfernando.meupiteu.domain.Producto;
import com.mfernando.meupiteu.domain.Provincia;
import com.mfernando.meupiteu.domain.Restaurante;
import com.mfernando.meupiteu.domain.TipoRestaurante;
import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.domain.enums.EstadoPedido;
import com.mfernando.meupiteu.domain.enums.TipoUtilizador;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.EnderecoRepository;
import com.mfernando.meupiteu.repositories.ItemPedidoRepository;
import com.mfernando.meupiteu.repositories.MunicipioRepository;
import com.mfernando.meupiteu.repositories.PedidoRepository;
import com.mfernando.meupiteu.repositories.ProductoRepository;
import com.mfernando.meupiteu.repositories.ProvinciaRepository;
import com.mfernando.meupiteu.repositories.RestauranteRepository;
import com.mfernando.meupiteu.repositories.TipoRestauranteRepository;
import com.mfernando.meupiteu.repositories.UtilizadorRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private ProvinciaRepository provinciaRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private TipoRestauranteRepository tipoRestRepository;
	@Autowired
	private RestauranteRepository restauranteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private UtilizadorRepository utilizadorRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	public void instantiateTestDatabase() {
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Aperitivos");
		Categoria cat3 = new Categoria(null, "Laticínios");
		Categoria cat4 = new Categoria(null, "Carnes");
		Categoria cat5 = new Categoria(null, "Frutas");
		Categoria cat6 = new Categoria(null, "Legumes");
		Categoria cat7 = new Categoria(null, "Limpeza");
		Categoria cat8 = new Categoria(null, "Higiene Pessoal");
		
		Producto prod1 = new Producto(null, "Coca-Cola", 500.0, true);
		Producto prod2 = new Producto(null, "Pastel de Natas", 350.0, true);
		Producto prod3 = new Producto(null, "Sprite", 500.0, true);
		Producto prod4 = new Producto(null, "Tomate", 500.0, true);
		Producto prod5 = new Producto(null, "Sprite", 500.0, true);
		Producto prod6 = new Producto(null, "Batata", 500.0, true);
		Producto prod7 = new Producto(null, "Peito de Frango", 500.0, true);
		Producto prod8 = new Producto(null, "Costela de Porco", 500.0, true);
		Producto prod9 = new Producto(null, "Batata Chips", 500.0, true);
		Producto prod10 = new Producto(null, "Água Mineral", 500.0, true);
		Producto prod11 = new Producto(null, "Manteiga", 500.0, true);
		
		cat1.getProductos().addAll(Arrays.asList(prod1, prod3,prod5,prod10));
		cat2.getProductos().addAll(Arrays.asList(prod2,prod9));
		cat6.getProductos().addAll(Arrays.asList(prod4,prod6));
		cat4.getProductos().addAll(Arrays.asList(prod7,prod8));
		cat3.getProductos().addAll(Arrays.asList(prod11));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		prod4.getCategorias().addAll(Arrays.asList(cat6));
		prod5.getCategorias().addAll(Arrays.asList(cat1));
		prod6.getCategorias().addAll(Arrays.asList(cat6));
		prod7.getCategorias().addAll(Arrays.asList(cat4));
		prod8.getCategorias().addAll(Arrays.asList(cat4));
		prod9.getCategorias().addAll(Arrays.asList(cat2));
		prod10.getCategorias().addAll(Arrays.asList(cat1));
		prod11.getCategorias().addAll(Arrays.asList(cat3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		productoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11));
		
		

		Provincia prov1 = new Provincia(null, "Luanda");
		Provincia prov2 = new Provincia(null, "Huambo");
		
		Municipio mun1 = new Municipio(null, "Talatona", prov1);
		Municipio mun2 = new Municipio(null, "Belas", prov1);
		Municipio mun3 = new Municipio(null, "Icolo e Bengo", prov1);
		Municipio mun4 = new Municipio(null, "Caála", prov2);
		Municipio mun5 = new Municipio(null, "Mungo", prov2);
		
		prov1.getMunicipios().addAll(Arrays.asList(mun1, mun2, mun3));
		prov2.getMunicipios().addAll(Arrays.asList(mun4, mun5));
		
		provinciaRepository.saveAll(Arrays.asList(prov1, prov2));
		municipioRepository.saveAll(Arrays.asList(mun1, mun2, mun3, mun4, mun5));
		
		
		TipoRestaurante tiporest1 = new TipoRestaurante(null, "Angolana");
		TipoRestaurante tiporest2 = new TipoRestaurante(null, "Japonesa");
		
		Restaurante rest1 = new Restaurante(null, "Sushi Rest", "Restaurante de comida japoneza", 0.5, new Date(), new Date(), true, new Date(), new Date(), tiporest2);
		Restaurante rest2 = new Restaurante(null, "Panela de Barro", "Restaurante de comida angolana", 0.5, new Date(), new Date(), true, new Date(), new Date(), tiporest1);
		rest1.getTags().addAll(Arrays.asList("Bebidas","Bar","Comida"));
		rest2.getTags().addAll(Arrays.asList("Cervejas","Bar","Restaurante"));
		rest1.getTelefones().addAll(Arrays.asList("923923923","991991991"));
		rest2.getTelefones().addAll(Arrays.asList("954954954","929929929"));
		
		tiporest1.getRestaurantes().addAll(Arrays.asList(rest2));
		tiporest2.getRestaurantes().addAll(Arrays.asList(rest1));
		
		tipoRestRepository.saveAll(Arrays.asList(tiporest1, tiporest2));
		restauranteRepository.saveAll(Arrays.asList(rest1, rest2));
		
		Endereco ende1 = new Endereco(null, "Av 21 Janeiro, casa 1", "Gamek", "Inorade 2", "Por detraz do inamete", mun1, rest2);
		Endereco ende2 = new Endereco(null, "Av 21 Fevereiro, casa 112", "Baixa", "Caala", "Por detraz do kero", mun4, rest1);
		Endereco ende3 = new Endereco(null, "Av Albano Machado, Nº 62", "Ingombotas", "Sagrada Familia", "Por detraz do Caixa Angola", mun4, null);
		
		enderecoRepository.saveAll(Arrays.asList(ende1, ende2, ende3));
		
		Utilizador utili1 = new Utilizador(null, "Maro Fernando","", "marofernando1991@gmail.com", "123456",new Date(), new Date(), TipoUtilizador.ADMIN,  null);
		Utilizador utili2 = new Utilizador(null, "Maro Fernando Qwner 1","", "marofernando1991+user2@gmail.com", "123456",new Date(), new Date(), TipoUtilizador.OWNER,  rest1);
		Utilizador utili3 = new Utilizador(null, "Maro Fernando Employee 1","", "marofernando1991+user3@gmail.com", "123456",new Date(), new Date(), TipoUtilizador.EMPLOYEE,  rest1);
		Utilizador utili4 = new Utilizador(null, "Maro Fernando Qwner 2","", "marofernando1991+user4@gmail.com", "123456",new Date(), new Date(), TipoUtilizador.OWNER,  rest2);
		Utilizador utili5 = new Utilizador(null, "Maro Fernando Employee 2","", "marofernando1991+user5@gmail.com", "123456",new Date(), new Date(), TipoUtilizador.EMPLOYEE,  rest2);
		Utilizador utili6 = new Utilizador(null, "Maro Fernando Customer","", "marofernando1991+user6@gmail.coms", "123456",new Date(), new Date(), TipoUtilizador.CUSTOMER,  null);
		utili2.getTelefones().addAll(Arrays.asList("925925955"));
		utili4.getTelefones().addAll(Arrays.asList("945965988"));
		utilizadorRepository.saveAll(Arrays.asList(utili1, utili2, utili3, utili4, utili5, utili6));
		
		Pedido ped1 = new Pedido(null,  0.0,  new Date(), null, null, null, EstadoPedido.CRIADO, utili6, ende3, rest2);
		Pedido ped2 = new Pedido(null, 0.0, new Date(), null, null, null, EstadoPedido.CRIADO, utili1, ende3, rest1);
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		
		ItemPedido itemPed1 = new ItemPedido(ped1, prod3, 1, 1000.0, 0.0, 0.0, 1000.0, "Pedido 1");
		ItemPedido itemPed2 = new ItemPedido(ped1, prod1, 1, 2500.0, 0.0, 0.0, 2500.0, "Pedido 1");
		
		ItemPedido itemPed3 = new ItemPedido(ped2, prod1, 1, 1000.0, 0.0, 0.0, 1000.0, "Pedido 2");
		ItemPedido itemPed4 = new ItemPedido(ped2, prod2, 1, 2000.0, 0.0, 0.0, 2000.0, "Pedido 3");
		ItemPedido itemPed5 = new ItemPedido(ped2, prod3, 1, 2500.0, 0.0, 0.0, 2500.0, "Pedido 4");
		
		itemPedidoRepository.saveAll(Arrays.asList(itemPed1, itemPed2, itemPed3, itemPed4, itemPed5));
	}
}
