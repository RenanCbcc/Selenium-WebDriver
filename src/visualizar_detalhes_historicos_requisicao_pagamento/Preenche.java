package visualizar_detalhes_historicos_requisicao_pagamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;

// Esta clase faz o preenchimento do formulario de buscas e os submete.
public class Preenche {
	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(Preenche.class.getCanonicalName());
	Wait<WebDriver> fluentwait;
	
	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public void preencher(String numero,String n_processo) 
					throws NoSuchElementException, TimeoutException, WebDriverException {
		
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inNrReq")));
		
		// 1ª linha
		WebElement campo_numero = driver.findElement(By.id("inNrReq"));
		WebElement capo_n_processo = driver.findElement(By.id("inNrProc"));
		
		logger.info("Preenchendo ou nao campo o Numero");
		campo_numero.clear();
		campo_numero.sendKeys(numero);


		logger.info("Preenchendo ou nao campo Processo");
		capo_n_processo.clear();
		capo_n_processo.sendKeys(n_processo);

		
		driver.findElement(By.xpath(".//*[@id='j_idt125']")).click();
		
			
		
	}

}
