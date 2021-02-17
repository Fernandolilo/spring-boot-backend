package com.systempro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.systempro.cursomc.domain.Categoria;
import com.systempro.cursomc.domain.Cidade;
import com.systempro.cursomc.domain.Cliente;
import com.systempro.cursomc.domain.Endereco;
import com.systempro.cursomc.domain.Estado;
import com.systempro.cursomc.domain.Produto;
import com.systempro.cursomc.domain.enums.TipoCliente;
import com.systempro.cursomc.repositories.CategoriaRepository;
import com.systempro.cursomc.repositories.CidadeRepository;
import com.systempro.cursomc.repositories.ClienteRepository;
import com.systempro.cursomc.repositories.EnderecoRepository;
import com.systempro.cursomc.repositories.EstadoRepository;
import com.systempro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursospringApplication implements CommandLineRunner {

	// cria o metodo para chamar o repositorio e estanciar as tabelas
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoreposytory;
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		Estado mg = new Estado(null, "Minas Gerais");
		Estado sp = new Estado(null, "São Paulo");

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

		estadoRepository.saveAll(Arrays.asList(sp, mg));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3, sp1, sp2, sp3));

		Cliente clie1 = new Cliente(null, "Fernando Silva", "fernando@gmail.com", "12312312311",
				TipoCliente.PESSOAFISICA);
		clie1.getTelefones().addAll(Arrays.asList("25257000", "27288000"));
		Cliente clie2 = new Cliente(null, "tania Silva", "tania@gmail.com", "12312312311", TipoCliente.PESSOAJURIDICA);
		clie2.getTelefones().addAll(Arrays.asList("40002525", "27258484"));
		Cliente clie3 = new Cliente(null, "Elias Silva", "elias@gmail.com", "12312312311", TipoCliente.PESSOAJURIDICA);
		clie3.getTelefones().addAll(Arrays.asList("27281000", "40025000"));

		Cliente clie4 = new Cliente(null, "Elias Silva", "elias@gmail.com", "12312312311", TipoCliente.PESSOAJURIDICA);
		clie3.getTelefones().addAll(Arrays.asList("27281000", "40025000"));

		Cliente clie5 = new Cliente(null, "Elias Silva", "elias@gmail.com", "12312312311", TipoCliente.PESSOAJURIDICA);
		clie3.getTelefones().addAll(Arrays.asList("27281000", "40025000"));

		Cliente clie6 = new Cliente(null, "Elias Silva", "elias@gmail.com", "12312312311", TipoCliente.PESSOAJURIDICA);
		clie3.getTelefones().addAll(Arrays.asList("27281000", "40025000"));

		Endereco e1 = new Endereco(null, "Rua flores da cunha", "56", "a", "Jd Nova Vitoria", "01000-000", clie1, cid1);
		Endereco e2 = new Endereco(null, "Rua Machado de Assis", "11", " ", "Jd Machado", "01000-000", clie2, cid2);
		Endereco e3 = new Endereco(null, "Rua Felisberto", "10", "Apartamento 55 - bloco 3", "Jd Felisberto","01000-000", clie3, cid3);
		Endereco e4 = new Endereco(null, "Rua flores da cunha", "12", "b", "Jd Nova Vitoria", "01000-000", clie4, sp1);
		Endereco e5 = new Endereco(null, "Rua flores da cunha", "4", " ", "Jd Nova Vitoria", "01000-000", clie5, sp2);
		Endereco e6 = new Endereco(null, "Rua flores da cunha", "40", " ", "Jd Nova Vitoria", "01000-000", clie6, sp3);

		
		clienteRepository.saveAll(Arrays.asList(clie1, clie2, clie3, clie4, clie5, clie6));
		enderecoreposytory.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
	}

}
