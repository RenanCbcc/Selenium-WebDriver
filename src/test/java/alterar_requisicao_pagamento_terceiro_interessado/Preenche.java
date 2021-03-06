package alterar_requisicao_pagamento_terceiro_interessado;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import gep_pagamento_auxiliary.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

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

	/**
	 * Method used to alter a "Third party"
	 * 
	 * @param valorILiquido
	 * @param valor_IR
	 * @param Observacao
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Alterar Terceiro Interessado");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[2]"))).click();

		logger.info("Preenchendo Valor Lquido*");
		fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")).sendKeys(valorILiquido);

		logger.info("Preenchendo Valor IR*");
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).sendKeys(valor_IR);

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By
				.xpath("//form[6]/div/div[2]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.clear();
		driver.findElement(By
				.xpath("//form[6]/div/div[2]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.sendKeys(Observacao);

		driver.findElement(By.xpath("//table[@id='pnlSalvarTerceiro']/tbody/tr/td/button"))
				.click();
		logger.info("Salvando");

	}

	/**
	 * DEPREACATED
	 * 
	 * @param Tipo_honorario
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param valorILiquido
	 * @param valor_IR
	 * @param Observacao
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String Tipo_honorario, String Tipo_Pessoa, String Documento_Fiscal, String Nome,
			String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Novo Terceiro Interessado");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt269']"))).click();

		logger.info("Preenchendo Tipo Honorario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();

		Helper.selectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		// Perguntar se � Pessoa F�sica ou Juridica
		if (Tipo_honorario.equals("Honorários Periciais") || Tipo_honorario.equals("Outros")) {
			logger.info("Preenchendo Tipo Pessoa");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoaTerceiro']")))
					.click();
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoaTerceiro_panel']/div/ul/li");
		}

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando Documento Fiscal do Terceiro Interessado");
		driver.findElement(By.xpath(".//*[@id='j_idt570']")).click();

		logger.info("Preenchendo nome do Terceiro Interessado");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmTerceiro']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).sendKeys(Nome);
		}

		logger.info("Preenchendo Valor Liquido*");
		fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")).sendKeys(valorILiquido);

		logger.info("Preenchendo Valor IR*");
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).sendKeys(valor_IR);

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By.xpath(".//*[@id='j_idt602']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt602']")).sendKeys(Observacao);

		driver.findElement(By.xpath(".//*[@id='j_idt604']")).click();
		System.out.println("Salvar");

	} // Fim do metodo Preenche para Honor�rios Periciais e Outros.

}
