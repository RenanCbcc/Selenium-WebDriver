package incluir_requisicao_pagamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;

public class Teste_Inclui {
	private static WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
	// preenche os formul�rios

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(driver);

	}

	@Test
	public void UC002_CT002_PD002_1() {

		/* Dados do Proceso */ this.pagina.novo().preencher("10000/1000", "0000002-18.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina
				.resultado("Erro: org.hibernate.exception.ConstraintViolationException: could not execute statement"));

	}

	@Ignore
	public void UC002_CT002_PD002_2() {

		this.pagina.novo().preencher("00010/2017");
		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe uma RP cadastrada com este n�mero."));

	}

	@Ignore
	public void UC002_CT002_PD002_3() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0000002-18.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Refer�ncia */ "01/01/2016", "01/09/2016", "01/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Data inv�lida. A Data do ajuizamento do processo de conhecimento deve ser menor que a Data do tr�nsito em julgado do processo de conhecimento."));

	}

	@Ignore
	public void UC002_CT002_PD002_4() { // <<<<<<<<<<<<<Revisar esse caso de
										// teste>;

		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0000002-18.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "670.198.542-49");

		assertTrue(pagina
				.resultado(" Procurador informado j� est� cadastrado como Benefici�rio. Opera��o n�o permitida."));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
