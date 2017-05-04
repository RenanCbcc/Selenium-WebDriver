package excluir_requisicao_pagamento;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
		
	}

	public void excluir() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		// A partir daqui, teste o caso de teste TC01
		logger.info("Exclir Requisição de Pagamento");
		this.driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt115']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt118']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt117']")));
		this.driver.findElement(By.xpath(".//*[@id='j_idt118']")).click();

	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
