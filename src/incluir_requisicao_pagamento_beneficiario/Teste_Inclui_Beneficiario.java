package incluir_requisicao_pagamento_beneficiario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;


public class Teste_Inclui_Beneficiario {
	
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
		// Devo realizar uma inclus�o de processo aqui?
	}

	@Ignore // Testato!
	public void UC002_CT007_PD002_1() {

		this.pagina.novo("Beneficiario", "00010/2017", "0128300-28.2008.5.08.0009").preencher("Pessoa F�sica",
				"357.579.517-70", "Nemo", "1950", false, "1.000,00", "100,00", "100,00", "100,00",
				"Per aspera ad astra");

		assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));

		this.pagina.novo("Advogado", "00010/2017", "0128300-28.2008.5.08.0009").preencher("670.198.542-49",
				"ABEL DA SILVA PEREIRA", "PA", "000000000000", "Advogado");

		assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));

	}


	@Ignore
	public void UC002_CT007_PD002_2() {

		this.pagina.novo("Beneficiario", "00010/2017", "0128300-28.2008.5.08.0009").preencher("Pessoa F�sica",
				"729.673.582-15");

		assertTrue(pagina
				.resultado("Erro: Benefici�rio informado j� est� cadastrado como Procurador. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT007_PD002_3() {

		this.pagina.novo("Beneficiario", "00010/2017", "0128300-28.2008.5.08.0009").preencher("Pessoa Jur�dica",
				"05.054.861/0001-76");

		assertTrue(pagina
				.resultado("Erro: Benefici�rio informado j� est� cadastrado como Executado. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT007_PD002_4() {

		this.pagina.novo("Advogado", "00010/2017", "0128300-28.2008.5.08.0009").preencher("Pessoa F�sica",
				"729.673.582-15");
		assertTrue(pagina
				.resultado("Erro: Advogado informado j� est� cadastrado como Procurador. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT007_PD002_5() {

		this.pagina.novo("Beneficiario", "00010/2017", "0128300-28.2008.5.08.0009").preencher("Pessoa F�sica",
				"357.579.517-70");

		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe um benef�cio cadastrado para este CPF."));

	}

	@Ignore
	public void UC002_CT007_PD002_6() {

		this.pagina.novo("Advogado", "00010/2017", "0128300-28.2008.5.08.0009").preencher("Pessoa F�sica",
				"670.198.542-49");
		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe um advogado cadastrado com este CPF."));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
