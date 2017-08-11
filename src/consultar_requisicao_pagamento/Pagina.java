package consultar_requisicao_pagamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import gep_pagamento_auxiliary.Helper;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		Helper.pageSearcher(this.driver);

		logger.info("Aguardando....");

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	}

	/**
	 * Method receives as argument a list of string and, soon after, compares it with the current information at the screen
	 * @param argumentos
	 * @return
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public boolean resultado(List<String> argumentos) throws TimeoutException, InterruptedException {

		logger.info("verifica se existem resultados na listagem");
		List<String> tabela = new ArrayList<String>();
		Thread.sleep(2000);

		if (argumentos.size() > 1) {
			tabela = Helper.getCellsfromTableWithoutButton(".//*[@id='tblRequisicoes']/div[2]/table");
		} else {
			tabela = Helper.getCellsfromTable(".//*[@id='tblRequisicoes']/div[2]/table");
		}
		Collections.sort(argumentos);
		Collections.sort(tabela);

		System.out.println(Arrays.toString(tabela.toArray()));
		System.out.println(Arrays.toString(argumentos.toArray()));

		return tabela.equals(argumentos);

	}

	public boolean resultado(String numero, String cadastro) throws TimeoutException, InterruptedException {

		// List<String> argumentos = new
		// ArrayList<String>(Arrays.asList(numero,processo, vara, requsicao,
		// data, situacao, cadastro));
		String[] args = { numero, cadastro };
		String[] tabela = new String[args.length];

		logger.info("Verifica se existem resultados na listagem");

		Thread.sleep(2000);

		tabela[0] = driver.findElement(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[1]")).getText();
		tabela[1] = driver.findElement(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[8]")).getText();

		Arrays.sort(args);
		Arrays.sort(tabela);

		logger.info("Retornando Resultado");
		return Arrays.equals(args, tabela);

	} 

	public boolean resultado(String resultado) throws TimeoutException {

		
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='tblRequisicoes:j_idt89']"), "Requisições de Pagamento"));

		
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

	public void print(String s) {
		System.out.println(s);
	}

}
