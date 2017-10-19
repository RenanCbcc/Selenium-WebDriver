package alterar_requisicao_pagamento_beneficiario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentTest;

import gep_pagamento_auxiliary.Helper;

public class Preenche {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private ExtentTest logger = Teste_Altera_Beneficiario.getLogger();

	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	/**
	 * Method used to fill in all the fields of section 'Beneficiary', any
	 * exception are expected.
	 * 
	 * @param Prioridade
	 * @param Exeq_Liquido
	 * @param INSS_Beneficiario
	 * @param INSS_Executado
	 * @param IR
	 * @param Observacao
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */

	public void preencher(String Prioridade, String Tipo_Prioridade, String Exeq_Liquido, String INSS_Beneficiario,
			String INSS_Executado, String IR, String FGTS, String Custas_Judiciais, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Foi deferido o benefício de prioridade processual?*");

		if (Prioridade.equals("Sim")) {
			fluentwait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(".//*[@id='cmbPrioridade']/tbody/tr/td[1]/div/div[2]/span")))
					.click();
			logger.info("Tipo de Prioridade");
			if (Tipo_Prioridade.equals("Doença Grave")) {
				fluentwait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(".//*[@id='cmbTpPrioridade']/tbody/tr/td[1]/div/div[2]/span")))
						.click();

			} else if (Tipo_Prioridade.equals("Idade")) {
				fluentwait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(".//*[@id='cmbTpPrioridade']/tbody/tr/td[3]/div/div[2]/span")))
						.click();

			}

		} else if (Prioridade.equals("Não")) {
			fluentwait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(".//*[@id='cmbPrioridade']/tbody/tr/td[2]/div/div[2]/span")))
					.click();

		}

		Thread.sleep(1000);
		logger.info("Preenchendo Exeq. Líquido*");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inVlLiquido_input']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='inVlLiquido_input']")).sendKeys(Exeq_Liquido);

		logger.info("Preenchendo INSS Beneficiario*");
		driver.findElement(By.xpath(".//*[@id='inVlInssBenef_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlInssBenef_input']")).sendKeys(INSS_Beneficiario);

		logger.info("Preenchendo INSS Executado*");
		driver.findElement(By.xpath(".//*[@id='inVlInssExec_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlInssExec_input']")).sendKeys(INSS_Executado);

		logger.info("Preenchendo IR*");
		driver.findElement(By.xpath(".//*[@id='inVlIr_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlIr_input']")).sendKeys(IR);

		logger.info("Preenchendo FGTS*");
		driver.findElement(By.xpath(".//*[@id='inVlFgts_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlFgts_input']")).sendKeys(FGTS);

		logger.info("Preenchendo Custas Judiciais*");
		driver.findElement(By.xpath(".//*[@id='inVlCustas_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlCustas_input']")).sendKeys(Custas_Judiciais);

		logger.info("Preenchendo Observacoes*");
		driver.findElement(
				By.xpath("//form[5]/div/div[2]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea")).clear();
		driver.findElement(
				By.xpath("//form[5]/div/div[2]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.sendKeys(Observacao);

		logger.info("Salvando");
		driver.findElement(By.xpath("//table[@id='pnlSalvar']/tbody/tr/td/button")).click();

	}

	/**
	 * @deprecated
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param UF_OAB
	 * @param numero_OAB
	 * @param Tipo_OAB
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String Documento_Fiscal, String Nome, String UF_OAB, String numero_OAB, String Tipo_OAB)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inCpfAdv']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfAdv']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Advogado");
		driver.findElement(By.xpath(".//*[@id='j_idt463']")).click();

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmAdv']")))
				.isEnabled()) {
			logger.info("Preenchendo nome do Advogado");
			driver.findElement(By.xpath(".//*[@id='j_idt463']")).clear();
			driver.findElement(By.xpath(".//*[@id='j_idt463']")).sendKeys(Nome);
		} else {
			logger.info("Nome Inativo");
			System.out.println("Nome Inativo");
		}

		driver.findElement(By.xpath(".//*[@id='inUfOAB']")).click();
		if (driver.findElement(By.xpath(".//*[@id='inUfOAB_panel']/div/ul/li")).isDisplayed()) {
			logger.info("Selecionando Unidade Federativa da OAB");
			Helper.selectFromDropdown(UF_OAB, ".//*[@id='inUfOAB_panel']/div/ul/li");
			logger.info("Unidade Federativa Selecionada");
		} else {
			logger.info("Unidade Federativa Selecionada");
			System.out.println("Unidade Federativa Inativo");
		}

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNrOAB']")))
				.isEnabled()) {
			logger.info("Preenchendo Numero da OAB");
			driver.findElement(By.xpath(".//*[@id='inNrOAB']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNrOAB']")).sendKeys(numero_OAB);
		} else {
			logger.info("Numero da OAB Inativo");
			System.out.println("Numero da OAB Inativo");
		}

		driver.findElement(By.xpath(".//*[@id='inTpOAB']")).click();
		if (driver.findElement(By.xpath(".//*[@id='inTpOAB_panel']/div/ul/li")).isDisplayed()) {
			logger.info("Selecionando Tipo de OAB");
			Helper.selectFromDropdown(Tipo_OAB, ".//*[@id='inTpOAB_panel']/div/ul/li");
		} else {
			logger.info("Tipo de OAB inativa");
			System.out.println("Tipo de OAB Inativo");
		}

		logger.info("Selecionando como Beneficiario o primeiro da lista");
		fluentwait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='inBenef']/tbody/tr[1]/td[1]/div/div[2]/span")));

		driver.findElement(By.xpath(".//*[@id='j_idt549']")).click();
		System.out.println("Salvar");

	}

	public void preencher(String Documento_Fiscal) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCnpjBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Beneficiario/Advogado");
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[4]/div/div[2]/table[1]/tbody/tr[1]/td/fieldset/div/table/tbody/tr[1]/td[3]/button"))
				.click();

	}

}
