package visualizar_requisicao_pagamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consultar_requisicao_pagamento.Teste_Consulta;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Teste_Visualizar_Requisicao_Pagamento {
	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);
	}

	@Test
	public void UC002_CT0010_PD0010_1() {

		if (!Teste_Consulta.consultar("00000/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo();
		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	@After
	public void fechar() {
		driver.close();
	}

}
