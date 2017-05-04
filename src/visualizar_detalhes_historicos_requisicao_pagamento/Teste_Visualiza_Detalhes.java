package visualizar_detalhes_historicos_requisicao_pagamento;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;


public class Teste_Visualiza_Detalhes {
	
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
	public void UC002_CT006_PD006_1() {
	

			this.pagina.novo().preencher("00002/1983",
					"0000002-18.2008.5.08.0009");/*
													 * Número, N_Processo,
													 * Situação, Devedor
													 */
			assertTrue(pagina.resultado("00002/1983", "0000002-18.2008.5.08.0009",
					"Precatório", "Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Autuada",
					"Atualização dos Cálculos Concluída ", "23/02/2017 14:58:54", "23/02/2017 14:59:41",
					"08/03/2017 10:44:59", "Divisão de Precatórios - EDUARDO LUIZ SILVA DA FONSÊCA",
					"Henrique Raul Fernandes", "589.873.531-33", "Doença Grave", "08/03/2017 10:44:22"));
			
			
		

	}

	@After
	public void fechar() {
		driver.close();
	}

}
