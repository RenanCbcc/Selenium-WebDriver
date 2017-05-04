package alterar_requisicao_pagamento_terceiro_interessado;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;


public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private final static Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public Preenche novo()
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		logger.info("Alterar Requisicoes de Pagamento");
		driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt112']")).click();

		logger.info("Aba Terceiros Interessados");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[3]/a"))).click();

		return new Preenche(driver);
	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
