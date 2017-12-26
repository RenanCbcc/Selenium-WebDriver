package finalizar_cadastro;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import consultar_requisicao_pagamento.Teste_Consulta;
import gep_pagamento_auxiliary.Report;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Finalize Registry' Last test of the class:
 * 28/08/2017
 * 
 * @author Renan Rosa, Estagiario, SETIN.
 * @version 1.4
 * @since 15-03-2017
 */
public class Teste_Finalizar_Cadastro extends Report {

	@Test(groups = { "Smoke testing", "Regression testing" })
	public void UC002_CT011_PD011_1() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {

		logger = extent.createTest("UC002_CT011_PD011_1");
		if (!Teste_Consulta.consultar("00007/2018", "Não", this.driver)) {
			Assert.fail("Error 404: Process not found");

		}

		((Pagina) pagina).novo();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT011_PD011_2() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00005/2018", "Não", this.driver)) {
			Assert.fail("Error 404: Process not found");

		}

		((Pagina) pagina).novo();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado(
				"Erro: Não foi possível finalizar o cadastro. É necessário cadastrar pelo menos um beneficiário."));

	}

}
