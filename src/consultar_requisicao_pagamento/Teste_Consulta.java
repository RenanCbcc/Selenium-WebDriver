package consultar_requisicao_pagamento;

import static org.junit.Assert.assertTrue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import java.lang.AssertionError;

public class Teste_Consulta {
	private Logger logger = Logger.getLogger(Teste_Consulta.class.getCanonicalName());
	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
							// preenche os formulários

	@Before
	public void inicilizar() {
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
											 * Numero, N_Processo, Situacao,
											 * Devedor
											 */
			assertTrue(pagina.resultado("00010/2017", "0128300-28.2008.5.08.0009", "VARA DO TRABALHO DE ALTAMIRA",
					"Precatório", "Alimentar", "07/02/2017", "Parcialmente Paga", "Sim"));
			}

	@Test
	public void UC002_CT002_PD001_2() {
		try {

			this.pagina.novo().preencher("00000/0000", "",
					"");/* Numero, N_Processo, Situacao, Devedor */
			assertTrue(pagina.resultado("Nenhum registro encontrado."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Test
	public void UC002_CT001_PD001_3() {
		try {

			this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013",
					"Autuada");/* Numero, N_Processo, Situacao, Devedor */
			assertTrue(pagina.resultado("00254/2009", "0109400-24.2004.5.08.0013", "13ª VARA DO TRABALHO DE BELÉM",
					"Precatório", "Alimentar", "07/03/2016", "Autuada", "Não"));
		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		} catch (AssertionError ae) {
			logger.log(Level.SEVERE, ae.getMessage(), ae);
			assertTrue(false);
		} catch (NullPointerException npe) {
			logger.log(Level.SEVERE, npe.getMessage(), npe);
			assertTrue(false);
		}

	}

	@Ignore
	public static boolean consultar(String numero, String Finalizado, WebDriver driver) {
		Pagina pagina = new Pagina(driver);

		pagina.novo()
				.preencher(numero);/* Numero, N_Processo, Situacao, Devedor */

		return pagina.resultado("00254/2009", "Não");
	}

	@After
	public void fechar() {
		driver.close();
	}

}
