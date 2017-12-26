package consultar_requisicao_pagamento;

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
	private Wait<WebDriver> fluentwait;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		Helper.pageSearcher(this.driver);

		Report.getLogger().info("Aguardando....");

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	}

	/**
	 * Method receives as argument a list of string and, soon after, compares it
	 * with the current information at the screen
	 * 
	 * @param argumentos
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public boolean resultado(List<String> argumentos) throws TimeoutException, InterruptedException {

		Report.getLogger().info("verifica se existem resultados na listagem");
		List<String> tabela = new ArrayList<String>();
		
		Thread.sleep(2000);

		if (argumentos.size() > 1) {
			tabela = Helper.getCellsfromTableWithoutButton(".//*[@id='tblRequisicoes']/div[2]/table");
		} else {
			tabela = Helper.getCellsfromTable(".//*[@id='tblRequisicoes']/div[2]/table");
		}

		// I only want two specific values.
		if (tabela.size() > argumentos.size()) {
			while (tabela.size() != argumentos.size()) {
				tabela.remove(tabela.size()-1);
			}
		}
		System.out.println("tabela"+Arrays.toString(tabela.toArray()));
		System.out.println("argume"+Arrays.toString(argumentos.toArray()));
		Report.getLogger().info("Retornando Resultados");
		return tabela.equals(argumentos);

	}

	/**
	 * Copied method from 'Consult payment requirement'
	 * 
	 * @param numero
	 * @param cadastro
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public boolean resultado(String numero, String cadastro) throws TimeoutException, InterruptedException {

		List<String> argumentos = new ArrayList<String>(Arrays.asList(numero, cadastro));

		List<String> tabela = new ArrayList<String>();

		Report.getLogger().info("Verifica se existem resultados na listagem");

		Thread.sleep(2000);

		tabela.addAll(Helper.getCellsfromTableWithoutButton(".//*[@id='tblRequisicoes']/div[2]/table"));

		// I only want two specific values.
		if (tabela.size() > 1) {
			while (tabela.size() != 2) {
				tabela.remove(1);
			}
		}


		System.out.println("tabela: "+Arrays.toString(tabela.toArray()));
		System.out.println("argume: "+Arrays.toString(argumentos.toArray()));
		Report.getLogger().info("Retornando Resultados");
		return argumentos.equals(tabela);

	}

	/**
	 * @deprecated
	 * @param resultado
	 * @return
	 * @throws TimeoutException
	 */
	public boolean resultado(String resultado) throws TimeoutException {

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='tblRequisicoes']/div[1]"), "Requisições de Pagamento"));

		Report.getLogger()
				.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

	public void print(String s) {
		System.out.println(s);
	}

}
