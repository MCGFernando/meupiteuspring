package com.mfernando.meupiteu;

import java.util.Arrays;

import org.aspectj.weaver.ArrayReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.domain.Producto;
import com.mfernando.meupiteu.repositories.CategoriaRepository;
import com.mfernando.meupiteu.repositories.ProductoRepository;

@SpringBootApplication
public class MeupiteuApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProductoRepository productoRepository;
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
	}

}
