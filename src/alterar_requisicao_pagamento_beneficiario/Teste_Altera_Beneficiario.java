package alterar_requisicao_pagamento_beneficiario;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import consultar_requisicao_pagamento.Teste_Consulta;

public class Teste_Altera_Beneficiario {

	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(driver);
	}

	@Test
	public void UC002_CT008_PD002_1() {

		if (!Teste_Consulta.consultar("00001/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo("Beneficiario").preencher(false, "1.000,00", "100,00", "100,00", "100,00",
				"Hello World!");

				assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));

	}

	@Ignore
	public void UC002_CT008_PD002_2() {

		if (!Teste_Consulta.consultar("00001/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");
		}

		this.pagina.novo("Beneficiario").preencher("Pessoa F�sica", "729.673.582-15");

		assertTrue(pagina
				.resultado("Erro: Benefici�rio informado j� est� cadastrado como Procurador. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT008_PD002_3() {
		if (!Teste_Consulta.consultar("00000/0000", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");
		}

		this.pagina.novo("Beneficiario").preencher("Pessoa Jur�dica", "05.054.861/0001-76");

		assertTrue(pagina
				.resultado("Erro: Benefici�rio informado j� est� cadastrado como Executado. Opera��o n�o permitida."));
	}

	@Ignore
	public void UC002_CT008_PD002_4() {
		if (!Teste_Consulta.consultar("00000/0000", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");
		}
		this.pagina.novo("Advogado").preencher("Pessoa F�sica", "729.673.582-15");
		assertTrue(pagina
				.resultado("Erro: Advogado informado j� est� cadastrado como Procurador. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT008_PD002_5() {
		if (!Teste_Consulta.consultar("00000/0000", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");
		}
		this.pagina.novo("Beneficiario").preencher("Pessoa F�sica", "357.579.517-70");

		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe um benef�cio cadastrado para este CPF."));

	}

	@Ignore
	public void UC002_CT008_PD002_6() {
		if (!Teste_Consulta.consultar("00000/0000", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");
		}
		this.pagina.novo("Advogado").preencher("Pessoa F�sica", "670.198.542-49");
		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe um advogado cadastrado com este CPF."));

	}
	
	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}
}
