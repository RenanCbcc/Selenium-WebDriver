package incluir_requisicao_pagamento;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

import gep_pagamento_auxiliary.Helper;

// Esta clase faz o preenchimento do formulario de buscas e os submete.

public class Preenche {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Preenche.class.getCanonicalName());

	public Preenche(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	/**
	 * Method fill in used to test the standard test case.
	 * 
	 * @param Nº_RP
	 * @param Nº_Processo
	 * @param Tipo_Requisicao
	 * @param Natureza_Credito
	 * @param Vara_Origem
	 * @param Observaco
	 * @param data_ordem0
	 * @param data_ordem1
	 * @param data_ordem2
	 * @param data_ordem3
	 * @param data_ordem4
	 * @param data_ordem5
	 * @param CNPJ
	 * @param Nome_Exe
	 * @param Esfera
	 * @param Tipo_Administracao
	 * @param Nome_Dev
	 * @param Lei_Amparo
	 * @param CPF
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencher(String Nº_RP, String Nº_Processo, String Tipo_Requisicao, String Natureza_Credito,
			String Vara_Origem, String Observaco, String data_ordem0, String data_ordem1, String data_ordem2,
			String data_ordem3, String data_ordem4, String data_ordem5, String CNPJ, String Nome_Exe, String Esfera,
			String Tipo_Administracao, String Nome_Dev, String Lei_Amparo, String CPF)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		logger.info("PREENCHENDO NUMERO DE REQUISICAO DE PAGAMENTO");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(Nº_RP);
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr/td/fieldset/div/table/tbody/tr/td[3]/button"))
				.click();

		logger.info("PREENCHENDO NUMERO PROCESSO");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrProc']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrProc']")).sendKeys(Nº_Processo);
		driver.findElement(By
				.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr/td/fieldset/div/table/tbody/tr[2]/td[3]/button"))
				.click();

		logger.info("Preenchendo Tipo de Requisicao".toUpperCase());

		if (Tipo_Requisicao.equals("Precatório")) {
			logger.info("TIPO DE REQUISICAO RPV");
			Helper.attemptingToClick(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[1]/div/div[2]/span");

		} else {

			logger.info("TIPO DE REQUISICAO PRECATORIO");
			Helper.attemptingToClick(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[2]/div/div[2]/span");

		}

		logger.info("PREENCHENDO NATUREZA DO CREDITO");
		if (Natureza_Credito.equals("Alimentar")) {

			Helper.attemptingToClick(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[1]/div/div[2]/span");
			logger.info("NATUREZA DO CREDITO ALIMENTAR");

		} else {

			logger.info("NATUREZA DO CREDITO COMUM");
			Helper.attemptingToClick(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[2]/div/div[2]/span");

		}

		if (Helper.isClickable(".//*[@id='tabGeral:cmbVara']")) {
			logger.info("PREENCHENDO VARA DE ORIGEM");
			Helper.selectFromDropdown(Vara_Origem, ".//*[@id='tabGeral:cmbVara_panel']/div[2]/ul/li");
			{
				logger.info("VARA DE ORIGEM SELECONADA");
			}
		} else {
			logger.info("VARA DE ORIGEM INATIVA");
		}

		logger.info("PREENCHENDO OU NAO COMENTARIOS");
		WebElement campo_bservacao = driver.findElement(By.id("tabGeral:inObs"));
		if (campo_bservacao.isEnabled()) {
			campo_bservacao.clear();
			campo_bservacao.sendKeys(Observaco);
		}

		logger.info("Preenchendo ou nao Data do ajuizamento do processo de conhecimento".toUpperCase());
		WebElement campo_data_ordem0 = driver.findElement(By.id("tabGeral:inDdtAjuiz_input"));
		if (campo_data_ordem0.isEnabled()) {
			campo_data_ordem0.clear();
			campo_data_ordem0.sendKeys(data_ordem0);
		}

		logger.info("Preenchendo ou nao Data do trânsito em julgado do processo de conhecimento".toUpperCase());
		WebElement campo_data_ordem1 = driver.findElement(By.id("tabGeral:inDdtTrProc_input"));
		if (campo_data_ordem1.isEnabled()) {
			campo_data_ordem1.clear();
			campo_data_ordem1.sendKeys(data_ordem1);
		}

		logger.info(
				"Preenchendo ou nao Data do transito em julgado dos embargos a execucaoo e/ou impugnação dos calculos"
						.toUpperCase());
		WebElement campo_data_ordem2 = driver.findElement(By.id("tabGeral:inDdtTrEmb_input"));
		if (campo_data_ordem2.isEnabled()) {
			campo_data_ordem2.clear();
			campo_data_ordem2.sendKeys(data_ordem2);
		}

		logger.info("Preenchendo ou nao Data da ultima atualização do Valor Total da RP*".toUpperCase());
		WebElement campo_data_ordem3 = driver.findElement(By.id("tabGeral:inDdtUltAtual_input"));
		if (campo_data_ordem3.isEnabled()) {
			campo_data_ordem3.clear();
			campo_data_ordem3.sendKeys(data_ordem3);
		}

		logger.info("Preenchendo ou nao Data de recebimento do ofício no protocolo".toUpperCase());
		WebElement campo_data_ordem4 = driver.findElement(By.id("tabGeral:inDdtProtocolo_input"));
		if (campo_data_ordem4.isEnabled()) {
			campo_data_ordem4.clear();
			campo_data_ordem4.sendKeys(data_ordem4);
		}

		logger.info("Preenchendo ou nao Data de recebimento do Oficio Requisitorio pelo Ente Publico".toUpperCase());
		WebElement campo_data_ordem5 = driver.findElement(By.id("tabGeral:inDdtAR_input"));
		if (campo_data_ordem5.isEnabled()) {
			campo_data_ordem5.clear();
			campo_data_ordem5.sendKeys(data_ordem5);
		}

		logger.info("Preenchendo ou nao Dados do Executado".toUpperCase());
		WebElement campo_cnpj_Exec = driver.findElement(By.id("tabGeral:inCnpjExec"));
		if (campo_cnpj_Exec.isEnabled()) {
			campo_cnpj_Exec.clear();
			campo_cnpj_Exec.sendKeys(CNPJ);
			logger.info("Buscando nome do Executado".toUpperCase());
			driver.findElement(By
					.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr[1]/td[3]/button"))
					.click();

			logger.info("Preenchendo Esfera do Executado");
			// There is a bug with the custom dropdown, thus i had to did it.

			if (Helper.attemptingToClick(".//*[@id='tabGeral:cmbEsfera']")) {

				Helper.selectFromDropdown(Esfera, ".//*[@id='tabGeral:cmbEsfera_panel']/div/ul/li");
				{
					logger.info("Esfera do Executado Selecionada ");
					System.out.println("Esfera do Executado Selecionada ");
				}
			} else {
				logger.info("Esfera do Executado Inativo");
				System.out.println("Esfera do Executado Inativo".toUpperCase());
			}

			logger.info("Preenchendo Admistracao do Executado");
			if (Helper.attemptingToClick(".//*[@id='tabGeral:cmbTpEnte']")) {
				Helper.selectFromDropdown(Tipo_Administracao, ".//*[@id='tabGeral:cmbTpEnte_panel']/div/ul/li");
			} else {
				logger.info(" Admistracao do Executado Inativo");
				System.out.println("Admistracao do Executado Inativo");
			}

		}
		logger.info("Preenchendo Ente Devedor (Responsavel pelo Pagamento)".toUpperCase());

		if (Helper.isClickable(".//*[@id='tabGeral:cmbDevedor_label']")) {
			logger.info("Ente Devedor selesionado");
			Helper.selectFromDropdown(Nome_Dev, ".//*[@id='tabGeral:cmbDevedor_panel']/div/ul/li");
			fluentwait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbLegislacao']")));
			if (Helper.attemptingToClick(".//*[@id='tabGeral:cmbLegislacao']")) {
				Helper.selectFromDropdown(Lei_Amparo, ".//*[@id='tabGeral:cmbLegislacao_panel']/div/ul/li");
				{
					logger.info("Lei de Amparo selecionada".toUpperCase());
				}

			} else {
				System.out.println("Lei de Amparo inativa".toUpperCase());
			}
		} else {
			logger.info("Ente Devedor Inativo".toUpperCase());

		}

		logger.info("Preenchendo ou nao Dados do procurador".toUpperCase());
		if (Helper.attemptingToClick(".//*[@id='tabGeral:inCpfProc']")) {
			driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).clear();
			driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).sendKeys(CPF);
			driver.findElement(By
					.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[4]/td/fieldset/div/table/tbody/tr/td[3]/button"))
					.click();
		} else {
			logger.info("Dados do procurador Inativo".toUpperCase());

		}

		System.out.println("Salvar e Continuar".toUpperCase());
		Helper.attemptingToClick(
				"/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[7]/td/table/tbody/tr/td[1]/button");

	} // End of method fill in.

	/**
	 * Method fill in used to test the exception "Duplicated Register"
	 * 
	 * @param Nº_RP
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String Nº_RP) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo Numero requsicao de Pagamento".toUpperCase());
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(Nº_RP);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt84']")).click();

	}

	/**
	 * Method fill in used to test the exception "Invalid process"
	 * 
	 * @param Nº_RP
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 */
	public void preencher(String Nº_RP, String Nº_Processo)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo Numero requsicao de Pagamento".toUpperCase());
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(Nº_RP);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt84']")).click();

		logger.info("Preenchendo Numero processo".toUpperCase());
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrProc']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrProc']")).sendKeys(Nº_Processo);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt90']")).click();

	}

	/**
	 * Method fill in used to test other exceptions
	 * 
	 * @param Nº_RP
	 * @throws NoSuchElementException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	public void preencherTerceiros(String Dococumento_Fiscal)
			throws NoSuchElementException, TimeoutException, WebDriverException, InterruptedException {

		if (driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]")).getAttribute("aria-expanded")
				.equals("false")) {

			driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]")).click();
			if (Dococumento_Fiscal.length() < 15) {
				logger.info("Preenchendo Dados do procurador".toUpperCase());

				WebElement fieldP = fluentwait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inCpfProc']")));

				// org.openqa.selenium.StaleElementReferenceException: Element
				// is no longer attached to the DOM
				if (fluentwait.until(ExpectedConditions.stalenessOf(fieldP))) {
					System.out.println(Dococumento_Fiscal);

					driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).clear();
					driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).sendKeys(Dococumento_Fiscal);
					driver.findElement(By
							.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[4]/td/fieldset/div/table/tbody/tr/td[3]/button"))
							.click();
				}

			} else {
				logger.info("Preenchendo Dados do Executado".toUpperCase());

				WebElement fieldE = fluentwait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inCnpjExec']")));

				// org.openqa.selenium.StaleElementReferenceException: Element
				// is no longer attached to the DOM
				if (fluentwait.until(ExpectedConditions.stalenessOf(fieldE))) {
					System.out.println(Dococumento_Fiscal);
					driver.findElement(By.xpath(".//*[@id='tabGeral:inCnpjExec']")).clear();
					driver.findElement(By.xpath(".//*[@id='tabGeral:inCnpjExec']")).sendKeys(Dococumento_Fiscal);
					driver.findElement(By
							.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[3]/td/fieldset/div/table/tbody/tr[1]/td[3]/button"))
							.click();

				}

			}

		}

	}

}
