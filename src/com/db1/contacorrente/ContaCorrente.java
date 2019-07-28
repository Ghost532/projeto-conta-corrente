package com.db1.contacorrente;
import java.util.ArrayList;
import java.util.List;

import com.db1.contacorrente.infra.Verificadora;


// Comportamento
// depositar
// sacar
// criar a conta

// saldo

public class ContaCorrente {
	
	private String agencia;
	private String numero;
	private String cliente;
	private Double saldo;
	private List<String> historico;
	
	public ContaCorrente(String agencia, String numero, String cliente) {
		
		Verificadora.verificaStringValida(agencia, "Deve ser informado uma agência válida!");
		Verificadora.verificaStringValida(numero, "Deve ser informado um número de conta válido!");
		Verificadora.verificaStringValida(cliente, "Deve ser informado um cliente válido!");
		
			this.agencia = agencia;
			this.numero = numero;
			this.cliente = cliente;
			this.saldo = 200.0;
			this.historico = new ArrayList<String>();
		}
	
	public void depositar(Double valor) {
		Verificadora.valorMaiorQueZero(valor, "Valor a ser depositado deve ser maior que 0");	
		this.saldo += valor;
		this.historico.add("Depositado: R$ " +valor);
	}
	
	public void sacar(Double valor) {
		Verificadora.valorMaiorQueZero(valor, "Valor a ser sacado deve ser maior que 0");
		this.saldo -= valor;
		this.historico.add("Sacado: R$ " +valor);
	}
		
	public String getAgencia() {
		return agencia;
	}	
	public String getNumero() {
		return numero;
	}
	public String getCliente() {
		return cliente;
	}
	public List<String> getHistorico() {
		return historico;
	}
	public Double getSaldo() {
		return saldo;
	}
	}
