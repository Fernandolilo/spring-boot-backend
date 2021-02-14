package com.systempro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systempro.cursomc.domain.Categoria;
import com.systempro.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriarepository;
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
