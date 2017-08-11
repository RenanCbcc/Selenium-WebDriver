package visualizar_detalhes_historicos_requisicao_pagamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

/**
 * Last test 0708/2017
 * 
 * @author Renan Rosa
 * @since 20/03/2017
 * 
 */
public class Teste_Visualiza_Detalhes {

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
	public void UC002_CT006_PD006_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher("00001/2018", "0000006-55.2008.5.08.0009");
		
		assertTrue(pagina.resultado("00001/2017", "0000006-55.2008.5.08.0009", "Precat�rio", "Alimentar",
				"VARA DO TRABALHO DE ALTAMIRA", "Autuada"));

	}

	@After
	public void fechar() {
		driver.close();
	}

}
