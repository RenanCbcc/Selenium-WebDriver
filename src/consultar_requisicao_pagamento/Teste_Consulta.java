package consultar_requisicao_pagamento;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Teste_Consulta {
	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
							// preenche os formulários

	@Before
	private void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}

	@Test
	public void UC002_CT001_PD001_1() {

		this.pagina.novo().preencher("00010/2017", "0128300-28.2008.5.08.0009",
				"Parcialmente Paga");/*
										 * Numero, N_Processo, Situacao, Devedor
										 */
		assertTrue(pagina.resultado("00010/2017", "0128300-28.2008.5.08.0009", "VARA DO TRABALHO DE ALTAMIRA",
				"Precatório", "Alimentar", "07/02/2017", "Parcialmente Paga", "Sim"));
	}

	@Test
	public void UC002_CT002_PD001_2() {

		this.pagina.novo().preencher("00001/0000", "",
				"");/* Numero, N_Processo, Situacao, Devedor */
		assertTrue(pagina.resultado("Nenhum registro encontrado."));

	}

	@Test
	public void UC002_CT001_PD001_3() {

		this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013",
				"Autuada");/* Numero, N_Processo, Situacao, Devedor */
		assertTrue(pagina.resultado("00254/2009", "0109400-24.2004.5.08.0013", "13ª VARA DO TRABALHO DE BELÉM",
				"Precatório", "Alimentar", "07/03/2016", "Autuada", "Não"));

	}

	@Ignore
	public static boolean consultar(String numero, String Finalizado, WebDriver driver) {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(numero);

		return pagina.resultado(numero, Finalizado);
	}

	@After
	private void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}

}
