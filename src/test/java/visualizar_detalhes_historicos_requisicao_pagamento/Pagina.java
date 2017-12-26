package visualizar_detalhes_historicos_requisicao_pagamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import gep_pagamento_auxiliary.Helper;
import gep_pagamento_auxiliary.Report;

public class Pagina {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class)
				.ignoring(ElementNotVisibleException.class);

	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		Helper.pageSearcher(this.driver);
		Teste_Visualiza_Detalhes.getLogger().info("Aguardando....");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	}

	/**
	 * Method verifies whether the current information is correct.
	 * 
	 * @param argumentos
	 * @return
	 * 
	 *         <pre>
	 * boolean
	 *         </pre>
	 * 
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public boolean resultado(List<String> argumentos) throws TimeoutException, InterruptedException {

		List<String> tabela = new ArrayList<String>();

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='dlgInformacoesRequisicaoPagamento_title']"),
				"Mais informações da Requisição de Pagamento"));

		Teste_Visualiza_Detalhes.getLogger().info("verifica se existem resultados na listagem");

		tabela = Helper.getTextAndValueFromTable("//div[2]/fieldset/div/table/tbody");

		if (tabela.size() > argumentos.size()) {
			while (tabela.size() != argumentos.size()) {
				tabela.remove(tabela.size() - 1);
			}
		}

		System.out.println("tabela" + Arrays.toString(tabela.toArray()));
		System.out.println("argume" + Arrays.toString(argumentos.toArray()));

		Report.getLogger().info("Retornando Resultados");
		return argumentos.equals(tabela);

	}

	

}
