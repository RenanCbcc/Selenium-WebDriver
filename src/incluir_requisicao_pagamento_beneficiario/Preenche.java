package incluir_requisicao_pagamento_beneficiario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;

// Esta clase faz o preenchimento do formulario de buscas e os submete.
public class Preenche {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Preenche.class.getCanonicalName());

	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	public void preencher(String n_documento, String nome_Benficiario, String data_nasc_Benficiario, Boolean prioridade,
			String valor_Exeq_Liquido, String valor_INSS_Beneficiario, String valor_INSS_Executado, String valor_IR,
			String Observacao) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando pessoa Fisica ");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa_panel']/div/ul/li[2]")))
				.click();

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(n_documento);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath(".//*[@id='j_idt507']")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(nome_Benficiario);
		}

		logger.info("Preenchendo data de nascimento do Benficiario");
		if (driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).clear();
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).sendKeys(data_nasc_Benficiario);
		}

		logger.info("Foi deferido o benefício de prioridade processual?*");
		if (prioridade) {
			fluentwait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(".//*[@id='cmbPrioridade']/tbody/tr/td[1]/div/div[2]/span")))
					.click();

		} else {
			fluentwait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(".//*[@id='cmbPrioridade']/tbody/tr/td[3]/div/div[2]/span")))
					.click();

		}

		logger.info("Preenchendo Exeq. Líquido*");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquido_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquido_input']")).sendKeys(valor_Exeq_Liquido);

		logger.info("Preenchendo INSS Beneficiario*");
		driver.findElement(By.xpath(".//*[@id='inVlInssBenef_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlInssBenef_input']")).sendKeys(valor_INSS_Beneficiario);

		logger.info("Preenchendo INSS Executado*");
		driver.findElement(By.xpath(".//*[@id='inVlInssExec_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlInssExec_input']")).sendKeys(valor_INSS_Executado);

		logger.info("Preenchendo IR*");
		driver.findElement(By.xpath(".//*[@id='inVlIr_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIr_input']")).sendKeys(valor_IR);

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).sendKeys(Observacao);

		if (isClickable(driver.findElement(By.xpath(".//*[@id='j_idt549']")))) {
			System.out.println("Salvar");
		} // fim
			// do
			// if.

	} // fim do metodo preenche.

	public void preencher(String n_documento, String nome_Benficiario, String valor_Exeq_Liquido,
			String valor_INSS_Beneficiario, String valor_INSS_Executado, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando pessoa Juridica");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa_panel']/div/ul/li[3]")))
				.click();

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inCnpjBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(n_documento);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath(".//*[@id='j_idt507']")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(nome_Benficiario);
		}

		logger.info("Preenchendo Exeq. Líquido*");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquido_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquido_input']")).sendKeys(valor_Exeq_Liquido);

		logger.info("Preenchendo INSS Beneficiario*");
		driver.findElement(By.xpath(".//*[@id='inVlInssBenef_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlInssBenef_input']")).sendKeys(valor_INSS_Beneficiario);

		logger.info("Preenchendo INSS Executado*");
		driver.findElement(By.xpath(".//*[@id='inVlInssExec_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlInssExec_input']")).sendKeys(valor_INSS_Executado);

		logger.info("Preenchendo IR*");
		driver.findElement(By.xpath(".//*[@id='inVlIr_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIr_input']")).sendKeys(valor_IR);

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).sendKeys(Observacao);

		if (isClickable(driver.findElement(By.xpath(".//*[@id='j_idt549']")))) {
			System.out.println("Salvar");
		} // fim
			// do
			// if.

	} // fim do metodo preenche.

	public void preencher(String n_documento, String nome_Benficiario, String UF_OAB, String numero_OAB,
			String tipo_OAB) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando pessoa Fisica ");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa_panel']/div/ul/li[2]")))
				.click();

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(n_documento);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath(".//*[@id='j_idt507']")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(nome_Benficiario);
		}

		/*
		 * logger.info("Foi deferido o benefício de prioridade processual?*");
		 * if (prioridade) { fluentwait .until(ExpectedConditions
		 * .elementToBeClickable(By.xpath(
		 * ".//*[@id='cmbPrioridade']/tbody/tr/td[1]/div/div[2]/span")))
		 * .click();
		 * 
		 * } else { fluentwait .until(ExpectedConditions
		 * .elementToBeClickable(By.xpath(
		 * ".//*[@id='cmbPrioridade']/tbody/tr/td[3]/div/div[2]/span")))
		 * .click();
		 * 
		 * }
		 * 
		 */

		if (isClickable(driver.findElement(By.xpath(".//*[@id='j_idt549']")))) {
			System.out.println("Salvar");
		} // fim
			// do
			// if.

	} // fim do metodo preenche.

	public boolean isClickable(WebElement el) {
		try {
			// espera que o elemento esja visivel e clickavel.
			fluentwait.until(ExpectedConditions.elementToBeClickable(el)).click();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
