package incluir_requisicao_pagamento_terceiro_interessado;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consultar_requisicao_pagamento.Teste_Consulta;

/**
 * Last test: 08/08/2018
 * 
 * @author Renan Rosa
 * @version 1.3
 * 
 */
public class Teste_Inclui_Terceiros_Interessados {

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

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT009_PD009_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "458.922.837-80",
				"Helene Corina Alexandra", "10.000,00", "3.000,00", "Per aspera ad astra");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT009_PD009_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo().preencher("Honorários Advocatícios", "874.816.504-20", "Altair Almiro Göran",
				"Rio de Janeiro", "0000000", "Advogado", "10.000,00", "3.000,00", "Pecunia non olet tomba");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT009_PD009_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}

		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Procurador. Operação não permitida"));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Ignore
	public void UC002_CT009_PD009_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}

		this.pagina.novo().preencher("Honorários Advocatícios", "", "557.353.606-04");

		assertTrue(pagina
				.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT009_PD009_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Jurídica", "06.553.481/0001-49");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Executado. Operação não permitida."));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT009_PD009_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo().preencher("Outros", "Pessoa Jurídica", "06.553.481/0001-49");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Executado. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento_terceiro_interessado.Teste_Inclui_Terceiros_Interessados#UC002_CT009_PD009_1()}
	 */
	@Test
	public void UC002_CT009_PD009_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo().preencher("Honorários Periciais", "Pessoa Física", "458.922.837-80");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. Já existe um terceiro interessado cadastrado para este CPF."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento_terceiro_interessado.Teste_Inclui_Terceiros_Interessados#UC002_CT009_PD009_2()}
	 */
	@Test
	public void UC002_CT009_PD009_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo().preencher("Honorários Advocatícios", "Pessoa Física", "874.816.504-20");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. Já existe um terceiro interessado cadastrado com este CPF."));

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
	public static boolean incluir_Terceiro_Interessado(WebDriver driver, String Terceiro, String Tipo_honorario,
			String Tipo_Pessoa, String Documento_Fiscal, String Nome, String valorILiquido, String valor_IR,
			String Observacao) throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo(Terceiro).preencher(Tipo_honorario, Tipo_Pessoa, Documento_Fiscal, Nome, valorILiquido, valor_IR,
				Observacao);

		return pagina.resultado("Operação Realizada com Sucesso");

	}

	@After
	public void fechar() {
		driver.close();
	}
}
