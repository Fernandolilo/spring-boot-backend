package com.systempro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systempro.cursomc.domain.Categoria;
import com.systempro.cursomc.domain.Cidade;
import com.systempro.cursomc.domain.Estado;
import com.systempro.cursomc.domain.Produto;
import com.systempro.cursomc.repositories.CategoriaRepository;
import com.systempro.cursomc.repositories.CidadeRepository;
import com.systempro.cursomc.repositories.EstadoRepository;
import com.systempro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {
	
	
	//cria o metodo para chamar o repositorio e estanciar as tabelas
	@Autowired
	private CategoriaRepository categoriaRepository;	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado mg = new Estado(null, "Minas Gerais");
		Estado sp =  new Estado(null, "São Paulo");
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Cidade cid1 = new Cidade(null, "Uberlandia", mg);
		Cidade cid2 = new Cidade(null, "Belo Horizonte", mg);
		Cidade cid3 = new Cidade(null, "Patos de Minas", mg);
		
		Cidade sp1 = new Cidade(null, "São Paulo", sp);
		Cidade sp2 = new Cidade(null, "Sorocaba", sp);
		Cidade sp3 = new Cidade(null, "Itu", sp);
		
		mg.getCidades().addAll(Arrays.asList(cid1, cid2, cid3));
		sp.getCidades().addAll(Arrays.asList(sp1, sp2, sp3));
		
		estadoRepository.saveAll(Arrays.asList(sp,mg));
		cidadeRepository.saveAll(Arrays.asList(cid1,cid2, cid3, sp1, sp2, sp3));
		
	}

}
