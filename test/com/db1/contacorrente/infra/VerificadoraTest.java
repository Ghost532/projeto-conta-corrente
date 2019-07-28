package com.db1.contacorrente.infra;

import org.junit.Test;

import com.db1.contacorrente.ContaCorrente;
import org.junit.Assert;
import org.junit.Before;

public class VerificadoraTest {

	
	@Test 
	public void deveRetornarExceptionQuandoValorNull() {
		
		String message = null;
		
		try {
			Verificadora.verificaStringValida(null, "Valor não pode ser nulo");
		} catch (RuntimeException e) {
			message = e.getMessage();		
		}		
			Assert.assertEquals("Valor não pode ser nulo", message);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorEmpty() {
		
		String message = null;
		
		try {
			Verificadora.verificaStringValida("", "Valor não pode ser vazio");
		} catch (RuntimeException e) {
			message = e.getMessage();
		}
			Assert.assertEquals("Valor não pode ser vazio", message);
	}
	
	@Test
	public void deveRetornarExceptionQuandoValorValido() {
		
		String message = null;
		
		try {
			Verificadora.verificaStringValida("Valor válido", "Valor não pode ser inválido");
		} catch (RuntimeException e) {
			message = e.getMessage();
		} 
			Assert.assertEquals(null, message);
		
	}
}