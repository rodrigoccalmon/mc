package com.rodrigocalmon.cursomc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rodrigocalmon.cursomc.domain.Categoria;
import com.rodrigocalmon.cursomc.domain.Cidade;
import com.rodrigocalmon.cursomc.domain.Cliente;
import com.rodrigocalmon.cursomc.domain.Endereco;
import com.rodrigocalmon.cursomc.domain.Estado;
import com.rodrigocalmon.cursomc.domain.ItemPedido;
import com.rodrigocalmon.cursomc.domain.Pagamento;
import com.rodrigocalmon.cursomc.domain.PagamentoComBoleto;
import com.rodrigocalmon.cursomc.domain.PagamentoComCartao;
import com.rodrigocalmon.cursomc.domain.Pedido;
import com.rodrigocalmon.cursomc.domain.Produto;
import com.rodrigocalmon.cursomc.domain.enums.EstadoPagamento;
import com.rodrigocalmon.cursomc.domain.enums.TipoCliente;
import com.rodrigocalmon.cursomc.repository.CategoriaRepository;
import com.rodrigocalmon.cursomc.repository.CidadeRepository;
import com.rodrigocalmon.cursomc.repository.ClienteRepository;
import com.rodrigocalmon.cursomc.repository.EnderecoRepository;
import com.rodrigocalmon.cursomc.repository.EstadoRepository;
import com.rodrigocalmon.cursomc.repository.ItemPedidoRepository;
import com.rodrigocalmon.cursomc.repository.PagamentoRepository;
import com.rodrigocalmon.cursomc.repository.PedidoRepository;
import com.rodrigocalmon.cursomc.repository.ProdutoRepository;

@Service
public class DBService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	public void istantiateTestDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Eletrônicos");
		Categoria cat4 = new Categoria(null, "Jardinagem");
		Categoria cat5 = new Categoria(null, "Decoração");
		Categoria cat6 = new Categoria(null, "Perfumaria");
		Categoria cat7 = new Categoria(null, "Games");
		Categoria cat8 = new Categoria(null, "Teste");


		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "Colcha", 200.00);
		Produto p7 = new Produto(null, "TV true color", 1280.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajour", 180.00);
		Produto p10 = new Produto(null, "Pendente", 150.00);
		Produto p11 = new Produto(null, "Shampoo", 20.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Rio de Janeiro");

		Cidade c1 = new Cidade(null, "Uberlância", est1);
		Cidade c2 = new Cidade(null, "Teresópolis", est2);
		Cidade c3 = new Cidade(null, "Rio", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Rodrigo Calmon", "rodrigo.ccalmon@gmail.com", "1452222", TipoCliente.PESSOAFISICA, pe.encode("admin"));
		cli1.getTelefones().addAll(Arrays.asList("21993197403", "2199451888"));

		Endereco e1 = new Endereco(null, "Rua Paru", "238", "apto 205", "Agriões", "25963002", cli1, c2);
		Endereco e2 = new Endereco(null, "AV. Ns de Copa", "1424", "apto 901", "Copa", "25963002", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("28/01/2022 10:24"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("28/01/2022 10:24"), cli1, e2);
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}


}
