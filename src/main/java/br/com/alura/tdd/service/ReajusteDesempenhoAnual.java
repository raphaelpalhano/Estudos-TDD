package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteDesempenhoAnual {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal percentual = desempenho.porcentualReajusteAnual();
		BigDecimal reajustando = funcionario.getSalario().multiply(percentual);
		funcionario.reajusteSalarial(reajustando);
	
		
	}
	
	

}
