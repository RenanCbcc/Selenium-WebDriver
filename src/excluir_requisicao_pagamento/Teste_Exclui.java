package excluir_requisicao_pagamento;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import consultar_requisicao_pagamento.Teste_Consulta;
/**
 * 
 * @author 01578093236
 *
 */
public class Teste_Exclui {
	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		driver = new FirefoxDriver(capabilities);
	}
	
	
	@Test
	public void UC002_CT004_PD004_1() {
		
		
		if (!Teste_Consulta.consultar("00001/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina = new Pagina(this.driver);

		/* Dados do Proceso */ this.pagina.excluir();

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		

	}
	@Test
	public void UC002_CT004_PD004_2() {
		
		
		if (!Teste_Consulta.consultar("00002/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina = new Pagina(this.driver);

		/* Dados do Proceso */ this.pagina.excluir();

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		

	}
	@Test
	public void UC002_CT004_PD004_3() {
		
		
		if (!Teste_Consulta.consultar("00003/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina = new Pagina(this.driver);

		/* Dados do Proceso */ this.pagina.excluir();

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		

	}
	
	@Test
	public void UC002_CT004_PD004_4() {
		
		
		if (!Teste_Consulta.consultar("00004/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina = new Pagina(this.driver);

		/* Dados do Proceso */ this.pagina.excluir();

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		

	}
	
	@Test
	public void UC002_CT004_PD004_5() {
		
		
		if (!Teste_Consulta.consultar("00005/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina = new Pagina(this.driver);

		/* Dados do Proceso */ this.pagina.excluir();

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		

	}
	
	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}
}
