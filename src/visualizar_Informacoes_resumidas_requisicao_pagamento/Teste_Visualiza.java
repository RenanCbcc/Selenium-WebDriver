package visualizar_Informacoes_resumidas_requisicao_pagamento;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Teste_Visualiza {

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
	public void UC002_CT005_PD001_1() throws TimeoutException, InterruptedException {

		this.pagina.novo().preencher("00001/2017", "0000006-55.2008.5.08.0009");
		if (this.pagina.resultado(Arrays.asList("00001/2017", "0000006-55.2008.5.08.0009",
				"VARA DO TRABALHO DE CASTANHAL", "Precatório", "Alimentar", "07/08/2017", "Autuada", "Não"))) {
			assertTrue(true);
		} else {
			fail("Error 404: Process not found");
		}

	}

	@Test
	public void UC002_CT005_PD001_2() throws TimeoutException, InterruptedException {

		this.pagina.novo().preencher("00002/2017", "0000008-25.2008.5.08.0009");
		if (this.pagina.resultado(Arrays.asList("00002/2017", "0000008-25.2008.5.08.0009",
				"VARA DO TRABALHO DE ALTAMIRA", "RPV", "Alimentar", "07/08/2017", "Autuada", "Não"))) {
			assertTrue(true);
		} else {
			fail("Error 404: Process not found");
		}

	}

	@Test
	public void UC002_CT005_PD001_3() throws TimeoutException, InterruptedException {

		this.pagina.novo().preencher("00003/2017", "0000008-25.2008.5.08.0009");

		if (this.pagina.resultado(Arrays.asList("00003/2017", "0000008-25.2008.5.08.0009",
				"VARA DO TRABALHO DE ALTAMIRA", "RPV", "Alimentar", "07/08/2017", "Autuada", "Não"))) {
			assertTrue(true);
		} else {
			fail("Error 404: Process not found");
		}

	}

	@After
	public void fechar() {
		driver.close();
	}

}
