package visualizar_Informacoes_resumidas_requisicao_pagamento;

import java.util.Arrays;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import gep_pagamento_auxiliary.Report;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Visualize Registry' Last test of the class:
 * 04/10/2018
 * 
 * @author Renan Rosa, Estagiario, SETIN.
 * @version 1.5
 * @since 15-04-2018
 */
public class Teste_Visualiza extends Report {

	@Test(groups = { "Smoke testing", "Regression testing" })
	public void UC002_CT005_PD001_1() throws TimeoutException, InterruptedException {
		logger = extent.createTest("|UC002_CT005_PD001_1");
		((Pagina) pagina).novo().preencher("00001/2018", "0000006-55.2008.5.08.0009");
		if (((Pagina) pagina)
				.resultado(Arrays.asList("00001/2018", "0000006-55.2008.5.08.0009", "VARA DO TRABALHO DE CASTANHAL"))) {
			AssertJUnit.assertTrue(true);
		} else {
			Assert.fail("Error 404: Process not found");
		}

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT005_PD001_2() throws TimeoutException, InterruptedException {
		logger = extent.createTest("|UC002_CT005_PD001_1");
		((Pagina) pagina).novo().preencher("00002/2018", "0000008-25.2008.5.08.0009");
		if (((Pagina) pagina).resultado(Arrays.asList("00002/2018", "0000008-25.2008.5.08.0009",
				"VARA DO TRABALHO DE ALTAMIRA"))) {
			AssertJUnit.assertTrue(true);
		} else {
			Assert.fail("Error 404: Process not found");
		}

	}

	@Test(groups = { "Regression testing" })
	public void UC002_CT005_PD001_3() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT005_PD001_3");
		((Pagina) pagina).novo().preencher("00003/2018", "0000008-25.2008.5.08.0009");

		if (((Pagina) pagina).resultado(Arrays.asList("00003/2018", "0000008-25.2008.5.08.0009",
				"VARA DO TRABALHO DE ALTAMIRA", "RPV", "Alimentar"))) {
			AssertJUnit.assertTrue(true);
		} else {
			Assert.fail("Error 404: Process not found");
		}

	}

}
