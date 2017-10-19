package incluir_requisicao_pagamento_beneficiario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import gep_pagamento_auxiliary.Helper;

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
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
	 * @throws InterruptedException
	 */
	public Preenche novo(String numero, String processo)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		Helper.pageSearcher(this.driver);

		Teste_Inclui_Beneficiario.getLogger().info("Aguardando....");

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		Teste_Inclui_Beneficiario.getLogger().info("Preenchendo Numero requsicao de Pagamento");

		driver.findElement(By.xpath(".//*[@id='inNrReq']")).sendKeys(numero);

		Teste_Inclui_Beneficiario.getLogger().info("Preenchendo Numero processo");

		driver.findElement(By.xpath(".//*[@id='inNrProc']")).sendKeys(processo);

		Teste_Inclui_Beneficiario.getLogger().info("Buscando");
		driver.findElement(By.xpath("//td/button")).click();

		Teste_Inclui_Beneficiario.getLogger().info("Aguardando....");
		// wait for requisition table
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		Teste_Inclui_Beneficiario.getLogger().info("Alterar Requisicoes de Pagamento");
		Helper.attemptingToClick("//tbody[@id='tblRequisicoes_data']/tr/td[9]/button[4]");
		Teste_Inclui_Beneficiario.getLogger().info("Selecionando Aba Beneficiario");

		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();

		return new Preenche(driver);

	}

	/**
	 * Auxiliary method used to include in a already loaded 'Beneficiary' page a
	 * Beneficiary or a Lawyer, without search a new page again.
	 * @deprecated
	 * @param tipo
	 * @return
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		return new Preenche(driver);

	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		Teste_Inclui_Beneficiario.getLogger()
				.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
