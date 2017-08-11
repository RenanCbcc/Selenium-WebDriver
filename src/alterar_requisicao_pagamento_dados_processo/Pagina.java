package alterar_requisicao_pagamento_dados_processo;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(6, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		// A partir daqui, teste o caso de teste TC01
		logger.info("Alterear Requisição de Pagamento");

		WebElement fieldP = fluentwait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[4]/div/div/div/form/div/div[2]/table/tbody/tr/td[9]/button[4]")));
		
		fluentwait.until(ExpectedConditions.elementToBeClickable(fieldP)).click();
		
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")));
		return new Preenche(this.driver);

	}

	/**
	 * Method used to verify if a specific message is returned to confirm a
	 * success operation.
	 * 
	 * @param resultado
	 * @return boolean
	 * @throws TimeoutException
	 */
	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
