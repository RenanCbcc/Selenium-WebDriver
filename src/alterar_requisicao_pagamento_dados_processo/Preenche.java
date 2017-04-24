package alterar_requisicao_pagamento_dados_processo;

import ancillary.Helper;
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
	private Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Preenche.class.getCanonicalName());

	public Preenche(WebDriver driver) {
		this.driver = driver;
		Helper.Init(this.driver);
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	public void preencher(String N�_RP, String N�_Processo, String Tipo_Requisicao, String Natureza_Credito,
			String Vara_Origem, String Observaco, String data_ordem0, String data_ordem1, String data_ordem2,
			String data_ordem3, String data_ordem4, String data_ordem5, String CNPJ, String Nome_Exe, String Esfera,
			String Tipo_Administracao, String Nome_Dev, String Lei_Amparo, String CPF)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo Numero requsicao de Pagamento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(N�_RP);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt83']")).click();// clica
																				// no
																				// bot�o
		// buscar numero
		// RP

		logger.info("Preenchendo Numero processo");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrProc']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrProc']")).sendKeys(N�_Processo);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt89']")).click();// clica
																				// no
																				// bot�o
		// buscar
		// processo

		logger.info("Preenchendo Tipo de Requisicao");

		if (Tipo_Requisicao.equals("RPV")) {

			if (fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[1]/div/div[2]/span")))
					.isSelected()) {
				logger.info("Tipo de Requisicao RPV jah selecionado");

			} else {
				logger.info("Tipo de Requisicao RPV selecionado");
				driver.findElement(By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[1]/div/div[2]/span")).click();
			}
		} else {

			if (fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[1]/div/div[2]/span")))
					.isSelected()) {
				logger.info("Tipo de Requisicao Precatorio jah selecionado");

			} else {
				logger.info("Tipo de Requisicao Precatorio selecionado");
				driver.findElement(By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[1]/div/div[2]/span")).click();
			}
		}

		logger.info("Preenchendo Natureza do Credito");
		if (Natureza_Credito.equals("Alimentar")) {

			if (fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[1]/div/div[2]/span")))
					.isSelected()) {
				logger.info("Natureza do Credito Alimentar jah selecionado");

			} else {
				logger.info("Natureza do Credito Alimentar selecionado");
				driver.findElement(By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[1]/div/div[2]/span"))
						.click();
			}
		} else {

			if (fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[3]/div/div[2]/span")))
					.isSelected()) {
				logger.info("Natureza do Credito Comum jah selecionado");

			} else {
				logger.info("Natureza do Credito Comum selecionado");
				driver.findElement(By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[3]/div/div[2]/span"))
						.click();
			}
		}

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbVara']")))
				.isSelected()) {
			logger.info("Preenchendo Vara de Origem");
			Helper.SelectFromDropdown(Vara_Origem, ".//*[@id='tabGeral:cmbVara_panel']/div[2]/ul/li");
			{
				logger.info("Vara de Origem Selecionada");

			}
		} else {
			logger.info("Vara de Origem Inativo");
			System.out.println("Vara de Origem Inativo");
		}

		logger.info("Preenchendo ou nao Observacao");
		WebElement campo_bservacao = driver.findElement(By.id("tabGeral:inObs"));
		if (campo_bservacao.isEnabled()) {
			campo_bservacao.clear();
			campo_bservacao.sendKeys(Observaco);
		}

		logger.info("Preenchendo ou nao Data do ajuizamento do processo de conhecimento");
		WebElement campo_data_ordem0 = driver.findElement(By.id("tabGeral:inDdtAjuiz_input"));
		if (campo_data_ordem0.isEnabled()) {
			campo_data_ordem0.clear();
			campo_data_ordem0.sendKeys(data_ordem0);
		}

		logger.info("Preenchendo ou nao Data do tr�nsito em julgado do processo de conhecimento");
		WebElement campo_data_ordem1 = driver.findElement(By.id("tabGeral:inDdtTrProc_input"));
		if (campo_data_ordem1.isEnabled()) {
			campo_data_ordem1.clear();
			campo_data_ordem1.sendKeys(data_ordem1);
		}

		logger.info(
				"Preenchendo ou nao Data do transito em julgado dos embargos a execucaoo e/ou impugna��o dos calculos");
		WebElement campo_data_ordem2 = driver.findElement(By.id("tabGeral:inDdtTrEmb_input"));
		if (campo_data_ordem2.isEnabled()) {
			campo_data_ordem2.clear();
			campo_data_ordem2.sendKeys(data_ordem2);
		}

		logger.info("Preenchendo ou nao Data da ultima atualiza��o do Valor Total da RP*");
		WebElement campo_data_ordem3 = driver.findElement(By.id("tabGeral:inDdtUltAtual_input"));
		if (campo_data_ordem3.isEnabled()) {
			campo_data_ordem3.clear();
			campo_data_ordem3.sendKeys(data_ordem3);
		}

		logger.info("Preenchendo ou nao Data de recebimento do of�cio no protocolo");
		WebElement campo_data_ordem4 = driver.findElement(By.id("tabGeral:inDdtProtocolo_input"));
		if (campo_data_ordem4.isEnabled()) {
			campo_data_ordem4.clear();
			campo_data_ordem4.sendKeys(data_ordem4);
		}

		logger.info("Preenchendo ou nao Data de recebimento do Oficio Requisitorio pelo Ente Publico");
		WebElement campo_data_ordem5 = driver.findElement(By.id("tabGeral:inDdtAR_input"));
		if (campo_data_ordem5.isEnabled()) {
			campo_data_ordem5.clear();
			campo_data_ordem5.sendKeys(data_ordem5);
		}

		logger.info("Preenchendo ou nao Dados do Executado");
		WebElement campo_cnpj_Exec = driver.findElement(By.id("tabGeral:inCnpjExec"));
		if (campo_cnpj_Exec.isEnabled()) {
			campo_cnpj_Exec.clear();
			campo_cnpj_Exec.sendKeys(CNPJ);
			logger.info("Buscando nome do Executado");
			driver.findElement(By.id("tabGeral:j_idt151")).click(); // busca o
																	// nome do
																	// ececutador

			logger.info("Preenchendo Esfera do Executado");

			if (fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbEsfera']")))
					.isSelected()) {
				Helper.SelectFromDropdown(Esfera, ".//*[@id='tabGeral:cmbEsfera_panel']/div/ul/li");
				{
					logger.info("Esfera do Executado Selecionada ");
					System.out.println("Esfera do Executado Selecionada ");
				}
			} else {
				logger.info("Esfera do Executado Inativo");
				System.out.println("Esfera do Executado Inativo");
			}

			logger.info("Preenchendo Admistracao do Executado");

			if (fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbTpEnte']")))
					.isSelected()) {
				Helper.SelectFromDropdown(Tipo_Administracao, ".//*[@id='tabGeral:cmbTpEnte_panel']/div/ul/li");
			} else {
				logger.info(" Admistracao do Executado Inativo");
				System.out.println("Admistracao do Executado Inativo");
			}

		} // fim do if.

		logger.info("Preenchendo Ente Devedor (Responsavel pelo Pagamento)");

		if (Helper.isClickable(".//*[@id='tabGeral:cmbDevedor']")) {
			logger.info("Ente Devedor selesionado");
			Helper.SelectFromDropdown(Nome_Dev, ".//*[@id='tabGeral:cmbDevedor_panel']/div/ul/li");

			if (fluentwait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbLegislacao']")))
					.isSelected()) {
				Helper.SelectFromDropdown(Lei_Amparo, ".//*[@id='tabGeral:cmbLegislacao_panel']/div/ul/li");
				{
					logger.info("Lei de Amparo selesionada");
				}

			} else {
				System.out.println("Lei de Amparo inativa");
			}
		} else {
			logger.info("Ente Devedor Inativo");
			System.out.println("Ente Devedor Inativo");
		} // fim do if.

		logger.info("Preenchendo ou nao Dados do procurador");

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inCpfProc']")))
				.isSelected()) {
			driver.findElement(By.id("tabGeral:inCpfProc")).clear();
			driver.findElement(By.id("tabGeral:inCpfProc")).sendKeys(CPF);
			driver.findElement(By.id("tabGeral:j_idt172")).click();
		} else {
			logger.info("Dados do procurador Inativo");
			System.out.println("Dados do procurador Inativo");
		}

		if (fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:j_idt190']")))
				.isEnabled()) {
			System.out.println("Salvar e Continuar");
		} else {
			fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:j_idt190']")))
					.click();
		}

	} // fim do metodo preenche.

	public void preencher(String N�_RP) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo Numero requsicao de Pagamento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(N�_RP);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt83']")).click();// clica
																				// no
																				// bot�o
		// buscar numero
		// RP

	}

}
