package alterar_requisicao_pagamento_terceiro_interessado;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consultar_requisicao_pagamento.Teste_Consulta;

public class Teste_Altera_Terceiros_Interessados {

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
	public void UC002_CT0010_PD0010_1() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("7.000,00", "2.000,00", "Per aspera ad astra");
		assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));

	}

	@Test
	public void UC002_CT0010_PD0010_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		} else {
			this.pagina.novo().preencher("0", "0", "Per aspera ad astra");
			assertTrue(pagina
					.resultado("Erro: O valor total do benef�cio deve ser maior que zero. Opera��o n�o permitida."));
		}

	}
	/*

	@Ignore
	public void UC002_CT0010_PD0010_3() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica", "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado j� est� cadastrado como Procurador. Opera��o n�o permitida"));

	}

	@Ignore
	public void UC002_CT0010_PD0010_4() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Advocat�cios", "", "339.666.538-42");

		assertTrue(pagina
				.resultado("Erro: Advogado informado j� est� cadastrado como Procurador. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_5() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica", "071.275.546-25");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado j� est� cadastrado como Executado. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_6() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Advocat�cios", "Pessoa F�sica", "303.492.832-73");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado j� est� cadastrado como Executado. Opera��o n�o permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_7() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica", "071.275.546-25");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. J� existe um terceiro interessado cadastrado para este CNPJ."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_8() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica", "071.275.546-25");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. J� existe um terceiro interessado cadastrado para este CNPJ."));

	}
	*/

	@After
	public void fechar() {
		driver.close();
	}
}
