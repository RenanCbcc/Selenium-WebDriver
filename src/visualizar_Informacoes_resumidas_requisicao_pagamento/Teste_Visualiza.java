package visualizar_Informacoes_resumidas_requisicao_pagamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;

public class Teste_Visualiza {

	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
							// preenche os formul�rios

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
	public void UC002_CT005_PD001_1() {

		this.pagina.novo().preencher("00001/2017",
				"0000006-55.2008.5.08.0009");/*
												 * N�mero, N_Processo, Situa��o,
												 * Devedor
												 */
		assertTrue(this.pagina.resultado("00001/2017", "0000006-55.2008.5.08.0009", "VARA DO TRABALHO DE ALTAMIRA",
				"Precat�rio", "Alimentar", "19/05/2017", "Autuada", "N�o"));

	}

	@Test
	public void UC002_CT005_PD001_2() {

		this.pagina.novo().preencher("00002/2017",
				"0000008-25.2008.5.08.0009");/*
												 * N�mero, N_Processo, Situa��o,
												 * Devedor
												 */
		assertTrue(this.pagina.resultado("00002/2017", "0000008-25.2008.5.08.0009", "VARA DO TRABALHO DE ALTAMIRA",
				"RPV", "Alimentar", "19/05/2017", "Autuada", "N�o"));

	}

	@Test
	public void UC002_CT005_PD001_3() {

		this.pagina.novo().preencher("00004/2017",
				"0109400-24.2004.5.08.0013");/*
												 * Numero, N_Processo, Situa��o,
												 * Devedor
												 */
		assertTrue(this.pagina.resultado("00004/2017", "0109400-24.2004.5.08.0013", "13� VARA DO TRABALHO DE BEL�M",
				"RPV", "Comum", "19/05/2017", "Autuada", "N�o"));

	}

	@After
	public void fechar() {
		driver.close();
	}

}
