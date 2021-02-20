package com.systempro.cursomc;

import java.text.SimpleDateFormat;
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
import com.systempro.cursomc.domain.ItemPedido;
import com.systempro.cursomc.domain.Pagamento;
import com.systempro.cursomc.domain.PagamentoBoleto;
import com.systempro.cursomc.domain.PagamentoCartao;
import com.systempro.cursomc.domain.Pedido;
import com.systempro.cursomc.domain.Produto;
import com.systempro.cursomc.domain.enums.EstadoPagamento;
import com.systempro.cursomc.domain.enums.TipoCliente;
import com.systempro.cursomc.repositories.CategoriaRepository;
import com.systempro.cursomc.repositories.CidadeRepository;
import com.systempro.cursomc.repositories.ClienteRepository;
import com.systempro.cursomc.repositories.EnderecoRepository;
import com.systempro.cursomc.repositories.EstadoRepository;
import com.systempro.cursomc.repositories.ItemPedidoRepository;
import com.systempro.cursomc.repositories.PagamentoRepository;
import com.systempro.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;	
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Construcao");
		Categoria cat4 = new Categoria(null, "Eletrica");
		Categoria cat5 = new Categoria(null, "Hidraulica");
		Categoria cat6 = new Categoria(null, "Revestimentos");
		Categoria cat7 = new Categoria(null, "Ferragem");
		Categoria cat8 = new Categoria(null, "Madeiras");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Fio 4mm Vermelho Sil", 150.00);
		Produto p5 = new Produto(null, "Passa fio com alma de aço, 26MTS", 45.00);
		Produto p6 = new Produto(null, "Cano de esgoto 4P ", 30.00);
		Produto p7 = new Produto(null, "Cano de agua fria 3/4 Tigre", 26.00);
		Produto p8 = new Produto(null, "Barra de gerro 8mm, Gerdal", 50.00);
		Produto p9 = new Produto(null, "Porta Camarão 210 x 70", 410.00);
		Produto p10 = new Produto(null, "Tabua de pinho 30cm x3.00", 26.00);
		Produto p11 = new Produto(null, "tijolo de barro 6 furos", 0.70);
		Produto p12 = new Produto(null, "piso ceramica 60x60 Bege Royal", 26.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p11));
		cat4.getProdutos().addAll(Arrays.asList(p4, p5));
		cat5.getProdutos().addAll(Arrays.asList(p6, p7));
		cat6.getProdutos().addAll(Arrays.asList(p12));
		cat7.getProdutos().addAll(Arrays.asList(p8));
		cat8.getProdutos().addAll(Arrays.asList(p9, p10));
		
		
		

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat4));
		p5.getCategorias().addAll(Arrays.asList(cat4));
		p6.getCategorias().addAll(Arrays.asList(cat5));
		p7.getCategorias().addAll(Arrays.asList(cat5));	
		p8.getCategorias().addAll(Arrays.asList(cat7));
		p9.getCategorias().addAll(Arrays.asList(cat8));
		p10.getCategorias().addAll(Arrays.asList(cat8));
		p11.getCategorias().addAll(Arrays.asList(cat3));
		p12.getCategorias().addAll(Arrays.asList(cat6));
		
		
		
		Estado mg = new Estado(null, "Minas Gerais");
		Estado sp = new Estado(null, "São Paulo");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));

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

		clie1.getEnderecos().addAll(Arrays.asList(e1));
		clie2.getEnderecos().addAll(Arrays.asList(e2));
		clie3.getEnderecos().addAll(Arrays.asList(e3));
		clie4.getEnderecos().addAll(Arrays.asList(e4));
		clie5.getEnderecos().addAll(Arrays.asList(e5));
		clie6.getEnderecos().addAll(Arrays.asList(e6));
		
		
		clienteRepository.saveAll(Arrays.asList(clie1, clie2, clie3, clie4, clie5, clie6));
		enderecoreposytory.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6));
		
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie2, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie3, e3);
		Pedido ped4 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie4, e4);
		Pedido ped5 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie5, e5);
		Pedido ped6 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie6, e6);
		Pedido ped7 = new Pedido(null, sdf.parse("17/02/2021 22:08"),clie1, e2);
		
		Pagamento pag1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("17/02/2021 22:08"), null);				
		ped2.setPagamento(pag2);
		
		Pagamento pag3 = new PagamentoCartao(null, EstadoPagamento.PENDENTE, ped3, 3);
		ped3.setPagamento(pag3);
		
		Pagamento pag4 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped4, 3);
		ped4.setPagamento(pag4);
		
		Pagamento pag5 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped5, 3);
		ped5.setPagamento(pag5);
		
		Pagamento pag6 = new PagamentoCartao(null, EstadoPagamento.CANCELADO, ped6, 3);
		ped6.setPagamento(pag6);
		
		Pagamento pag7 = new PagamentoCartao(null, EstadoPagamento.CANCELADO, ped7, 3);
		ped7.setPagamento(pag7);
		
		clie1.getPedidos().addAll(Arrays.asList(ped1));
		clie2.getPedidos().addAll(Arrays.asList(ped2));
		clie3.getPedidos().addAll(Arrays.asList(ped3));
		clie4.getPedidos().addAll(Arrays.asList(ped4));
		clie5.getPedidos().addAll(Arrays.asList(ped5));
		clie6.getPedidos().addAll(Arrays.asList(ped1));
		
		
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3, ped4, ped5, ped6, ped7));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2, pag3, pag4, pag5, pag6, pag7));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 00.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
