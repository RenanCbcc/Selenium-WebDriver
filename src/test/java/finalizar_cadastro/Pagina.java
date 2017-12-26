package finalizar_cadastro;

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

import gep_pagamento_auxiliary.Report;

public class Pagina {

	private WebDriver driver;
	private Wait<WebDriver> fluentwait;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(6, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	public void novo()
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		Report.getLogger().info("Finalizar Requisicao de Pagamento");
		// TODO Thread is a bad programming practice. It must be replaced.
		Thread.sleep(2000);
		this.driver.findElement(By.xpath("//button[4]")).click();

		Report.getLogger().info("Salvar e continuar");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/table/tbody/tr/td[1]/button")))
				.click();

		fluentwait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(".//*[@id='j_idt73:dialogStatus']"),
				"Aguardando..."));

		Report.getLogger().info("Finalizar Cadastro");

		fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/table/tbody/tr/td[2]/button")))
				.click();

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

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		Report.getLogger()
				.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
