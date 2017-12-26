package excluir_requisicao_pagamento;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import consultar_requisicao_pagamento.Teste_Consulta;
import gep_pagamento_auxiliary.Report;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Exclude Process' Last test of the class:
 * 03/11/2018
 * 
 * @author Renan Rosa, Estagiario, SETIN.
 * @version 1.5
 * @since 15-04-2018
 */
public class Teste_Exclui extends Report {

	@Test(groups = { "Smoke testing", "Regression testing" })
	public void UC002_CT004_PD004_1() throws TimeoutException, InterruptedException {

		logger = extent.createTest("UC002_CT004_PD004_1");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).excluir();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT004_PD004_2() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT004_PD004_2");
		if (!Teste_Consulta.consultar("00002/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).excluir();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT004_PD004_3() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT004_PD004_3");
		if (!Teste_Consulta.consultar("00003/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).excluir();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT004_PD004_4() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT004_PD004_4");
		if (!Teste_Consulta.consultar("00004/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).excluir();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT004_PD004_5() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT004_PD004_5");
		if (!Teste_Consulta.consultar("00005/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).excluir();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT004_PD004_6() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT004_PD004_6");
		if (!Teste_Consulta.consultar("00006/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).excluir();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

}
