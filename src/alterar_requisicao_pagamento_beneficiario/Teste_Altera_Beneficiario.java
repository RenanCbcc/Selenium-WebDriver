package alterar_requisicao_pagamento_beneficiario;



import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import consultar_requisicao_pagamento.Teste_Consulta;
import gep_pagamento_auxiliary.Report;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Alter Beneficiary' Last test of the class:
 * 04/10/2017
 * 
 * @author Renan Rosa, Estagiário, SETIN.
 * @version 1.3
 * @since 29-04-2017
 */
public class Teste_Altera_Beneficiario extends Report {

	@Test
	public void UC002_CT008_PD002_1() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT008_PD002_1");
		
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("404 Process not found");

		}
		((Pagina) pagina).novo("Beneficiario").preencher("Não", "", "1.000,00", "100,00", "100,00", "100,00", "100,00",
				"100,00", "Hello World!");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Operação Realizada com Sucesso"));

	}

	@Test(enabled = false)
	public void UC002_CT008_PD002_2() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT008_PD002_2");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("404 Process not found");
		}

		((Pagina) pagina).novo("Beneficiario").preencher("", "", "1.000,00", "100,00", "100,00", "100,00", "100,00", "100,00",
				"Hello World!");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Campo Obrigatório: Foi deferido o benefício de prioridade processual?."));

	}

	@Test(enabled = false)
	public void UC002_CT008_PD002_3() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT008_PD002_3");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("404 Process not found");
		}

		((Pagina) pagina).novo("Beneficiario").preencher("Sim", "", "1.000,00", "100,00", "100,00", "100,00", "100,00",
				"100,00", "Hello World!");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Campo Obrigatório: Tipo de Prioridade."));
	}

	@Test(enabled = false)
	public void UC002_CT008_PD002_4() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT008_PD002_4");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");
		}
		((Pagina) pagina).novo("Beneficiario").preencher("Não", "", "0", "0", "0", "0", "0", "0", "Hello World!");
		AssertJUnit.assertTrue(
				((Pagina) pagina).resultado("Erro: O valor total do benefício deve ser maior que zero. Operação não permitida."));

	}

}
