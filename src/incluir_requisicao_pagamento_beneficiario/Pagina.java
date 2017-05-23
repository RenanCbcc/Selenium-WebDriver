package incluir_requisicao_pagamento_beneficiario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gep_pagamento_auxiliary.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;

public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	/**
	 * Standard method used access the tab 'Beneficiary'
	 * 
	 * @param tipo
	 * @param numero
	 * @param processo
	 * @return
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public Preenche novo(String tipo, String numero, String processo)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		Helper.pageSearcher(this.driver);

		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Preenchendo Numero requsicao de Pagamento");
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).sendKeys(numero);

		logger.info("Preenchendo Numero processo");
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).sendKeys(processo);
		driver.findElement(By.xpath(".//*[@id='j_idt84']")).click();// clica no
																	// botão
		// buscar
		// processo

		logger.info("Aguardando....");
		// wait for requisition table
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Alterar Requisicoes de Pagamento");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tblRequisicoes:0:j_idt110']"))).click();

		logger.info("Selecionando Aba Beneficiario");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();

		if (tipo.equals("Beneficiario")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt205']"))).click();
			logger.info("Selecionando novo Beneficiario");
		}

		else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt235']"))).click();
			logger.info("Selecionando novo Advogado");
		}

		return new Preenche(driver);

	}

	/**
	 * Auxiliary method used to include in a already loaded 'Beneficiary' page a
	 * Beneficiary or a Lawyer, without search a new page again.
	 * 
	 * @param tipo
	 * @return
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public Preenche novo(String tipo) throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		if (tipo.equals("Beneficiario")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt205']"))).click();
			logger.info("Selecionando novo Beneficiario");
		}

		else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt235']"))).click();
			logger.info("Selecionando novo Advogado");
		}

		return new Preenche(driver);

	}
/*
	
	/**
	 * Method used to fill in the tab 'Beneficiary'
	 * 
	 * @return
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException* /
	 
	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		logger.info("Selecionando Aba Beneficiario");
		//click at tab Beneficiary
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();
		
		// new Beneficiary
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt205']"))).click();

		return new Preenche(driver);

	}
*/
	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
