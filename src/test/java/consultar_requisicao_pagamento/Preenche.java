package consultar_requisicao_pagamento;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentTest;

import gep_pagamento_auxiliary.Helper;
import gep_pagamento_auxiliary.Report;

public class Preenche {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private ExtentTest logger;

	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(6, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
		this.logger = Report.getLogger();

	}

	/**
	 * The main purpose of this method is to fill in the necessary fields used
	 * to search for a specific processes correctly. After this the search
	 * button is pressed.
	 * 
	 * @param numero
	 * @param n_processo
	 * @param situacao
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String numero, String n_processo, String situacao)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		WebElement campo_numero = driver.findElement(By.xpath(".//*[@id='inNrReq']"));
		WebElement capo_n_processo = driver.findElement(By.xpath(".//*[@id='inNrProc']"));

		logger.info("Preenchendo ou nao campo o Numero");
		campo_numero.clear();
		campo_numero.sendKeys(numero);

		logger.info("Preenchendo ou nao campo Processo");
		capo_n_processo.clear();
		capo_n_processo.sendKeys(n_processo);

		if (!situacao.isEmpty()) {
			Helper.isClickable(".//*[@id='cmbSituacao_label']");
			Helper.selectFromDropdown(situacao, ".//*[@id='cmbSituacao_panel']/div/ul/li");
		}

		
		driver.findElement(By.xpath("//td/button")).click();

		
		fluentwait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(".//*[@id='j_idt73:dialogStatus']"),
				"Aguardando..."));


	}

	/**
	 * The main purpose of this method is to fill in all the necessary fields
	 * used to search for a specific processes correctly. After this the search
	 * button is pressed.
	 * 
	 * @param numero
	 * @param n_processo
	 * @param situacao
	 * @param devedor
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String numero, String n_processo, String situacao, String devedor)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		WebElement campo_numero = driver.findElement(By.xpath(".//*[@id='inNrReq']"));
		WebElement capo_n_processo = driver.findElement(By.xpath(".//*[@id='inNrProc']"));

		logger.info("Preenchendo ou nao campo o Numero");
		campo_numero.clear();
		campo_numero.sendKeys(numero);

		logger.info("Preenchendo ou nao campo Processo");
		capo_n_processo.clear();
		capo_n_processo.sendKeys(n_processo);

		if (!situacao.isEmpty()) {
			Helper.isClickable(".//*[@id='cmbSituacao_label']");
			Helper.selectFromDropdown(situacao, ".//*[@id='cmbSituacao_panel']/div/ul/li");
		}

		if (!devedor.isEmpty()) {
			Helper.isClickable(".//*[@id='cmbDevedor']");
			Helper.selectFromDropdown(devedor, ".//*[@id='cmbDevedor_items']/li");
		}

		driver.findElement(By.xpath("//td/button")).click();

		
		fluentwait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(".//*[@id='j_idt73:dialogStatus']"),
				"Aguardando..."));


	}

	/**
	 * Method used to fill in the field number of process.
	 * 
	 * @param numero
	 */
	public void preencher(String numero) {
		WebElement campo_numero = driver.findElement(By.xpath(".//*[@id='inNrReq']"));
		logger.info("Preenchendo ou nao campo o Numero");
		campo_numero.clear();
		campo_numero.sendKeys(numero);
		driver.findElement(By.xpath("//table[@id='pnlConsulta']/tbody/tr[5]/td[1]/button")).click();
	}

}
