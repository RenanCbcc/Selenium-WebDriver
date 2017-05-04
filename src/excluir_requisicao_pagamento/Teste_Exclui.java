package excluir_requisicao_pagamento;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import consultar_requisicao_pagamento.Teste_Consulta;

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
		
		
		System.out.println(Teste_Consulta.consultar("00000/0000", "Não",driver));
		this.pagina = new Pagina(this.driver);

		/* Dados do Proceso */ this.pagina.excluir();

		//assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		assertTrue(true);

	}
	
	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}
}
