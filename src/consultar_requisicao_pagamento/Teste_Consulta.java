package consultar_requisicao_pagamento;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Último teste na classe 19/07/2017
 * 
 * @author Renan Rosa, estagiário, SETIN
 * @version 1.1
 */
public class Teste_Consulta {
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
	public void UC002_CT001_PD001_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher("00000/2017", "0000091-96.2012.5.08.0010",
				"Autuada");/*
							 * Numero, N_Processo, Situacao, Devedor
							 */
		assertTrue(pagina.resultado(new ArrayList<String>(Arrays.asList("00000/2017", "0000091-96.2012.5.08.0010",
				"10ª VARA DO TRABALHO DE BELÉM", "Precatório", "Alimentar", "22/05/2017", "Autuada", "Não"))));
	}

	@Test
	public void UC002_CT002_PD001_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher("00001/0000", "", "");
		assertTrue(pagina.resultado(new ArrayList<String>(Arrays.asList("Nenhum registro encontrado."))));

	}

	@Test
	public void UC002_CT001_PD001_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "Autuada");
		assertTrue(pagina.resultado(new ArrayList<String>(Arrays.asList("00254/2009", "0109400-24.2004.5.08.0013",
				"13ª VARA DO TRABALHO DE BELÉM", "Precatório", "Alimentar", "07/03/2016", "Autuada", "Sim"))));

	}

	@Ignore
	/**
	 * Static method used as precondition of other test.
	 * 
	 * @param numero
	 * @param Finalizado
	 * @param driver
	 * @return
	 */
	public static boolean consultar(String numero, String finalizado, WebDriver driver)
			throws TimeoutException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(numero);

		return pagina.resultado(numero, finalizado);
	}

	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}

}
