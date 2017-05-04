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
							// preenche os formulários

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

		this.pagina.novo().preencher("00010/2017",
				"0128300-28.2008.5.08.0009");/*
												 * Número, N_Processo, Situação,
												 * Devedor
												 */
		assertTrue(this.pagina.resultado("00010/2017", "0128300-28.2008.5.08.0009", "VARA DO TRABALHO DE ALTAMIRA",
				"Precatório", "Alimentar", "07/02/2017", "Parcialmente Paga", "Sim"));

	}

	@Test
	public void UC002_CT005_PD001_2() {

		this.pagina.novo().preencher("00282/2009",
				"0071200-63.2004.5.08.0201");/*
												 * Número, N_Processo, Situação,
												 * Devedor
												 */
		assertTrue(this.pagina.resultado("00282/2009", "0071200-63.2004.5.08.0201", "1ª VARA DO TRABALHO DE MACAPÁ",
				"Precatório", "Alimentar", "06/12/2016", "Cancelada", "Sim"));

	}

	@Test
	public void UC002_CT005_PD001_3() {

		this.pagina.novo().preencher("00000/0000",
				"0109400-24.2004.5.08.0013");/*
												 * Numero, N_Processo, Situação,
												 * Devedor
												 */
		assertTrue(this.pagina.resultado("00000/0000", "0109400-24.2004.5.08.0013", "13ª VARA DO TRABALHO DE BELÉM",
				"RPV", "Alimentar", "07/03/2016", "Autuada", "Não"));

	}

	@After
	public void fechar() {
		driver.close();
	}

}
