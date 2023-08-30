package com.mfernando.meupiteu;

import java.util.Arrays;

import org.aspectj.weaver.ArrayReferenceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mfernando.meupiteu.domain.Categoria;
import com.mfernando.meupiteu.repositories.CategoriaRepository;

@SpringBootApplication
public class MeupiteuApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	public static void main(String[] args) {
		SpringApplication.run(MeupiteuApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Bebidas");
		Categoria cat2 = new Categoria(null, "Aperitivos");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
