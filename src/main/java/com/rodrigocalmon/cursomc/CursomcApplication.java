package com.rodrigocalmon.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rodrigocalmon.cursomc.domain.Categoria;
import com.rodrigocalmon.cursomc.domain.Cidade;
import com.rodrigocalmon.cursomc.domain.Cliente;
import com.rodrigocalmon.cursomc.domain.Endereco;
import com.rodrigocalmon.cursomc.domain.Estado;
import com.rodrigocalmon.cursomc.domain.Produto;
import com.rodrigocalmon.cursomc.domain.enums.TipoCliente;
import com.rodrigocalmon.cursomc.repository.CategoriaRepository;
import com.rodrigocalmon.cursomc.repository.CidadeRepository;
import com.rodrigocalmon.cursomc.repository.ClienteRepository;
import com.rodrigocalmon.cursomc.repository.EnderecoRepository;
import com.rodrigocalmon.cursomc.repository.EstadoRepository;
import com.rodrigocalmon.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

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

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Rio de Janeiro");

		Cidade c1 = new Cidade(null, "Uberlância", est1);
		Cidade c2 = new Cidade(null, "Teresópolis", est2);
		Cidade c3 = new Cidade(null, "Rio", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Rodrigo Calmon", "rodrigo@gmail.com", "1452222", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("21993197403", "2199451888"));
		
		Endereco e1 = new Endereco(null, "Rua Paru", "238", "apto 205", "Agriões", "25963002", cli1, c2);
		Endereco e2 = new Endereco(null, "AV. Ns de Copa", "1424", "apto 901", "Copa", "25963002", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
