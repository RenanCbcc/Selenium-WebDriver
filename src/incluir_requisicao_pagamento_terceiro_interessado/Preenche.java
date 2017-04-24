package incluir_requisicao_pagamento_terceiro_interessado;
import ancillary.Helper;
import org.openqa.selenium.WebDriver;
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

	public void preencher(String Tipo_honorario, String Documento_Fiscal, String Nome, String UF_OAB, String Numero_OAB,
			String Tipo_OAB, String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Novo Terceiro Interessado");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt269']"))).click();

		logger.info("Preenchendo Tipo Honorario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();
		Helper.SelectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando Cpf do Terceiro Interessado");
		driver.findElement(By.xpath(".//*[@id='j_idt570']")).click();

		logger.info("Preenchendo nome do Terceiro Interessado");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmTerceiro']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).sendKeys(Nome);
		}

		if (Helper.isClickable(".//*[@id='inUfOABTerceiro']")) {
			logger.info("Selecionando Unidade Federativa da OAB");
			Helper.SelectFromDropdown(UF_OAB, ".//*[@id='inUfOABTerceiro_panel']/div/ul/li");
		}

		logger.info("Preenchendo numero da OAB");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNrOABTerceiro']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNrOABTerceiro']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNrOABTerceiro']")).sendKeys(Numero_OAB);
		}

		if (Helper.isClickable(".//*[@id='inTpOABTerceiro']")) {
			logger.info("Selecionando Tipo da OAB");
			Helper.SelectFromDropdown(Tipo_OAB, ".//*[@id='inTpOABTerceiro_panel']/div/ul/li");
		}

		logger.info("Preenchendo Valor Líquido*");
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

		if (Helper.isClickable(".//*[@id='j_idt604']")) {
			System.out.println("Salvar");
		}

	} // fim do metodo preenche Terceiro Interessado - Honorarios Advocaticios

	public void preencher(String Tipo_honorario, String Tipo_Pessoa, String Documento_Fiscal, String Nome,
			String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Novo Terceiro Interessado");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt269']"))).click();

		logger.info("Preenchendo Tipo Honorario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();

		Helper.SelectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		// Perguntar se é Pessoa Física ou Juridica
		if (Tipo_honorario.equals("Honorários Periciais") || Tipo_honorario.equals("Outros")) {
			logger.info("Preenchendo Tipo Pessoa");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoaTerceiro']")))
					.click();
			Helper.SelectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoaTerceiro_panel']/div/ul/li");
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

		logger.info("Preenchendo Valor Líquido*");
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

		if (Helper.isClickable(".//*[@id='j_idt604']")) {
			System.out.println("Salvar");
		}

	} // Fim do metodo Preenche para Honorários Periciais e Outros.

	public void preencher(String Tipo_honorario, String Tipo_Pessoa, String Documento_Fiscal)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Novo Terceiro Interessado");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt269']"))).click();

		logger.info("Preenchendo Tipo Honorario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();
		Helper.SelectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		// Perguntar se é Pessoa Física ou Juridica
		if (Tipo_honorario.equals("Honorários Periciais") || Tipo_honorario.equals("Outros")) {
			logger.info("Preenchendo Tipo Pessoa");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoaTerceiro']")))
					.click();
			Helper.SelectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoaTerceiro_panel']/div/ul/li");
			if (Tipo_Pessoa.length() < 15) {
				logger.info("Preenchendo CPF do Terceiro Interessado");
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']")))
						.clear();
				driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

			} else {
				logger.info("Preenchendo CNPJ do Terceiro Interessado");
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']")))
						.clear();
				driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

			}
		}

		logger.info("Buscando Documento Fiscal do Terceiro Interessado");
		driver.findElement(By.xpath(".//*[@id='j_idt570']")).click();

	} // Fim do metodo Preenche para Excecoes

	

}
