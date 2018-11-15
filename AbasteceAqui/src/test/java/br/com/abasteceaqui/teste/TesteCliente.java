package br.com.abasteceaqui.teste;

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

		ClienteController repCliente = new ClienteController();
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
	public void deveBuscaClientePorCodigoTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);

		boolean existe = cliente != null ? true : false;
		Assert.assertTrue(existe);
	}

	@Test
	public void deveAlterarDadosDaClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		cliente.setRazaoSocial("Marcela Cardoso LTDA");

		repCliente.alterar(cliente);

		Cliente alteracaoDaCliente = repCliente.buscarPorCodigo(codigoCliente);

		Assert.assertEquals("Marcela Cardoso LTDA", alteracaoDaCliente.getRazaoSocial());
	}

	@AfterClass
	public static void deveDeletarClienteTest() {
		ClienteController repCliente = new ClienteController();
		Cliente cliente = repCliente.buscarPorCodigo(codigoCliente);
		repCliente.deletar(cliente);
	}

}
