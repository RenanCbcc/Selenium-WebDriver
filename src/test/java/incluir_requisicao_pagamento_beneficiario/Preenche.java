package incluir_requisicao_pagamento_beneficiario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aventstack.extentreports.ExtentTest;

import gep_pagamento_auxiliary.Helper;

public class Preenche {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private ExtentTest logger = Teste_Inclui_Beneficiario.getLogger();

	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	/**
	 * Overloaded method used to include a 'Beneficiary' in a already added
	 * process.
	 * 
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param Data_Nascimento
	 * @param Prioridade
	 * @param Tipo_Prioridade
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
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Data_Nascimento,
			String Prioridade, String Tipo_Prioridade, String Exeq_Liquido, String INSS_Beneficiario,
			String INSS_Executado, String IR, String FGTS, String Custas_Judiciais, String Comentarios)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException,
			MoveTargetOutOfBoundsException {

		logger.info("Selecionando novo Beneficiario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//fieldset[@id='tabGeral:pnlBeneficios']/div/table/tbody/tr/td/button"))).click();

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inCpfBenef']")));
		driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Documento_Fiscal);
		driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Keys.ENTER);

		fluentwait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath(".//*[@id='j_idt73:dialogStatus']"),
				"Aguardando..."));

		fluentwait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath(".//*[@id='inCpfBenef']")),
				"value", Documento_Fiscal));

		// TODO The search button is not working in the second time. Idk why.
		// driver.findElement(By.xpath("//td[5]/button")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {

			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(Nome);
		}

		logger.info("Preenchendo data de nascimento do Benficiario");
		if (driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).sendKeys(Data_Nascimento);
			// click out of the button in order to close it.
			driver.findElement(By.xpath(".//*[@id='dlgCadastroBeneficio_title']")).click();
		}

		logger.info("Foi deferido o benef�cio de prioridade processual?*");
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

			} else {
				fluentwait.until(ExpectedConditions
						.elementToBeClickable(By.xpath(".//*[@id='cmbTpPrioridade']/tbody/tr/td[2]/div/div[2]/span")))
						.click();

			}

		}else if (Prioridade.equals("Não")) {
			fluentwait
					.until(ExpectedConditions
							.elementToBeClickable(By.xpath(".//*[@id='cmbPrioridade']/tbody/tr/td[2]/div/div[2]/span")))
					.click();

		}

		Thread.sleep(1000);

		driver.findElement(By.xpath(".//*[@id='inVlLiquido_input']")).clear();
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

		logger.info("Preenchendo Custas Judiciais*".toUpperCase());
		driver.findElement(By.xpath(".//*[@id='inVlCustas_input']")).clear();
		driver.findElement(By.xpath(".//*[@id='inVlCustas_input']")).sendKeys(Custas_Judiciais);

		logger.info("Preenchendo Observacoes*");
		driver.findElement(
				By.xpath("//form[5]/div/div[2]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea")).clear();

		// Drag a window to make the button visible
		Helper.dragAndDrop(".//*[@id='dlgCadastroBeneficio']/div[1]", "//div[2]/fieldset/legend");
		driver.findElement(
				By.xpath("//form[5]/div/div[2]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
				.sendKeys(Comentarios);

		logger.info("Salvar");
		fluentwait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='pnlSalvar']/tbody/tr/td[1]/button")))
				.click();

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	/**
	 * Overloaded method used to include a 'Beneficiary NCPJ' in a already added
	 * process.
	 * 
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
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
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Exeq_Liquido,
			String INSS_Beneficiario, String INSS_Executado, String IR, String FGTS, String Custas_Judiciais,
			String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Selecionando novo Beneficiario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//fieldset[@id='tabGeral:pnlBeneficios']/div/table/tbody/tr/td/button"))).click();

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inCnpjBenef']")));
		driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath("//td[5]/button")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(Nome);
		}

		logger.info("Preenchendo Exeq. Liquido*");
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

		// Drag a window to make the button visible
		Helper.dragAndDrop(".//*[@id='dlgCadastroBeneficio']/div[1]", "//div[2]/fieldset/legend");

		logger.info("Salvar");
		fluentwait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='pnlSalvar']/tbody/tr/td[1]/button")))
				.click();

	} // fim do metodo preenche Benefici�rio pessoa Juridica
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Overloaded method used to include a 'Lawyer' in a already existing
	 * process.
	 * 
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param UF_OAB
	 * @param numero_OAB
	 * @param Tipo_OAB
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String Documento_Fiscal, String Nome, String UF_OAB, String numero_OAB, String Tipo_OAB)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Selecionando novo Advogado");
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//fieldset[3]/div/table/tbody/tr/td/button")))
				.click();

		logger.info("Preenchendo numero do documento");
		driver.findElement(By.xpath(".//*[@id='inCpfAdv']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Advogado");
		driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/fieldset/div/table/tbody/tr/td[3]/button")).click();

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmAdv']")))
				.isEnabled()) {
			logger.info("Preenchendo nome do Advogado");
			driver.findElement(By.xpath(".//*[@id='inNmAdv']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmAdv']")).sendKeys(Nome);
		} else {
			logger.info("Nome Inativo");
			logger.info("Nome Inativo");
		}

		if (Helper.isClickable(".//*[@id='inUfOAB']")) {
			logger.info("Selecionando Unidade Federativa da OAB");
			Helper.selectFromDropdown(UF_OAB, ".//*[@id='inUfOAB_panel']/div/ul/li");
			{
				logger.info("Unidade Federativa Selecionada");
			}
		} else {
			logger.info("Unidade Federativa Inativa");
			System.out.println("Unidade Federativa INATIVA");
		}

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNrOAB']")))
				.isEnabled()) {
			logger.info("Preenchendo Numero da OAB");
			driver.findElement(By.xpath(".//*[@id='inNrOAB']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNrOAB']")).sendKeys(numero_OAB);
		} else {
			logger.info("Numero da OAB Inativo");

		}

		if (Helper.isClickable(".//*[@id='inTpOAB']")) {
			logger.info("Selecionando Tipo de OAB");
			Helper.selectFromDropdown(Tipo_OAB, ".//*[@id='inTpOAB_panel']/div/ul/li");
			{
				logger.info("Tipo de OAB Selecionada");

			}
		} else {
			logger.info("Tipo de OAB inativa");

		}

		logger.info("Selecionando como Beneficiario o primeiro da lista");

		Helper.attemptingToClick(".//*[@id='inBenef']/tbody/tr[1]/td[1]/div/div[2]/span");

		if (Helper.isClickable("//table[@id='pnlSalvarAdv']/tbody/tr/td[1]/button")) {
			logger.info("Salvando");

		}

	}
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Method used to throw Beneficiary's exceptions.
	 * 
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("Selecionando novo Beneficiario");
		fluentwait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//fieldset[@id='tabGeral:pnlBeneficios']/div/table/tbody/tr/td/button"))).click();

		if (Tipo_Pessoa.equals("Pessoa Física")) {
			System.out.println("Preenchendo Tipo Pessoa- DropDown");
			Helper.isClickable(".//*[@id='cmbTpPessoa']");
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfBenef']")));
			driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Documento_Fiscal);
			driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Keys.ENTER);

		} else {
			System.out.println("Preenchendo CNPJ do Beneficiario");
			logger.info("Preenchendo CNPJ do Beneficiario");
			Helper.isClickable(".//*[@id='cmbTpPessoa']");
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCnpjBenef']")));
			driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Documento_Fiscal);
			driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Keys.ENTER);

		}

		

	}
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Method used to throw Lawyer's exceptions.
	 * 
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String Documento_Fiscal) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecionando novo Advogado");
		fluentwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//fieldset[@id='tabGeral:pnlAdvogados']/div/table/tbody/tr/td/button")))
				.click();

		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfAdv']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfAdv']")).sendKeys(Documento_Fiscal);

		driver.findElement(By.xpath("//div[2]/table/tbody/tr/td/fieldset/div/table/tbody/tr/td[3]/button")).click();

	}
}
