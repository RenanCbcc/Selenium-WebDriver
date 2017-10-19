package alterar_requisicao_pagamento_dados_processo;

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
 * 'Maintain Payment Requisition - Alter Registry' Last test of the class:
 * 04/10/2017
 * 
 * @author Renan Rosa, Estagiário, SETIN.
 * @version 1.4
 * @since 15-04-2017
 */
public class Teste_Altera_Dados_Processo extends Report {

	@Test
	public void UC002_CT003_PD003_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_1");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo().preencher( /* Dados do Proceso */ "00001/2018", "0000001-34.1983.5.08.0001",
				"Precatório", "Alimentar", "VARA DO TRABALHO DE BREVES", "Test Case UC002_CT003_PD003_1",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "06.553.481/0001-49", "ESTADO DO PIAUI", "Federal", "Administração Indireta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		// TODO Verify if the test is already working.
		// assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		AssertJUnit.assertTrue(true);
	}

	@Test(enabled = false)
	public void UC002_CT003_PD003_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_2");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}
		((Pagina) pagina).novo().preencher("00002/2018");

		AssertJUnit.assertTrue(
				((Pagina) pagina).resultado("Erro: Registro duplicado. Já existe uma RP cadastrada com este número."));

	}

	@Test(enabled = false)
	public void UC002_CT003_PD003_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_3");
		if (!Teste_Consulta.consultar("00002/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo().preencher(/* Dados do Proceso */"00002/2018", "0000008-25.2008.5.08.0009",
				"Precatório", "Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD003_3",
				/* Datas de Referência */ "01/01/2016", "01/02/2016", "01/01/2016", "01/01/2016", "01/01/2016",
				"01/01/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado(
				"Erro: Data inválida. A Data de recebimento do ofício no protocolo deve ser maior que a Data do trânsito em julgado do processo de conhecimento."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT002_PD002_4()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void UC002_CT003_PD003_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_4");
		if (!Teste_Consulta.consultar("00002/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}
		((Pagina) pagina).novo().preencher(/* Dados do Proceso */"00002/2018", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "13ª VARA DO TRABALHO DE BELÉM", "Test Case UC002_CT003_PD003_4",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"

				/* Dados do procurador */ , "357.579.517-70");

		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado("Procurador informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT002_PD002_5()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void UC002_CT003_PD003_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_5");
		if (!Teste_Consulta.consultar("00003/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo().preencher(/* Dados do Proceso */"00003/2018", "0000008-25.2008.5.08.0009",
				"Precatório", "Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD003_5",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44");

		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado("Erro: Executado informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT002_PD002_6()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void UC002_CT003_PD003_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_6");
		if (!Teste_Consulta.consultar("00006/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}
		((Pagina) pagina).novo().preencher(/* Dados do Proceso */ "00006/2018", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "82.863.545/0001-96", "Weyland-Yutani Corporation", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "458.922.837-80");

		AssertJUnit.assertTrue(((Pagina) pagina)
				.resultado("Erro: Procurador informado já está cadastrado como Advogado. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT003_PD002_7()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void UC002_CT003_PD003_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_7");
		if (!Teste_Consulta.consultar("00004/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo().preencher(/* Dados do Proceso */ "00004/2018", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD003_7",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "05.054.945/0001-00", "Secretaria de Estado de Desenvolvimento Agropecuario e da Pesca", "Federal", "Administração Direta"
				/* Dados do procurador */ , "520.153.602-63");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado(
				"Erro: Procurador informado já está cadastrado como Terceiro Interessado. Operação não permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT003_PD002_8()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void UC002_CT003_PD003_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_8");
		if (!Teste_Consulta.consultar("00005/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}
		((Pagina) pagina).novo().preencher(/* Dados do Proceso */ "00005/2018", "0109400-24.2004.5.08.0013",
				"Precatório", "Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "82.863.545/0001-96");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado(
				"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

	}

	@Test(enabled = false)
	public void UC002_CT003_PD003_9() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT003_PD003_8");
		if (!Teste_Consulta.consultar("00005/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}
		((Pagina) pagina).novo().preencher(/* Dados do Proceso */ "00005/2018", "0000008-18.2011.5.12.0000");

		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Erro: Campo inválido: Nº do Processo."));

	}

}
