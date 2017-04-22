package alterar_requisicao_pagamento_dados_processo;

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

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;

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

	public void preencher(String Nº_RP, String Nº_Processo, String Tipo_Requisicao, String Natureza_Credito,
			String Vara_Origem, String Observaco, String data_ordem0, String data_ordem1, String data_ordem2,
			String data_ordem3, String data_ordem4, String data_ordem5, String CNPJ, String Nome_Exe, String Esfera,
			String Tipo_Administracao, String Nome_Dev, String Lei_Amparo, String CPF)
			throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo Numero requsicao de Pagamento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(Nº_RP);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt83']")).click();// clica
																				// no
																				// botão
		// buscar numero
		// RP

		logger.info("Preenchendo Numero processo");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrProc']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrProc']")).sendKeys(Nº_Processo);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt89']")).click();// clica
																				// no
																				// botão
		// buscar
		// processo


		logger.info("Preenchendo Tipo de Requisicao");
		fluentwait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[3]/div/div[2]/span")));

		if (Tipo_Requisicao.equals("RPV")) {

			if (isClickable(
					driver.findElement(By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[3]/div/div[2]/span")))) {
				logger.info("Tipo de Requisicao RPV");
			} else {
				logger.info("Tipo de Requisicao Inativo");
				System.out.println("Tipo de Requisicao Inativo");
			}
		} else {

			if (isClickable(
					driver.findElement(By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[1]/div/div[2]/span")))) {
				logger.info("Tipo de Requisição Precatorio");
			} else {
				logger.info("Tipo de Requisicao Inativo");
				System.out.println("Tipo de Requisicao Inativo");
			}
		}

		logger.info("Preenchendo Natureza do Credito");
		if (Natureza_Credito.equals("Alimentar")) {
			if (isClickable(
					driver.findElement(By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[1]/div/div[2]/span")))) {
				logger.info("Natureza do Credito Alimentar");
			}
		} else {
			if (isClickable(
					driver.findElement(By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[3]/div/div[2]/span")))) {
				logger.info("Natureza do Credito Comum");
			} else {
				logger.info("Natureza do Credito Inativo");
				System.out.println("Natureza do Credito Inativo");
			}
		}

		
		if (isClickable(driver.findElement(By.xpath(".//*[@id='tabGeral:cmbVara']")))) {
			logger.info("Preenchendo Vara de Origem");
			SelectFromDropdown(Vara_Origem, ".//*[@id='tabGeral:cmbVara_panel']/div[2]/ul/li");
			{
				logger.info("Vara de Origem Selecionada");
			}
		} else {
			logger.info("Vara de Origem Inativo");
			System.out.println("Vara de Origem Inativo");
		}

		// Bug_Mr_Anderson, why do you persist?
		// <==========================================
		{

			// se isto for retirado, por algum motivo, o campo nao eh preencido
			if (Natureza_Credito.equals("Alimentar")) { // alimentar e comun.
				driver.findElement(By.xpath(".//*[@id='tabGeral:cmbNaturezas']/tbody/tr/td[1]/div/div[2]/span"))
						.click();
			} else {
				driver.findElement(By.xpath(".//*[@id='tabGeral:cmbAssuntos']/tbody/tr/td[3]/div/div[2]/span")).click();
			}

		} // fim do bloco Bug_Mr_Anderson.

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

		logger.info("Preenchendo ou nao Data do trânsito em julgado do processo de conhecimento");
		WebElement campo_data_ordem1 = driver.findElement(By.id("tabGeral:inDdtTrProc_input"));
		if (campo_data_ordem1.isEnabled()) {
			campo_data_ordem1.clear();
			campo_data_ordem1.sendKeys(data_ordem1);
		}

		logger.info(
				"Preenchendo ou nao Data do transito em julgado dos embargos a execucaoo e/ou impugnação dos calculos");
		WebElement campo_data_ordem2 = driver.findElement(By.id("tabGeral:inDdtTrEmb_input"));
		if (campo_data_ordem2.isEnabled()) {
			campo_data_ordem2.clear();
			campo_data_ordem2.sendKeys(data_ordem2);
		}

		logger.info("Preenchendo ou nao Data da ultima atualização do Valor Total da RP*");
		WebElement campo_data_ordem3 = driver.findElement(By.id("tabGeral:inDdtUltAtual_input"));
		if (campo_data_ordem3.isEnabled()) {
			campo_data_ordem3.clear();
			campo_data_ordem3.sendKeys(data_ordem3);
		}

		logger.info("Preenchendo ou nao Data de recebimento do ofício no protocolo");
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
			fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbEsfera']")));
			if (isClickable(driver.findElement(By.xpath(".//*[@id='tabGeral:cmbEsfera']")))) {
				SelectFromDropdown(Esfera, ".//*[@id='tabGeral:cmbEsfera_panel']/div/ul/li");
				{
					logger.info("Esfera do Executado Selecionada ");
					System.out.println("Esfera do Executado Selecionada ");
				}
			} else {
				logger.info("Esfera do Executado Inativo");
				System.out.println("Esfera do Executado Inativo");
			}

			logger.info("Preenchendo Admistracao do Executado");
			if (isClickable(driver.findElement(By.xpath(".//*[@id='tabGeral:cmbTpEnte']")))) {
				SelectFromDropdown(Tipo_Administracao, ".//*[@id='tabGeral:cmbTpEnte_panel']/div/ul/li");
			} else {
				logger.info(" Admistracao do Executado Inativo");
				System.out.println("Admistracao do Executado Inativo");
			}

		} // fim do if.

		logger.info("Preenchendo Ente Devedor (Responsavel pelo Pagamento)");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:cmbDevedor']")));
		if (isClickable(driver.findElement(By.xpath(".//*[@id='tabGeral:cmbDevedor']")))) {
			logger.info("Ente Devedor selesionado");
			SelectFromDropdown(Nome_Dev, ".//*[@id='tabGeral:cmbDevedor_panel']/div/ul/li");

			if (isClickable(driver.findElement(By.xpath(".//*[@id='tabGeral:cmbLegislacao']")))) {
				SelectFromDropdown(Lei_Amparo, ".//*[@id='tabGeral:cmbLegislacao_panel']/div/ul/li");
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
		if (isClickable(driver.findElement(By.id("tabGeral:inCpfProc")))) {
			driver.findElement(By.id("tabGeral:inCpfProc")).clear();
			driver.findElement(By.id("tabGeral:inCpfProc")).sendKeys(CPF);
			driver.findElement(By.id("tabGeral:j_idt172")).click();
		} else {
			logger.info("Dados do procurador Inativo");
			System.out.println("Dados do procurador Inativo");
		}
		
	
		if (isClickable(fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:j_idt190']"))))) {
			System.out.println("Salvar e Continuar");
		} else{fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:j_idt190']"))).click();}

	} // fim do metodo preenche.

	public void preencher(String Nº_RP) throws NoSuchElementException, TimeoutException, WebDriverException {

		logger.info("Preenchendo Numero requsicao de Pagamento");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tabGeral:inNrReq']")))
				.clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inNrReq']")).sendKeys(Nº_RP);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt83']")).click();// clica
																				// no
																				// botão
		// buscar numero
		// RP

	}

	private boolean isClickable(WebElement el) {
		try {
			// espera que o elemento esja visivel e clickavel.
			fluentwait.until(ExpectedConditions.elementToBeClickable(el)).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private void SelectFromDropdown(String option, String path) {
		List<WebElement> options = driver.findElements(By.xpath(path));
		for (WebElement opt : options) {
			if (opt.getText().equals(option)) {
				opt.click();
				return;
			}
		}
		throw new NoSuchElementException("Can't find " + option + " in dropdown");
	}

}
