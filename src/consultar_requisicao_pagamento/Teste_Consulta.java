package consultar_requisicao_pagamento;

import java.util.ArrayList;
import java.util.Arrays;

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
 * 'Maintain Payment Requisition - Consult' Last test of the class: 04/10/2017
 * 
 * @author Renan Rosa, Estagiário, SETIN.
 * @version 1.2
 * @since 15-04-2017
 */
public class Teste_Consulta extends Report {

	/**
	 * @see {@link alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo#UC002_CT003_PD003_1()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test
	public void UC002_CT001_PD001_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		logger = extent.createTest("UC002_CT001_PD001_1");
		((Pagina) pagina).novo().preencher("00001/2018", "0000001-34.1983.5.08.0001", "Autuada",
				"UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23");
		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado(new ArrayList<String>(Arrays.asList("00001/2018", "0000001-34.1983.5.08.0001",
						"VARA DO TRABALHO DE BREVES", "Precatório", "Alimentar", "19/10/2017", "Autuada", "Não"))));
	}

	@Test(enabled = false)
	public void UC002_CT002_PD001_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		((Pagina) pagina).novo().preencher("00001/0000", "", "");
		AssertJUnit.assertTrue(
				((Pagina) pagina).resultado(new ArrayList<String>(Arrays.asList("Nenhum registro encontrado."))));

	}

	@Test(enabled = false)
	public void UC002_CT001_PD001_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		((Pagina) pagina).novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "Autuada");
		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado(new ArrayList<String>(Arrays.asList("00254/2009", "0109400-24.2004.5.08.0013",
						"13ª VARA DO TRABALHO DE BELÉM", "Precatório", "Alimentar", "07/03/2016", "Autuada", "Sim"))));

	}

	/**
	 * Static method used as precondition of other test.
	 * 
	 * @param numero
	 * @param Finalizado
	 * @param driver
	 * @return
	 */
	@Test(enabled = false)
	public static boolean consultar(String numero, String finalizado, WebDriver driver)
			throws TimeoutException, InterruptedException {
		Pagina pagina = new Pagina(driver);

		pagina.novo().preencher(numero);

		return pagina.resultado(numero, finalizado);
	}

}
