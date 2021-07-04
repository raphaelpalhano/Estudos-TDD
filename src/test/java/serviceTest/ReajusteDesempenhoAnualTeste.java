package serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteDesempenhoAnual;


public class ReajusteDesempenhoAnualTeste {
	 static Funcionario funcionario;
	 static ReajusteDesempenhoAnual service;
	
	
	@BeforeAll
	public static void  iniciando() {
		System.out.println("Inicando os testes...");
	}
	
	
	@BeforeEach
	 void gerar() {
		  service  =  new ReajusteDesempenhoAnual();
		  funcionario = new Funcionario("Jojo", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach
	void finalizar() {
		System.out.println("metodo executado com sucesso.");
	}
	
	@AfterAll
	public static void finalizandoTudo() {
		service = null;
		funcionario = null;
		System.out.print("Encerrando os testes.");
	}
	
	// CASO DE TESTE COM DESEMPENHO RUIM (A DESEJAR) 3%
	
	@Test
	public void reajusteDeTresPorcentoComDesempenhoADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	// CASO DE TESTE COM DESEMPENHO BOM 15%
	
	@Test
	public void reajusteDeTresPorcentoComDesempenhoBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	
	//CASO DE TESTE COM DESEMPENHO ÓTIMO 20%
	@Test
	public void reajusteDeTresPorcentoComDesempenhoOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
	// 40% porcento
	@Test
	public void reajusteDeTresPorcentoComDesempenhoExcepcional() {
		service.concederReajuste(funcionario, Desempenho.EXCEPCIONAL);
		assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
		
	}
	
	
	
	
	/*@BeforeAll
	public static void setup() {
		
		 
		 System.out.print("Obc");
	}*/
	
	
	
	
}
