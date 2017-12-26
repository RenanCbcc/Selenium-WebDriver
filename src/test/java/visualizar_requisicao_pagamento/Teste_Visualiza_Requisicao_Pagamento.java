package visualizar_requisicao_pagamento;

import java.util.Arrays;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import consultar_requisicao_pagamento.Teste_Consulta;
import gep_pagamento_auxiliary.Report;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition - Visualize' Last test of the class: 03/11/2017
 * 
 * @author Renan Rosa, Estagiario, SETIN.
 * @version 1.5
 * @since 20-03-2018
 */

public class Teste_Visualiza_Requisicao_Pagamento extends Report {

	@Test(groups = { "Smoke testing" })
	public void UC002_CT012_PD012_1() throws TimeoutException, InterruptedException {

		logger = extent.createTest("UC002_CT0012_PD0012_1");
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo();
		
		AssertJUnit.assertTrue(((Pagina) pagina).resultado(Arrays.asList(
				/* Dados do Processo */"00001/2018", "0000001-34.1983.5.08.0001", 
				/* Dados do Executado */"06.553.481/0001-49", "ESTADO DO PIAUI",
				/* Dados do Procurador */ "557.353.606-04", "BAPTISTE KYOSTI TIMOTHE",
				/* Beneficiarios */"Domingos Áine Feliciano", "113.255.348-20", "Não", "1.500,00",
				"Fyodor Osvald Efisio", "600.380.726-10", "Não", "85.630,00",
				/* Terceiros Interessados */"Helene Corina Alexandra", "458.922.837-80","", "Honorários Periciais",
				"9.000,00")));

	}
	
	@Test(groups = { "Regression testing" })
	public void UC002_CT012_PD012_2() throws TimeoutException, InterruptedException {

		logger = extent.createTest("UC002_CT0012_PD0012_1");
		if (!Teste_Consulta.consultar("00007/2018", "Não", this.driver)) {
			Assert.fail("Processo nao pode ser alterado");

		}

		((Pagina) pagina).novo();
		
		AssertJUnit.assertTrue(((Pagina) pagina).resultado(Arrays.asList(
				/* Dados do Processo */"00007/2018", "0000931-08.2014.5.08.0117", 
				/* Dados do Executado */"34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA",
				/* Dados do Procurador */ "448.985.451-06", "Valeri Lucrèce Sergius",
				/* Beneficiarios */"Domingos Áine Feliciano", "113.255.348-20", "Doença Grave", "252.990,00",
				"Fyodor Osvald Efisio", "600.380.726-10", "Não", "85.630,00",
				/* Terceiros Interessados */"Helene Corina Alexandra", "458.922.837-80","", "Honorários Periciais",
				"13.000,00")));

	}

/**
 * 00007/2018, 0000931-08.2014.5.08.0117, 34.621.748/0001-23, UNIVERSIDADE FEDERAL DO PARA, 
 * 448.985.451-06, Valeri Lucrèce Sergius, Domingos Áine Feliciano, 113.255.348-20, Doença Grave, 
 * 252.990,00, Fyodor Osvald Efisio, 600.380.726-10, Não, 85.630,00, Helene Corina Alexandra, 458.922.837-80
 * , , Honorários Periciais, 13.000,00
 */
}
