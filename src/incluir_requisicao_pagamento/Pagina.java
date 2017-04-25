package incluir_requisicao_pagamento;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;
import ancillary.Helper;

public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	
	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		
		Helper.pageSearcher(this.driver);
		logger.info("Incluir Requisicoes de Pagamento");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt89']"))).click();

		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt71")));

		return new Preenche(this.driver);
	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + this.driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
