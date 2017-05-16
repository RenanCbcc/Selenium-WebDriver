package alterar_requisicao_pagamento_dados_processo;

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

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		// A partir daqui, teste o caso de teste TC01
		logger.info("Alterear Requisição de Pagamento");
		//TODO Thread is a bad programming practice. It must be replaced.
		Thread.sleep(5000);
		this.driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt110']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")));
		return new Preenche(this.driver);

	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
