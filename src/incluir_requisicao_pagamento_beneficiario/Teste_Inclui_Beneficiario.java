package incluir_requisicao_pagamento_beneficiario;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import gep_pagamento_auxiliary.Report;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Include Beneficiary' Last test of the class:
 * 04/10/2017
 * 
 * @author Renan Rosa, Estagiário, SETIN.
 * @version 1.3
 * @since 15-04-2017
 */
public class Teste_Inclui_Beneficiario extends Report {

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test
	public void UC002_CT007_PD002_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT007_PD002_1");
		Preenche preenche = ((Pagina) pagina).novo("00001/2018", "0000001-34.1983.5.08.0001");

		preenche.preencher("Pessoa Física", "600.380.726-10", "Fyodor Osvald Efisio", "07/03/1900", false, "",
				"1.000,00", "100,00", "100,00", "100,00", "42.165,00", "42.165,00", "Per aspera ad astra");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

		preenche.preencher("357.579.517-70", "Lazare Ernesto Fleur", "MG", "000000", "Advogado");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

		preenche.preencher("Pessoa Física", "113.255.348-20", "Domingos Áine Feliciano", "07/03/1900", true,
				"Doença Grave", "42.165,00", "42.165,00", "42.165,00", "42.165,00", "42.165,00", "42.165,00",
				"Per aspera ad astra");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

		/*
		 * // Verifica se, após as passos acima, o beneficiário é mostrado na
		 * lista // interna. assertTrue(Teste_Lista.listar( Arrays.
		 * asList("AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR - 01.175.497/0001-41"
		 * , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "true",
		 * "true", "false"), Arrays.asList(
		 * 
		 * "1", "11/01/2016", "0000273-62.2015.5.08.0209", "00004/2016",
		 * "21/03/2016", "2017", "18.000,00", "16/12/2015",
		 * "JOSE CARLOS ZINGRA - 016.857.028-99 18.000,00 0,00 0,00 0,00 18.000,00 Doença Grave"
		 * ), driver));
		 */
	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test(enabled = false)
	public void UC002_CT007_PD002_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT007_PD002_2");
		((Pagina) pagina).novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("Pessoa Física", "557.353.606-04");

		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado("Erro: Beneficiário informado já está cadastrado como Procurador. Operação não permitida."));

	}

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test(enabled = false)
	public void UC002_CT007_PD002_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT007_PD002_3");
		((Pagina) pagina).novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("Pessoa Jurídica", "06.553.481/0001-49");

		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado("Erro: Beneficiário informado já está cadastrado como Executado. Operação não permitida."));

	}

	/**
	 * @throws InterruptedException
	 * @throws WebDriverException
	 * @throws TimeoutException
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 */
	@Test(enabled = false)
	public void UC002_CT007_PD002_4() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT007_PD002_4");
		((Pagina) pagina).novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("557.353.606-04");
		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario#UC002_CT007_PD002_1()}
	 */
	@Test(enabled = false)
	public void UC002_CT007_PD002_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT007_PD002_5");
		((Pagina) pagina).novo("00002/2018", "0000008-25.2008.5.08.0009").preencher("Pessoa Física", "357.579.517-70");

		AssertJUnit.assertTrue(
				((Pagina) pagina).resultado("Erro: Registro duplicado. Já existe um benefício cadastrado para este CPF."));

	}

	/**
	 * @throws InterruptedException
	 * @throws WebDriverException
	 * @throws TimeoutException
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @see {@link incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario#UC002_CT007_PD002_1()}
	 */
	@Test(enabled = false)
	public void UC002_CT007_PD002_6() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT007_PD002_6");
		((Pagina) pagina).novo("00001/2018", "0000006-55.2008.5.08.0009").preencher("357.579.517-70");
		AssertJUnit.assertTrue(
				((Pagina) pagina).resultado("Erro: Registro duplicado. Já existe um advogado cadastrado com este CPF."));

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
	 * @throws InterruptedException
	 * @throws WebDriverException
	 * @throws TimeoutException
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 */
	@Test(enabled = false)
	public static boolean incluir_Beneficiario(WebDriver driver, String Tipo_Pessoa, String Documento_Fiscal,
			String Nome, String Data_Nascimento, Boolean Prioridade, String Tipo_Prioridade, String Exeq_Liquido,
			String INSS_Beneficiario, String INSS_Executado, String IR, String FGTS, String Custas_Judiciais,
			String Observacao) throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_Pessoa, Documento_Fiscal, Nome, Data_Nascimento, Prioridade, Tipo_Prioridade,
				Exeq_Liquido, INSS_Beneficiario, INSS_Executado, IR, FGTS, Custas_Judiciais, Observacao);

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
	@Test(enabled = false)
	public static boolean incluir_Beneficiario(WebDriver driver, String Tipo_Pessoa, String Documento_Fiscal,
			String Nome, String Exeq_Liquido, String INSS_Beneficiario, String INSS_Executado, String IR, String FGTS,
			String Custas_Judiciais, String Observacao) throws NoSuchElementException, ElementNotVisibleException,
			TimeoutException, WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Tipo_Pessoa, Documento_Fiscal, Nome, Exeq_Liquido, INSS_Beneficiario, INSS_Executado,
				IR, FGTS, Custas_Judiciais, Observacao);

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
	@Test(enabled = false)
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

	@Test(enabled = false)
	public static void incluir_Advogado(WebDriver driver, String Documento_Fiscal) throws NoSuchElementException,
			ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(Documento_Fiscal);

	}

}
