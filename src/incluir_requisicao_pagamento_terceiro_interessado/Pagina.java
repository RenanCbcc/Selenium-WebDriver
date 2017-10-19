package incluir_requisicao_pagamento_terceiro_interessado;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gep_pagamento_auxiliary.Helper;

public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private final static Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	/**
	 * DEPRECATED Method used to include a 'Third party' at processes without
	 * verifying whether the process is finalized or not.
	 * @param numero
	 * @param processo
	 * @return  <pre>Class Preenche</pre>
	 * @throws NoSuchElementExceptio
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public Preenche novo(String numero, String processo)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		Helper.pageSearcher(this.driver);

		logger.info("Aguardando...."); // espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Preenchendo Numero requsicao de Pagamento");
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).sendKeys(numero);

		logger.info("Preenchendo Numero processo");
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).sendKeys(processo);
		driver.findElement(By.xpath(".//*[@id='j_idt84']")).click();

		logger.info("Retificar Requisicoes de Pagamento");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tblRequisicoes:0:j_idt110']"))).click();

		logger.info("Aba Terceiros Interessados");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[3]/a"))).click();

		return new Preenche(driver);
	}

	/**
	 * Method used when it is necessary to verify that the process is not
	 * finalized.
	 * 
	 * @return <pre>Class Preenche</pre>
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public Preenche novo()
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Alterar Requisicoes de Pagamento");
		// TODO At this case, Thread is a bad programming practice. It must be
		// replaced.
		Helper.attemptingToClick("//button[4]");

		logger.info("Aba Terceiros Interessados");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[3]/a"))).click();

		return new Preenche(driver);
	}

	/**
	 * Auxiliary method used to include in a already loaded 'Third Party'page a
	 * beneficiary or a lawyer, without search a new page again.
	 * 
	 * @return <pre>Class Preenche</pre>
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public Preenche novo(String Third_Party)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		logger.info("Aguardando....");
		// Wait for the tab 'Third_Party'

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:pnlBeneficios']/legend")))
				.click();

		logger.info("Aba Terceiros Interessados");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[3]/a"))).click();

		return new Preenche(driver);
	}

	/**
	 * Method used to verify if a specific message is returned to confirm a
	 * success operation.
	 * 
	 * @param resultado
	 * @return boolean
	 * @throws TimeoutException
	 */
	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
