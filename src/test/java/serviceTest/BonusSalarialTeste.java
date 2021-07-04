package serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;



public class BonusSalarialTeste {
	
	//salário acima do limite 
	@Test
	public void bonusSalarialValorZero25000() {
		BonusService service = new BonusService();
		//assertThrows(IllegalArgumentException.class, 
			//() -> service.calcularBonus(new Funcionario("Joao", LocalDate.now(), new BigDecimal("25000"))));
		
		// OU
		
		try {
			//tente executar
			service.calcularBonus(new Funcionario("Joao", LocalDate.now(), new BigDecimal("20000")));
			// FORCE PARA O TESTE FALHAR
			fail("Nao gerou a exception!");
		}catch(Exception e){
			assertEquals("O colaborador com possui um salario maior que R$10000 nao recebe bonus!", e.getMessage());
		}
	}
	
	//salario em 10%
	@Test
	public void bonusSalarialDezPorcento2500() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Joao", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
		
	}
	
	
	@Test
	public void bonusDeveSerDezPorcenteParSalarioDeDezMilReais() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Joao", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
		
	}
	
	
}