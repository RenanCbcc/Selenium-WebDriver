package incluir_requisicao_pagamento_terceiro_interessado;

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
	 * Overloaded method fill in used to include a 'Terceiro Interessado' in a
	 * already added process, finalized or not, as 'Honorarios Advocaticios'.
	 * 
	 * @param Tipo_honorario
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param UF_OAB
	 * @param Numero_OAB
	 * @param Tipo_OAB
	 * @param valorILiquido
	 * @param valor_IR
	 * @param Observacao
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String Tipo_honorario, String Documento_Fiscal, String Nome, String UF_OAB, String Numero_OAB,
			String Tipo_OAB, String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Novo Terceiro Interessado".toUpperCase());
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[3]/fieldset[2]/div/table/tbody/tr/td/button")))
				.click();

		logger.info("Preenchendo Tipo Honorario".toUpperCase());
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();
		Helper.selectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento".toUpperCase());
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando Documento Fiscal do Terceiro Interessado".toUpperCase());
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr/td/fieldset/div/table/tbody/tr[2]/td[2]/button"))
				.click();

		logger.info("Preenchendo nome do Terceiro Interessado");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmTerceiro']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).sendKeys(Nome);
		}

		if (Helper.isClickable(".//*[@id='inUfOABTerceiro']".toUpperCase())) {

			logger.info("Selecionando Unidade Federativa da OAB");
			Helper.selectFromDropdown(UF_OAB, ".//*[@id='inUfOABTerceiro_panel']/div/ul/li");
		} else {
			logger.info("Unidade Federativa da OAB INATIVA".toUpperCase());
			System.out.println("Unidade Federativa da OAB INATIVA");
		}

		logger.info("Preenchendo numero da OAB".toUpperCase());
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNrOABTerceiro']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNrOABTerceiro']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNrOABTerceiro']")).sendKeys(Numero_OAB);
		}

		if (Helper.isClickable(".//*[@id='inTpOABTerceiro']")) {
			logger.info("Selecionando Tipo da OAB");
			Helper.selectFromDropdown(Tipo_OAB, ".//*[@id='inTpOABTerceiro_panel']/div/ul/li");
		} else {
			logger.info("Tipo da OAB INATIVA");
		}

		logger.info("Preenchendo Valor Líquido*".toUpperCase());
		fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")).sendKeys(valorILiquido);

		logger.info("Preenchendo Valor IR*".toUpperCase());
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).sendKeys(valor_IR);

		logger.info("Preenchendo Observacoes*".toUpperCase());
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.clear();
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.sendKeys(Observacao);

		Helper.dragAndDrop(".//*[@id='dlgCadastroTerceiro']/div[1]", "html/body/div[3]/div/div[1]");

		System.out.println("Salvar");
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[2]/tbody/tr/td[1]/button")))
				.click();

	}

	/**
	 * Overloaded method fill in used to include a 'Third Party' in a already
	 * added process, finalized or not, as 'Periciais' and other.
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
	 * @throws InterruptedException
	 */
	public void preencher(String Tipo_honorario, String Tipo_Pessoa, String Documento_Fiscal, String Nome,
			String valorILiquido, String valor_IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Novo Terceiro Interessado".toUpperCase());
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[3]/fieldset[2]/div/table/tbody/tr/td/button")))
				.click();
		logger.info("Preenchendo Tipo Honorario".toUpperCase());
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();
		Helper.selectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		if (Tipo_honorario.equals("Honorários Periciais") || Tipo_honorario.equals("Outros")) {
			logger.info("Preenchendo Tipo Pessoa");
			System.out.println("Preenchendo Tipo Pessoa- DropDown".toUpperCase());
			Helper.isClickable(".//*[@id='cmbTpPessoaTerceiro']");
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoaTerceiro_panel']/div/ul/li");
			if (Tipo_Pessoa.length() < 15) {
				logger.info("Preenchendo CPF do Terceiro Interessado".toUpperCase());
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']")))
						.clear();
				driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

			} else {

				logger.info("Preenchendo CNPJ do Terceiro Interessado".toUpperCase());
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCnpjTerceiro']")))
						.clear();
				driver.findElement(By.xpath(".//*[@id='inCnpjTerceiro']")).sendKeys(Documento_Fiscal);

			}
		} else {

			logger.info("Preenchendo CPF do Terceiro Interessado".toUpperCase());
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']"))).clear();
			driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

		}

		logger.info("Buscando Documento Fiscal do Terceiro Interessado".toUpperCase());
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr[1]/td/fieldset/div/table/tbody/tr[2]/td[4]/button"))
				.click();

		logger.info("Preenchendo nome do Terceiro Interessado".toUpperCase());
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmTerceiro']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmTerceiro']")).sendKeys(Nome);
		}

		logger.info("Preenchendo Valor Líquido*".toUpperCase());
		fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquidoTerceiro_input']")).sendKeys(valorILiquido);

		logger.info("Preenchendo Valor IR*".toUpperCase());
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIrTerceiro_input']")).sendKeys(valor_IR);

		logger.info("Preenchendo Observacoes*".toUpperCase());
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.clear();
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.sendKeys(Observacao);

		Helper.dragAndDrop(".//*[@id='dlgCadastroTerceiro']/div[1]", "html/body/div[3]/div/div[1]");

		System.out.println("Salvar");
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[2]/tbody/tr/td[1]/button")))
				.click();

	}

	/**
	 * Overloaded method fill in used throw exceptions.
	 * 
	 * @param Tipo_honorario
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String Tipo_honorario, String Tipo_Pessoa, String Documento_Fiscal)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Novo Terceiro Interessado");
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[3]/fieldset[2]/div/table/tbody/tr/td/button")))
				.click();

		logger.info("Preenchendo Tipo Honorario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpTerceiro']"))).click();
		Helper.selectFromDropdown(Tipo_honorario, ".//*[@id='cmbTpTerceiro_panel']/div/ul/li");

		if (Tipo_honorario.equals("Honorários Periciais") || Tipo_honorario.equals("Outros")) {
			logger.info("Preenchendo Tipo Pessoa");
			System.out.println("Preenchendo Tipo Pessoa- DropDown");
			Helper.isClickable(".//*[@id='cmbTpPessoaTerceiro']");
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoaTerceiro_panel']/div/ul/li");
			if (Tipo_Pessoa.length() < 15) {
				logger.info("Preenchendo CPF do Terceiro Interessado");
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']")))
						.clear();
				driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

			} else {

				logger.info("Preenchendo CNPJ do Terceiro Interessado");
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCnpjTerceiro']")))
						.clear();
				driver.findElement(By.xpath(".//*[@id='inCnpjTerceiro']")).sendKeys(Documento_Fiscal);

			}
		} else {

			logger.info("Preenchendo CPF do Terceiro Interessado");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfTerceiro']"))).clear();
			driver.findElement(By.xpath(".//*[@id='inCpfTerceiro']")).sendKeys(Documento_Fiscal);

		}

		logger.info("Buscando Documento Fiscal do Terceiro Interessado");
		try {
			driver.findElement(By
					.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr/td/fieldset/div/table/tbody/tr[2]/td[4]/button"))
					.click();
		} catch (Exception e) {
			driver.findElement(By
					.xpath("/html/body/div[4]/div/div/form[6]/div/div[2]/table[1]/tbody/tr/td/fieldset/div/table/tbody/tr[2]/td[2]/button"))
					.click();
		}

	}

}
