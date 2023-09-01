package com.mfernando.meupiteu;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Endereco;
import com.mfernando.meupiteu.domain.Municipio;
import com.mfernando.meupiteu.domain.Producto;
import com.mfernando.meupiteu.domain.Provincia;
import com.mfernando.meupiteu.domain.Restaurante;
import com.mfernando.meupiteu.domain.TipoRestaurante;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.EnderecoRepository;
import com.mfernando.meupiteu.repositories.MunicipioRepository;
import com.mfernando.meupiteu.repositories.ProductoRepository;
import com.mfernando.meupiteu.repositories.ProvinciaRepository;
import com.mfernando.meupiteu.repositories.RestauranteRepository;
import com.mfernando.meupiteu.repositories.TipoRestauranteRepository;

@SpringBootApplication
public class MeupiteuApplication implements CommandLineRunner{

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
	public static void main(String[] args) {
		SpringApplication.run(MeupiteuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Aperitivos");
		
		
		Producto prod1 = new Producto(null, "Coca-Cola", 500.0, true);
		Producto prod2 = new Producto(null, "Pastel de Natas", 350.0, true);
		Producto prod3 = new Producto(null, "Sprite", 500.0, true);
		
		cat1.getProductos().addAll(Arrays.asList(prod1, prod3));
		cat2.getProductos().addAll(Arrays.asList(prod2));
		
		prod1.getCategorias().addAll(Arrays.asList(cat1));
		prod2.getCategorias().addAll(Arrays.asList(cat2));
		prod3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		productoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
		
		

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
		
		tiporest1.getRestaurantes().addAll(Arrays.asList(rest2));
		tiporest2.getRestaurantes().addAll(Arrays.asList(rest1));
		
		tipoRestRepository.saveAll(Arrays.asList(tiporest1, tiporest2));
		restauranteRepository.saveAll(Arrays.asList(rest1, rest2));
		
		Endereco ende1 = new Endereco(null, "Av 21 Janeiro, casa 1", "Gamek", "Inorade 2", "Por detraz do inamete", mun1, rest2);
		Endereco ende2 = new Endereco(null, "Av 21 Fevereiro, casa 112", "Baixa", "Caala", "Por detraz do kero", mun4, rest1);
		
		enderecoRepository.saveAll(Arrays.asList(ende1, ende2));
	}

}
