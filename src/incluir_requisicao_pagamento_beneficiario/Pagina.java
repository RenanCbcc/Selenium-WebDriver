package incluir_requisicao_pagamento_beneficiario;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver>fluentwait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	/**
	 * Standard method used access the tab 'Beneficiary'
	 * 
	 * @param tipo
	 * @param numero
	 * @param processo
	 * @return
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public Preenche novo(String numero, String processo)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		Helper.pageSearcher(this.driver);

		logger.info("Aguardando....");

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Preenchendo Numero requsicao de Pagamento");
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).sendKeys(numero);

		logger.info("Preenchendo Numero processo");
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).sendKeys(processo);
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form/fieldset/div/table/tbody/tr[5]/td[1]/button"))
				.click();

		logger.info("Aguardando....");
		// wait for requisition table
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Alterar Requisicoes de Pagamento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/form/div/div[2]/table/tbody/tr/td[9]/button[4]"))).click();

		logger.info("Selecionando Aba Beneficiario");
		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();

		return new Preenche(driver);

	}

	/**
	 * Auxiliary method used to include in a already loaded 'Beneficiary' page a
	 * Beneficiary or a Lawyer, without search a new page again.
	 * 
	 * @param tipo
	 * @return
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		return new Preenche(driver);

	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
