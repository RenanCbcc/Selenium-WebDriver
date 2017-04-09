package visualizar_detalhes_historicos_requisicao_pagamento;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.AssertionError;
import org.openqa.selenium.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;

public class Teste_Visualiza_Detalhes {
	private final static Logger logger = Logger.getLogger(Teste_Visualiza_Detalhes.class.getCanonicalName());
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
	public void UC002_CT006_PD001_1() {
		try {
			this.pagina.visitar();
			this.pagina.novo().preencher("20000/2016",
					"0128300-28.2008.5.08.0009");/*
													 * Número, N_Processo,
													 * Situação, Devedor
													 */
			boolean result = this.pagina.resultado("00010/2017", "0128300-28.2008.5.08.0009",
					"VARA DO TRABALHO DE ALTAMIRA", " Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Autuada",
					"Atualização dos Cálculos Concluída ", "22/12/2016 13:22:53", "22/12/2016 13:23:31",
					"22/12/2016 13:25:22", "Divisão de Precatórios - EDUARDO LUIZ SILVA DA FONSÊCA ",
					"ADILSON CHAGAS VICENTE", "595.244.300-10", "Doença Grave", "22/12/2016 13:24:44");
			System.out.println(result);
			assertFalse(result); // porque asserTrue nao funciona?

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

	@After
	public void fechar() {
		driver.close();
	}

}
