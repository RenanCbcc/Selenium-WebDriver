package incluir_requisicao_pagamento;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import gep_pagamento_auxiliary.Helper;

public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;

	public Pagina(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);

	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		Helper.pageSearcher(this.driver);
		Teste_inclui_requisicao_pagamento.getLogger().log(Status.INFO, "Incluir Requisicoes de Pagamento");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/button"))).click();
		Teste_inclui_requisicao_pagamento.getLogger().log(Status.INFO, "Aguardando....");
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

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		Teste_inclui_requisicao_pagamento.getLogger().log(Status.INFO,
				"verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
