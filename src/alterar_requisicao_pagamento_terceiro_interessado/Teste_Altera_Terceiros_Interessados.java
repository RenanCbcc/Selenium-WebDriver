package alterar_requisicao_pagamento_terceiro_interessado;

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
 * 'Maintain Payment Requisition - Include Beneficiary' Last test of the class:
 * 04/10/2017
 * 
 * @author Renan Rosa, Estagi�rio, SETIN.
 * @version 1.3
 * @since 15-04-2017
 */
public class Teste_Altera_Terceiros_Interessados extends Report {

	
	@Test
	public void UC002_CT010_PD010_1() throws TimeoutException, InterruptedException {
		logger = extent.createTest("UC002_CT0010_PD0010_1");
		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo().preencher("7.000,00", "2.000,00", "Per aspera ad astra");
		AssertJUnit.assertTrue(((Pagina) pagina).resultado("Opera��o Realizada com Sucesso"));

	}

	@Test(enabled = false)
	public void UC002_CT0010_PD0010_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		} else {
			((Pagina) pagina).novo().preencher("0", "0", "Per aspera ad astra");
			AssertJUnit.assertTrue(((Pagina) pagina)
					.resultado("Erro: O valor total do benef�cio deve ser maior que zero. Opera��o n�o permitida."));
		}

	}
	/*
	 * 
	 * @Ignore public void UC002_CT0010_PD0010_3() throws TimeoutException,
	 * InterruptedException {
	 * 
	 * if (!Teste_Consulta.consultar("00000/2018", "N�o", this.driver)) {
	 * fail("Processo nao pode ser alterado");
	 * 
	 * }
	 * 
	 * this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica",
	 * "557.353.606-04");
	 * 
	 * assertTrue(pagina.resultado(
	 * "Erro: Terceiro interessado informado j� est� cadastrado como Procurador. Opera��o n�o permitida"
	 * ));
	 * 
	 * }
	 * 
	 * @Ignore public void UC002_CT0010_PD0010_4() throws TimeoutException,
	 * InterruptedException { if (!Teste_Consulta.consultar("00000/2018", "N�o",
	 * this.driver)) { fail("Processo nao pode ser alterado");
	 * 
	 * }
	 * 
	 * this.pagina.novo().preencher("Honor�rios Advocat�cios", "",
	 * "339.666.538-42");
	 * 
	 * assertTrue(pagina
	 * .resultado("Erro: Advogado informado j� est� cadastrado como Procurador. Opera��o n�o permitida."
	 * ));
	 * 
	 * }
	 * 
	 * @Ignore public void UC002_CT0010_PD0010_5() throws TimeoutException,
	 * InterruptedException { if (!Teste_Consulta.consultar("00000/2018", "N�o",
	 * this.driver)) { fail("Processo nao pode ser alterado");
	 * 
	 * }
	 * 
	 * this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica",
	 * "071.275.546-25"); assertTrue(pagina.resultado(
	 * "Erro: Terceiro interessado informado j� est� cadastrado como Executado. Opera��o n�o permitida."
	 * ));
	 * 
	 * }
	 * 
	 * @Ignore public void UC002_CT0010_PD0010_6() throws TimeoutException,
	 * InterruptedException { if (!Teste_Consulta.consultar("00000/2018", "N�o",
	 * this.driver)) { fail("Processo nao pode ser alterado");
	 * 
	 * }
	 * 
	 * this.pagina.novo().preencher("Honor�rios Advocat�cios", "Pessoa F�sica",
	 * "303.492.832-73");
	 * 
	 * assertTrue(pagina.resultado(
	 * "Erro: Terceiro interessado informado j� est� cadastrado como Executado. Opera��o n�o permitida."
	 * ));
	 * 
	 * }
	 * 
	 * @Ignore public void UC002_CT0010_PD0010_7() throws TimeoutException,
	 * InterruptedException { if (!Teste_Consulta.consultar("00000/2018", "N�o",
	 * this.driver)) { fail("Processo nao pode ser alterado");
	 * 
	 * }
	 * 
	 * this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica",
	 * "071.275.546-25"); assertTrue(pagina
	 * .resultado("Erro: Registro duplicado. J� existe um terceiro interessado cadastrado para este CNPJ."
	 * ));
	 * 
	 * }
	 * 
	 * @Ignore public void UC002_CT0010_PD0010_8() throws TimeoutException,
	 * InterruptedException { if (!Teste_Consulta.consultar("00000/2018", "N�o",
	 * this.driver)) { fail("Processo nao pode ser alterado");
	 * 
	 * }
	 * 
	 * this.pagina.novo().preencher("Honor�rios Periciais", "Pessoa F�sica",
	 * "071.275.546-25"); assertTrue(pagina
	 * .resultado("Erro: Registro duplicado. J� existe um terceiro interessado cadastrado para este CNPJ."
	 * ));
	 * 
	 * }
	 */

}
