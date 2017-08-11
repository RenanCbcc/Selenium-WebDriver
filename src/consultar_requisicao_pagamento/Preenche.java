package consultar_requisicao_pagamento;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import gep_pagamento_auxiliary.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import java.util.logging.*;

// Esta clase faz o preenchimento do formulario de buscas e os submete.
public class Preenche {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Preenche.class.getCanonicalName());

	public Preenche(WebDriver driver) {
		this.driver = driver;
	
	}

	public void preencher(String numero, String n_processo, String situacao)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		// 1ª linha
		WebElement campo_numero = driver.findElement(By.xpath(".//*[@id='inNrReq']"));
		WebElement capo_n_processo = driver.findElement(By.xpath(".//*[@id='inNrProc']"));

		logger.info("Preenchendo ou nao campo o Numero");
		campo_numero.clear();
		campo_numero.sendKeys(numero);

		logger.info("Preenchendo ou nao campo Processo");
		capo_n_processo.clear();
		capo_n_processo.sendKeys(n_processo);

		if (situacao.isEmpty()) {
			logger.info("Buscando...");
			driver.findElement(By.xpath(".//*[@id='j_idt88']")).click();
		} else {
			logger.info("Preenchendo o campo Situação");
			
			Helper.isClickable(".//*[@id='cmbSituacao_label']");
			Helper.selectFromDropdown(situacao, ".//*[@id='cmbSituacao_panel']/div/ul/li");
			driver.findElement(By.xpath(".//*[@id='j_idt88']")).click();
		}

	}
	
	/**
	 * Method used to fill in the field number of process.
	 * @param numero
	 */
	public void preencher(String numero){
		WebElement campo_numero = driver.findElement(By.xpath(".//*[@id='inNrReq']"));
		logger.info("Preenchendo ou nao campo o Numero");
		campo_numero.clear();
		campo_numero.sendKeys(numero);
		driver.findElement(By.xpath(".//*[@id='j_idt88']")).click();
	}

	

}
