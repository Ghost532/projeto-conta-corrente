package com.db1.contacorrente;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContaCorrenteTest {
	
	private ContaCorrente contaCorrente;
	
	@Before
	public void setup() {
		contaCorrente = new ContaCorrente("9876", "0001234", "Giuliano Montagnani");
	}
	
	@Test
	public void deveRetornarErroQuandoAgenciaInvalida() {
		
		String message = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente(null , "00009876", "Giuliano Montagnani");
		} catch (RuntimeException e) {
			message = e.getMessage();
		}
		Assert.assertEquals("Deve ser informado uma agência válida!", message);
		Assert.assertNotNull(message);
	}

	@Test
	public void deveRetornarErroQuandoNumeroContaInvalida() {
		
		String message = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("0000465" , null, "Giuliano Montagnani");
		} catch (RuntimeException e) {
			message = e.getMessage();
		}
		Assert.assertEquals("Deve ser informado um número de conta válido!", message);
		Assert.assertNotNull(message);
	}
	
	@Test
	public void deveRetornarErroQuandoClienteInvalido() {
		
		String message = null;
		
		try {
			ContaCorrente contaCorrente = new ContaCorrente("0000465" , "000000", null);
		} catch (RuntimeException e) {
			message = e.getMessage();
		}
		Assert.assertEquals("Deve ser informado um cliente válido!", message);
		Assert.assertNotNull(message);
	}
	
	@Test
	public void deveCriarContaCorrenteComValoresValidos() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		Assert.assertEquals("0465", contaCorrente.getAgencia());
		Assert.assertEquals("000099999999", contaCorrente.getNumero());
		Assert.assertEquals("Cliente Nome", contaCorrente.getCliente());
		Assert.assertEquals(200.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorDepositadoInvalido() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		String message = null;
		try {
			contaCorrente.depositar(-0.01);
		} catch (RuntimeException e) {
			message = e.getMessage();
		}
		Assert.assertEquals("Valor a ser depositado deve ser maior que 0", message);
		Assert.assertEquals(200.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals(0, contaCorrente.getHistorico().size());
	}
	
	@Test
	public void deveDepositarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		contaCorrente.depositar(100.0);
		Assert.assertEquals(300.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals("Depositado: R$ 100.0", contaCorrente.getHistorico().get(0));
	}
	
	@Test
	public void deveSacarValor() {
		ContaCorrente contaCorrente = new ContaCorrente("0465",  "000099999999",  "Cliente Nome");
		contaCorrente.sacar(100.0);
		Assert.assertEquals(100.0, contaCorrente.getSaldo(), 0.0);
		Assert.assertEquals("Sacado: R$ 100.0", contaCorrente.getHistorico().get(0));
	}
}
