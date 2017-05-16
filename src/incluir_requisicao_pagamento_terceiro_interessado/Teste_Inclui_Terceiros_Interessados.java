package incluir_requisicao_pagamento_terceiro_interessado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consultar_requisicao_pagamento.Teste_Consulta;
import gep_pagamento_auxiliary.Documents;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class Teste_Inclui_Terceiros_Interessados {

	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
							// preenche os formul�rios

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		// capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}

	@Test
	public void UC002_CT009_PD009_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("00204/2016", "0000480-85.2015.5.08.0007").preencher("Honor�rios Periciais", "Pessoa F�sica",
				Documents.getCPF(), "Aurelio Consuelo Bruno", "10.000,00", "3.000,00", "Per aspera ad astra");

		assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));

	}

	@Test
	public void UC002_CT009_PD009_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("00204/2016", "0000480-85.2015.5.08.0007").preencher("Honor�rios Advocat�cios",
				Documents.getCPF(), "Helene Corina Alexandra", "Rio de Janeiro", "0000000", "Advogado", "10.000,00",
				"3.000,00", "Pecunia non olet tomba");

		assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));

	}

	@Test
	public void UC002_CT009_PD009_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica", "874.816.504-20");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado j� est� cadastrado como Procurador. Opera��o n�o permitida"));

	}

	@Test
	public void UC002_CT009_PD009_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honor�rios Advocat�cios", "", "874.816.504-20");

		assertTrue(pagina
				.resultado("Erro: Advogado informado j� est� cadastrado como Procurador. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT009_PD009_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		if (!Teste_Consulta.consultar("00000/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa Jur�dica", "06.553.481/0001-49");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado j� est� cadastrado como Executado. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT009_PD009_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("Outros", "Pessoa Jur�dica", "06.553.481/0001-49");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado j� est� cadastrado como Executado. Opera��o n�o permitida."));

	}

	@Test
	public void UC002_CT009_PD009_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica", "448.985.451-06");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. J� existe um terceiro interessado cadastrado para este CPF."));

	}

	@Test
	public void UC002_CT009_PD009_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2017", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("Honor�rios Advocat�cios", "Pessoa F�sica", "448.985.451-06");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. J� existe um terceiro interessado cadastrado com este CPF."));

	}

	/**
	 * Method used to include a 'Terceiro_Interessado'
	 * 
	 * @see {@link incluir_requisicao_pagamento_terceiro_interessado.Preenche#preencher(String, String, String, String, String, String, String)}
	 * 
	 * @param driver
	 * @param Tipo_honorario
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param valorILiquido
	 * @param valor_IR
	 * @param Observacao
	 * @return boolean
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Ignore
	public static boolean incluir_Terceiro_Interessado(WebDriver driver, String Tipo_honorario, String Tipo_Pessoa,
			String Documento_Fiscal, String Nome, String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException,
			InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_honorario, Tipo_Pessoa, Documento_Fiscal, Nome, valorILiquido, valor_IR,
				Observacao);

		return pagina.resultado("Opera��o Realizada com Sucesso");

	}

	@After
	public void fechar() {
		driver.close();
	}
}
