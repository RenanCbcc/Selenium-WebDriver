package alterar_requisicao_pagamento_beneficiario;

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

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public Preenche novo(String tipo)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		Teste_Altera_Beneficiario.getLogger().info("Aguardando....");
		// Wait for the payment requisitions table
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		Teste_Altera_Beneficiario.getLogger().info("Alterar Requisicoes de Pagamento");
		Helper.attemptingToClick("//button[4]");

		Teste_Altera_Beneficiario.getLogger().info("Selecionando Aba Beneficiario");
		// Wait for the payment requisitions table
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();

		if (tipo.equals("Beneficiario")) {
			Teste_Altera_Beneficiario.getLogger().info("Alterar Beneficiario....");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]"))).click();
		}

		else {
			Teste_Altera_Beneficiario.getLogger().info("Alterar Advogado....");
			fluentwait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath("//fieldset[3]/div/div/div/table/tbody/tr/td[5]/button")))
					.click();
		}

		return new Preenche(driver);

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

		// Wait for the payment requisitions table
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// It verify if the current WebElemet contains the desirable message.
		Teste_Altera_Beneficiario.getLogger()
				.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
