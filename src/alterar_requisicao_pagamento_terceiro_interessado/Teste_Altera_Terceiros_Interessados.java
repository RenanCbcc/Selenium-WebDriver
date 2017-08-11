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
	public void UC002_CT0010_PD0010_1() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("7.000,00", "2.000,00", "Per aspera ad astra");
		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	@Test
	public void UC002_CT0010_PD0010_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		} else {
			this.pagina.novo().preencher("0", "0", "Per aspera ad astra");
			assertTrue(pagina
					.resultado("Erro: O valor total do benefício deve ser maior que zero. Operação não permitida."));
		}

	}
	/*

	@Ignore
	public void UC002_CT0010_PD0010_3() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Procurador. Operação não permitida"));

	}

	@Ignore
	public void UC002_CT0010_PD0010_4() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Advocatícios", "", "339.666.538-42");

		assertTrue(pagina
				.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_5() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "071.275.546-25");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Executado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_6() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Advocatícios", "Pessoa Física", "303.492.832-73");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Executado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_7() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "071.275.546-25");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. Já existe um terceiro interessado cadastrado para este CNPJ."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_8() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "071.275.546-25");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. Já existe um terceiro interessado cadastrado para este CNPJ."));

	}
	*/

	@After
	public void fechar() {
		driver.close();
	}
}
