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
import incluir_requisicao_pagamento.Pagina;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Finalize Registry' Last test of the class:
 * 28/08/2017
 * 
 * @author Renan Rosa, Estagi�rio, SETIN.
 * @version 1.1
 * @since 15-03-2017
 */
public class Teste_Finalizar_Cadastro extends Report {

	
	@Test
	public void UC002_CT011_PD011_1() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			Assert.fail("Error 404: Process not found");

		}

		((Pagina) pagina).novo();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Opera��o Realizada com Sucesso"));

	}

	@Test(enabled = false)
	public void UC002_CT011_PD011_2() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00005/2018", "Sim", this.driver)) {
			Assert.fail("Error 404: Process not found");

		}

		((Pagina) pagina).novo();

		AssertJUnit.assertTrue(((Pagina) pagina).resultado(
				"Erro: N�o foi poss�vel finalizar o cadastro. � necess�rio cadastrar pelo menos um benefici�rio."));

	}

}
