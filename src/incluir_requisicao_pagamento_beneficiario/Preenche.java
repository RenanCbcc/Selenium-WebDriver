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
import ancillary.Helper;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

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

	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Data_Nascimento,
			Boolean Prioridade, String Exeq_Liquido, String INSS_Beneficiario, String INSS_Executado, String IR,
			String Observacao) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.SelectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

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
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).sendKeys(Observacao);

		if (Helper.isClickable(".//*[@id='j_idt549']")) {
			System.out.println("Salvar");
		} // fim
			// do
			// if.

	} // Fim do metodo preenche Beneficiário pessoa Fisica.

	public void preencher(String Tipo_Pessoa, String Documento_Fiscal, String Nome, String Exeq_Liquido,
			String INSS_Beneficiario, String INSS_Executado, String IR, String Observacao)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando Tipo Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		Helper.SelectFromDropdown(Tipo_Pessoa, ".//*[@id='cmbTpPessoa_panel']/div/ul/li");

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
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).clear();
		driver.findElement(By.xpath(".//*[@id='j_idt547']")).sendKeys(Observacao);

		if (Helper.isClickable(".//*[@id='j_idt549']")) {
			System.out.println("Salvar");
		} // fim do if.

	} // fim do metodo preenche Beneficiário pessoa Juridica

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

		// Bug_Mr_Anderson, why do you persist?
		{ // A funcao isClickable() retornarah sem True, por isso eh preciso
			// outro if() <==========================================
			driver.findElement(By.xpath(".//*[@id='inUfOAB']")).click();
			if (driver.findElement(By.xpath(".//*[@id='inUfOAB_panel']/div/ul/li")).isDisplayed()) {
				logger.info("Selecionando Unidade Federativa da OAB");
				Helper.SelectFromDropdown(UF_OAB, ".//*[@id='inUfOAB_panel']/div/ul/li");
				logger.info("Unidade Federativa Selecionada");
			} else {
				logger.info("Unidade Federativa Selecionada");
				System.out.println("Unidade Federativa Inativo");
			}
		} // Fim do Bug_Mr_Anderson.

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inNrOAB']")))
				.isEnabled()) {
			logger.info("Preenchendo Numero da OAB");
			driver.findElement(By.xpath(".//*[@id='inNrOAB']")).clear();
			driver.findElement(By.xpath(".//*[@id='inNrOAB']")).sendKeys(numero_OAB);
		} else {
			logger.info("Numero da OAB Inativo");
			System.out.println("Numero da OAB Inativo");
		}

		// Bug_Mr_Anderson, why do you persist?
		{ // A funcao isClickable() retornarah sem True, por isso eh preciso
			// outro if() <==========================================
			driver.findElement(By.xpath(".//*[@id='inTpOAB']")).click();
			if (driver.findElement(By.xpath(".//*[@id='inTpOAB_panel']/div/ul/li")).isDisplayed()) {
				logger.info("Selecionando Tipo de OAB");
				Helper.SelectFromDropdown(Tipo_OAB, ".//*[@id='inTpOAB_panel']/div/ul/li");
			} else {
				logger.info("Tipo de OAB inativa");
				System.out.println("Tipo de OAB Inativo");
			}

		} // Fim do Bug_Mr_Anderson.

		logger.info("Selecionando como Beneficiario o primeiro da lista"); // Clica
																			// sempre
																			// no
																			// primeiro.
		// isClickable(fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='inBenef']/tbody/tr[1]/td[1]/div/div[2]/span"))));

		if (Helper.isClickable(".//*[@id='j_idt490']")) {
			System.out.println("Salvar");
		} // fim do if.

	}

	public void preencher(String Tipo_Pessoa, String Documento_Fiscal)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Selecinando Tipo de Pessoa");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa']"))).click();
		fluentwait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='cmbTpPessoa_panel']/div/ul/li[3]")))
				.click();

		logger.info("Preenchendo numero do documento");
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inCnpjBenef']"))).clear();
		driver.findElement(By.xpath(".//*[@id='inCnpjBenef']")).sendKeys(Documento_Fiscal);

		logger.info("Buscando nome do Beneficiario/Advogado");
		driver.findElement(By.xpath(".//*[@id='j_idt507']")).click();

	}// Fim do metodo preenche para Excecoes.

}
