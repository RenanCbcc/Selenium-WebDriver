package alterar_requisicao_pagamento_beneficiario;

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
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public Preenche novo(String tipo) throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		
		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Alterar Requisicoes de Pagamento");
		driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt112']")).click();

		logger.info("Selecionando Aba Beneficiario");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();

		if (tipo.equals("Beneficiario")) {
			logger.info("Alterar Beneficiario....");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:tblBeneficios:0:j_idt219']"))).click();
		}

		else {
			logger.info("Alterar Advogado....");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:tblAdvogados:0:j_idt248']"))).click();
		}

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
