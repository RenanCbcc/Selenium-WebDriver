package incluir_requisicao_pagamento_beneficiario;

import static org.junit.Assert.assertTrue;

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

public class Teste_Inclui_Beneficiario {

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

	@Ignore
	public void UC002_CT007_PD002_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("Pessoa Física", "600.380.726-10",
				"Fyodor Osvald Efisio", "1950", false, "", "1.000,00", "100,00", "100,00", "100,00",
				"Per aspera ad astra");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

		this.pagina.novo().preencher("357.579.517-70", "Lazare Ernesto Fleur", "MG", "000000", "Advogado");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT007_PD002_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("Pessoa Física", "557.353.606-04");

		assertTrue(pagina
				.resultado("Erro: Beneficiário informado já está cadastrado como Procurador. Operação não permitida."));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT007_PD002_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("Pessoa Jurídica", "06.553.481/0001-49");

		assertTrue(pagina
				.resultado("Erro: Beneficiário informado já está cadastrado como Executado. Operação não permitida."));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT007_PD002_4() {

		this.pagina.novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("557.353.606-04");
		assertTrue(pagina
				.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario#UC002_CT007_PD002_1()}
	 */
	@Test
	public void UC002_CT007_PD002_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("00002/2018", "0000008-25.2008.5.08.0009").preencher("Pessoa Física", "357.579.517-70");

		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um benefício cadastrado para este CPF."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario#UC002_CT007_PD002_1()}
	 */
	@Test
	public void UC002_CT007_PD002_6() {

		this.pagina.novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("357.579.517-70");
		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um advogado cadastrado com este CPF."));

	}

	/**
	 * Static method used to include a 'Beneficiary CPF', and after conclusion,
	 * verify whether any exception is thrown by the main Test. Any exceptions
	 * are not handled or expected at this sub-test.
	 * 
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Preenche#preencher(String, String, String, String, Boolean, String, String, String, String, String, String)}
	 * @param driver
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param Data_Nascimento
	 * @param Prioridade
	 * @param Exeq_Liquido
	 * @param INSS_Beneficiario
	 * @param INSS_Executado
	 * @param IR
	 * @param Observacao
	 * @return <code>boolean</code>
	 */
	@Ignore
	public static boolean incluir_Beneficiario(WebDriver driver, String Tipo_Pessoa, String Documento_Fiscal,
			String Nome, String Data_Nascimento, Boolean Prioridade, String Tipo_Prioridade, String Exeq_Liquido,
			String INSS_Beneficiario, String INSS_Executado, String IR, String Observacao) {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_Pessoa, Documento_Fiscal, Nome, Data_Nascimento, Prioridade, Tipo_Prioridade,
				Exeq_Liquido, INSS_Beneficiario, INSS_Executado, IR, Observacao);

		return pagina.resultado("Operação Realizada com Sucesso");
	}

	/**
	 * Static method used to include a 'Beneficiary CNPJ', and after conclusion,
	 * verify whether any exception is thrown by the main Test. Any exceptions
	 * are not handled or expected at this sub-test.
	 * 
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Preenche#preencher(String, String, String, String, String, String, String, String)}
	 * @param driver
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param Exeq_Liquido
	 * @param INSS_Beneficiario
	 * @param INSS_Executado
	 * @param IR
	 * @param Observacao
	 * @return <code>boolean</code>
	 * @throws InterruptedException
	 * @throws WebDriverException
	 * @throws TimeoutException
	 * @throws ElementNotVisibleException
	 * @throws NoSuchElementException
	 */
	@Ignore
	public static boolean incluir_Beneficiario(WebDriver driver, String Tipo_Pessoa, String Documento_Fiscal,
			String Nome, String Exeq_Liquido, String INSS_Beneficiario, String INSS_Executado, String IR,
			String Observacao) throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_Pessoa, Documento_Fiscal, Nome, Exeq_Liquido, INSS_Beneficiario, INSS_Executado,
				IR, Observacao);

		return pagina.resultado("Operação Realizada com Sucesso");
	}

	/**
	 * Static method used to include a 'Lawyer CPF', and after conclusion,
	 * verify whether any exception is thrown by the main Test. Any exceptions
	 * are not handled or expected at this sub-test.
	 * 
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Preenche#preencher(String, String, String, String,String)}
	 * @param driver
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param Data_Nascimento
	 * @param Prioridade
	 * @param Exeq_Liquido
	 * @param INSS_Beneficiario
	 * @param INSS_Executado
	 * @param IR
	 * @param Observacao
	 * @return <code>boolean</code>
	 * @throws InterruptedException
	 * @throws WebDriverException
	 * @throws TimeoutException
	 * @throws ElementNotVisibleException
	 * @throws NoSuchElementException
	 */
	@Ignore
	public static boolean incluir_Advogado(WebDriver driver, String Documento_Fiscal, String Nome, String UF_OAB,
			String numero_OAB, String Tipo_OAB) throws NoSuchElementException, ElementNotVisibleException,
			TimeoutException, WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Documento_Fiscal, Nome, UF_OAB, numero_OAB, Tipo_OAB);

		return pagina.resultado("Operação Realizada com Sucesso");
	}

	/**
	 * Static method used to attempt to include a 'Lawyer CPF' in order to throw
	 * an exception.
	 * 
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Preenche#preencher(String)}
	 * @param driver
	 * @param Documento_Fiscal
	 * @return void
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */

	@Ignore
	public static void incluir_Advogado(WebDriver driver, String Documento_Fiscal) throws NoSuchElementException,
			ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Documento_Fiscal);

	}

	@After
	public void fechar() {
		driver.close();
	}
}
