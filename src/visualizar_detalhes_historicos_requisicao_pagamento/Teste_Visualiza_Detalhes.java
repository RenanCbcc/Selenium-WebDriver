package visualizar_detalhes_historicos_requisicao_pagamento;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Arrays;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import gep_pagamento_auxiliary.Report;

/**
 * Last test 07/08/2017
 * 
 * @author Renan Rosa
 * @since 20/03/2017
 * 
 */
public class Teste_Visualiza_Detalhes extends Report {

	@Test
	public void UC002_CT006_PD006_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {
		logger = extent.createTest("UC002_CT002_PD002_1");
		((Pagina) pagina).novo().preencher("00001/2018", "0000006-55.2008.5.08.0009");

		assertTrue(((Pagina) pagina).resultado(Arrays.asList("00001/2018", "0000006-55.2008.5.08.0009", "Precatório",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Autuada")));

	}

}
