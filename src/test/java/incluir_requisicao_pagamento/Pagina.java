package incluir_requisicao_pagamento;

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

import com.aventstack.extentreports.Status;

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
		Report.getLogger().log(Status.INFO, "Incluir Requisicoes de Pagamento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/button"))).click();
		Report.getLogger().log(Status.INFO, "Aguardando....");
		return new Preenche(this.driver);
	}

	/**
	 * Method used to verify if a specific message is returned to confirm a
	 * success operation.
	 * 
	 * @param resultado
	 * @return boolean
	 */
	public boolean resultado(String resultado) {

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		Report.getLogger().log(Status.INFO,
				"verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
