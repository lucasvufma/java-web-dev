package com.learningSB;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learningSB.domain.Categoria;
import com.learningSB.domain.Cliente;
import com.learningSB.domain.Endereco;
import com.learningSB.domain.ItemPedido;
import com.learningSB.domain.Pagamento;
import com.learningSB.domain.PagamentoComBoleto;
import com.learningSB.domain.PagamentoComCartao;
import com.learningSB.domain.Pedido;
import com.learningSB.domain.Produto;
import com.learningSB.domain.enums.EstadoPagamento;
import com.learningSB.domain.enums.TipoCliente;
import com.learningSB.repositories.CategoriaRepository;
import com.learningSB.repositories.ClienteRepository;
import com.learningSB.repositories.EnderecoRepository;
import com.learningSB.repositories.ItemPedidoRepository;
import com.learningSB.repositories.PagamentoRepository;
import com.learningSB.repositories.PedidoRepository;
@SpringBootApplication
public class LearningSbApplication implements CommandLineRunner {
	@Autowired
	private EnderecoRepository enderecoRepository;	
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(LearningSbApplication.class, args);
	}
		

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Produto p1 = new Produto(null,"Computador",5000.0);
		Produto p2 = new Produto(null,"Celular",800.0);
		
		p1.setCategoria(cat1);
		p2.setCategoria(cat1);
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1));
		Cliente c1=new Cliente("São Luis","MA",null,"Lucas", "lucasvufma@gmail.com","60908095350",TipoCliente.CLIENTEFISICO,"98602-4266",null);
		
		Endereco e1= new Endereco(null,"logradouro teste","201","Edf Monte Rainier", "Calhau","65073143",c1);
		Endereco e2= new Endereco(null,"logradouro teste","802","Edf Monte Castelo", "Cohama","65087111",c1);
		
		//c1.getEnderecos().addAll(Arrays.asList(e1, e2));
		

		clienteRepository.saveAll(Arrays.asList(c1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), c1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), c1, e2);
		
		//c1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.PAGO, ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 1, 0.00, 2000.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 1, 100.00, 800.00);
		
		
		ped1.getItens().addAll(Arrays.asList(ip1));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p2.getItens().addAll(Arrays.asList(ip3));
		p1.getItens().addAll(Arrays.asList(ip1));
	
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip3));
		
		
		
		
		
		
		
	} 

}
