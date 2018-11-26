package br.com.abasteceaqui.teste;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.abasteceaqui.model.controller.ClienteController;
import br.com.abasteceaqui.model.entidades.Endereco;
import br.com.abasteceaqui.model.entidades.Cliente;

public class TesteCliente {

	private static int codigoCliente = 0;
	
	@BeforeClass
	public static void deveSalvarUmClienteTest() {
				ClienteController repCliente = new ClienteController();
				Cliente cliente = new Cliente();
				cliente.setCnpjCliente("111111111111");
				cliente.setRazaoSocial("Cardoso Marcela LTDA");
				cliente.setFone("11111111");

				Endereco endereco = new Endereco();
				endereco.setRua("Orestes Barbosa");
				endereco.setNumero("100");
				endereco.setBairro("Heliopolis");
				endereco.setCidade("Garanhuns");
				endereco.setCep("55290000");

				cliente.setEndereco(endereco);
				
		//Cliente c = criarCliente();
				
		repCliente.salvar(cliente);

		List<Cliente> clientes = repCliente.listarCliente();

		for (Cliente lista : clientes) {
			if (lista.getRazaoSocial().equals("Cardoso Marcela LTDA")) {
				codigoCliente = lista.getId();
			}
		}

		Cliente cliente2 = repCliente.buscarPorCodigo(codigoCliente);
		Assert.assertEquals("Cardoso Marcela LTDA", cliente2.getRazaoSocial());

	}

	@Test
	public void deveListaTodasClientesTest() {
		ClienteController repCliente = new ClienteController();
		List<Cliente> lista = repCliente.listarCliente();

		boolean listou = lista.size() > 0;
		Assert.assertTrue(listou);
	}

	@Test
	public void deveBuscaClientePorNomeTest() {
		ClienteController repCliente = new ClienteController();
		List<Cliente> listCliente = repCliente.listarCliente();
		
		for (Cliente cliente : listCliente) {
			System.out.println("TESTAAAAAAAAAAAAAAANDO" + cliente);
		}
		
		//System.out.println(listCliente);
		
		//Cliente c1 = criarCliente();
		
		//boolean existe = cliente != null ? true : false;
		//Assert.assertTrue(existe);
		//Assert.assertEquals("Teste", "Cardoso Marcela LTDA", cliente.getRazaoSocial() );
	}

	@Test
	public void deveAlterarDadosDaClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		
		
		
		cliente.setRazaoSocial("teste");

		repCliente.alterar(cliente);

		//Cliente alteracaoDaCliente = repCliente.buscarPorCodigo(codigoCliente);

		Cliente resp = repCliente.buscarPorCodigo(codigoCliente);
		
		Assert.assertEquals(resp, cliente);
	}

	@AfterClass
	public static void deveDeletarClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		repCliente.deletar(cliente);
	}

}
