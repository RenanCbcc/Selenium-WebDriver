package incluir_requisicao_pagamento_beneficiario;

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
import gep_pagamento_auxiliary.Helper;

// Esta clase faz o preenchimento do formulario de buscas e os submete.
public class Preenche {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Preenche.class.getCanonicalName());

	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Overloaded method used to include a 'Beneficiary' in a already added
	 * process without priority.
	 * 
	 * @param Tipo_Pessoa
	 * @param Documento_Fiscal
	 * @param Nome
	 * @param Data_Nascimento
	 * @param Prioridade
	 * @param Exeq_Liquido
	 * @param INSS_Beneficiario
	 * @param INSS_Executado
	 * @param IR
	 * @param Observacao
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Data_Nascimento,
			Boolean Prioridade, String Exeq_Liquido, String INSS_Beneficiario, String INSS_Executado, String IR,
			String Observacao) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath(".//*[@id='j_idt505']")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(Nome);
		}

		logger.info("Preenchendo data de nascimento do Benficiario");
		if (driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).clear();
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).sendKeys(Data_Nascimento);
		}

		logger.info("Foi deferido o benefício de prioridade processual?*");
		if (Prioridade) {
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

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By.xpath(".//*[@id='j_idt545']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt545']")).sendKeys(Observacao);

		Helper.dragAndDrop(".//*[@id='dlgCadastroBeneficio']/div[1]", "html/body/div[3]/div/div[1]");

		System.out.println("Salvar");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='j_idt547']"))).click();

	} // Fim do metodo preenche Beneficiário pessoa Fisica sem prioridade.

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

	/**
	 * Overloaded method used to include a 'Beneficiary' in a already added
	 * process with priority.
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
	 */
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Data_Nascimento,
			Boolean Prioridade, String Tipo_Prioridade, String Exeq_Liquido, String INSS_Beneficiario,
			String INSS_Executado, String IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath(".//*[@id='j_idt507']")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(Nome);
		}

		logger.info("Preenchendo data de nascimento do Benficiario");
		if (driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).clear();
			driver.findElement(By.xpath(".//*[@id='inDdtNasc_input']")).sendKeys(Data_Nascimento);
		}

		logger.info("Foi deferido o benefício de prioridade processual?*");
		if (Prioridade) {
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

		logger.info("Tipo de Prioridade");
		if (Tipo_Prioridade.equals("Doença Grave")) {
			fluentwait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(".//*[@id='cmbTpPrioridade']/tbody/tr/td[1]/div/div[2]/span")))
					.click();

		} else {
			fluentwait.until(ExpectedConditions
					.elementToBeClickable(By.xpath(".//*[@id='cmbTpPrioridade']/tbody/tr/td[3]/div/div[2]/span")))
					.click();

		}

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

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By.xpath(".//*[@id='j_idt545']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt545']")).sendKeys(Observacao);

		System.out.println("Salvar");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='j_idt547']"))).click();

	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
	/**
	 * Overloaded method used to include a 'Beneficiary NCPJ' in a already
	 * added process.
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
	 */
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Exeq_Liquido,
			String INSS_Beneficiario, String INSS_Executado, String IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inCnpjBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Beneficiario");
		driver.findElement(By.xpath(".//*[@id='j_idt507']")).click();

		logger.info("Preenchendo nome do Benficiario");
		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmBenef']")))
				.isEnabled()) {
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmBenef']")).sendKeys(Nome);
		}

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

		logger.info("Preenchendo Observacoes*");
		driver.findElement(By.xpath(".//*[@id='j_idt545']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt545']")).sendKeys(Observacao);

		if (Helper.isClickable(".//*[@id='j_idt549']")) {
			System.out.println("Salvar");
		} // fim do if.

	} // fim do metodo preenche Beneficiário pessoa Juridica
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

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inCpfAdv']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCpfAdv']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Advogado");
		driver.findElement(By.xpath(".//*[@id='j_idt461']")).click();

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNmAdv']")))
				.isEnabled()) {
			logger.info("Preenchendo nome do Advogado");
			driver.findElement(By.xpath(".//*[@id='inNmAdv']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNmAdv']")).sendKeys(Nome);
		} else {
			logger.info("Nome Inativo");
			System.out.println("Nome Inativo");
		}

		if (Helper.isClickable(".//*[@id='inUfOAB']")) {
			logger.info("Selecionando Unidade Federativa da OAB");
			Helper.selectFromDropdown(UF_OAB, ".//*[@id='inUfOAB_panel']/div/ul/li");
			{
				logger.info("Unidade Federativa Selecionada");
				System.out.println("Unidade Federativa Selecionada");
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
			System.out.println("Numero da OAB Inativo");
		}

		if (Helper.isClickable(".//*[@id='inTpOAB']")) {
			logger.info("Selecionando Tipo de OAB");
			Helper.selectFromDropdown(Tipo_OAB, ".//*[@id='inTpOAB_panel']/div/ul/li");
			{
				logger.info("Tipo de OAB Selecionada");
				System.out.println("Tipo de OAB Selecionada");
			}
		} else {
			logger.info("Tipo de OAB inativa");
			System.out.println("Tipo de OAB Inativo");
		}

		logger.info("Selecionando como Beneficiario o primeiro da lista");
		// TODO The using of 'Thread must be reviewed!
		Thread.sleep(3000);

		Helper.attemptingToClick(".//*[@id='inBenef']/tbody/tr[1]/td[1]/div/div[2]/span");

		if (Helper.isClickable(".//*[@id='j_idt488']")) {
			System.out.println("Salvar");
		} // end if.

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
	 */
	public void preencher(String Tipo_Pessoa, String Documento_Fiscal)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		if (Tipo_Pessoa.equals("Pessoa Física")) {
			System.out.println("Preenchendo Tipo Pessoa- DropDown");
			Helper.isClickable(".//*[@id='cmbTpPessoa']");
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfBenef']"))).clear();
			driver.findElement(By.xpath(".//*[@id='inCpfBenef']")).sendKeys(Documento_Fiscal);

		} else {
			System.out.println("Preenchendo CNPJ do Beneficiario");
			logger.info("Preenchendo CNPJ do Beneficiario");
			Helper.isClickable(".//*[@id='cmbTpPessoa']");
			Helper.selectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCnpjBenef']"))).clear();
			driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Documento_Fiscal);

		}

		driver.findElement(By.xpath(".//*[@id='j_idt505']")).click();

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
		public void preencher(String Documento_Fiscal)
				throws NoSuchElementException, TimeoutException, WebDriverException {

		
				fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCpfAdv']"))).clear();
				driver.findElement(By.xpath(".//*[@id='inCpfAdv']")).sendKeys(Documento_Fiscal);

					driver.findElement(By.xpath(".//*[@id='j_idt461']")).click();

		}
}
