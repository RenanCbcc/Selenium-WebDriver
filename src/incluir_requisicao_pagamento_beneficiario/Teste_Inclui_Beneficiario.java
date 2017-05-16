package incluir_requisicao_pagamento_beneficiario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import gep_pagamento_auxiliary.Documents;
import static org.junit.Assert.assertTrue;

public class Teste_Inclui_Beneficiario {

	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
	// preenche os formulários

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
	public void UC002_CT007_PD002_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		this.pagina.novo("Beneficiario", "00201/2016", "0000500-07.2014.5.08.0203").preencher("Pessoa Física",
				Documents.getCPF(), "Nemo Nobody", "1950", false, "1.000,00", "100,00", "100,00", "100,00",
				"Per aspera ad astra");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

		this.pagina.novo("Advogado").preencher(Documents.getCPF(), "ABEL DA SILVA PEREIRA", "MG", "000000", "Advogado");

		assertTrue(pagina.resultado("Erro: Transaction rolled back"));
	}

	@Test
	public void UC002_CT007_PD002_2() {

		this.pagina.novo("Beneficiario", "00201/2016", "0000500-07.2014.5.08.0203").preencher("Pessoa Física",
				"729.673.582-15");

		assertTrue(pagina
				.resultado("Erro: Beneficiário informado já está cadastrado como Procurador. Operação não permitida."));

	}

	@Test
	public void UC002_CT007_PD002_3() {

		this.pagina.novo("Beneficiario", "00201/2016", "0000500-07.2014.5.08.0203").preencher("Pessoa Jurídica",
				"00.394.577/0001-25");

		assertTrue(pagina
				.resultado("Erro: Beneficiário informado já está cadastrado como Executado. Operação não permitida."));

	}

	@Test
	public void UC002_CT007_PD002_4() {

		this.pagina.novo("Advogado", "00201/2016", "0000500-07.2014.5.08.0203").preencher("729.673.582-15");
		assertTrue(pagina
				.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));

	}

	@Test
	public void UC002_CT007_PD002_5() {

		this.pagina.novo("Beneficiario", "00201/2016", "0000500-07.2014.5.08.0203").preencher("Pessoa Física",
				"570.908.582-00");

		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um benefício cadastrado para este CPF."));

	}

	@Test
	public void UC002_CT007_PD002_6() {

		this.pagina.novo("Advogado", "00201/2016", "0000500-07.2014.5.08.0203").preencher("328.747.402-25");
		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um advogado cadastrado com este CPF."));

	}

	/**
	 * Static method used to include a 'Beneficiary CPF', and after conclusion,
	 * verify whether any exception is thrown by the main Test. Any exceptions
	 * are not handled or expected at this test.
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Preenche#preencher(String, String, String, String, Boolean, String, String, String, String, String)}
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
			String Nome, String Data_Nascimento, Boolean Prioridade, String Exeq_Liquido, String INSS_Beneficiario,
			String INSS_Executado, String IR, String Observacao) {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_Pessoa, Documento_Fiscal, Nome, Data_Nascimento, Prioridade, Exeq_Liquido,
				INSS_Beneficiario, INSS_Executado, IR, Observacao);

		return pagina.resultado("Operação Realizada com Sucesso");
	}

	/**
	 * Static method used to include a 'Beneficiary CNPJ', and after conclusion,
	 * verify whether any exception is thrown by the main Test. Any exceptions
	 * are not handled or expected at this test.
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
	 */
	@Ignore
	public static boolean incluir_Beneficiario(WebDriver driver, String Tipo_Pessoa, String Documento_Fiscal,
			String Nome, String Exeq_Liquido, String INSS_Beneficiario, String INSS_Executado, String IR,
			String Observacao) {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_Pessoa, Documento_Fiscal, Nome, Exeq_Liquido, INSS_Beneficiario, INSS_Executado,
				IR, Observacao);

		return pagina.resultado("Operação Realizada com Sucesso");
	}
	
	/**
	 * Static method used to include a 'Lawyer CPF', and after conclusion,
	 * verify whether any exception is thrown by the main Test. Any exceptions
	 * are not handled or expected at this test.
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Preenche#preencher(String, String, String, String, Boolean, String, String, String, String, String)}
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
	public static boolean incluir_Beneficiario(WebDriver driver,String Documento_Fiscal, String Nome, String UF_OAB, String numero_OAB, String Tipo_OAB) throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Documento_Fiscal, Nome, UF_OAB, numero_OAB, Tipo_OAB);

		return pagina.resultado("Operação Realizada com Sucesso");
	}

	@After
	public void fechar() {
		driver.close();
	}
}
