package listar_ordem_interna;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Preenche {

	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private Logger logger;

	public Preenche(WebDriver driver) {
		this.driver = driver;
		this.fluentwait = new FluentWait<WebDriver>(this.driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
		logger = Logger.getLogger(this.getClass().getCanonicalName());
	}

	/**
	 * Method used to fill in all the necessary fields.
	 * @param Devedor
	 * @param Executado
	 * @param Gerar_Lista_Prioridades
	 * @param Gerar_Lista_Cronológica
	 * @param Informar_vencimento
	 * @throws InterruptedException
	 */
	public void preencher(String Devedor, String Executado, boolean Gerar_Lista_Prioridades,
			boolean Gerar_Lista_Cronologica, boolean Informar_vencimento) throws InterruptedException {

		fluentwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[4]/div/div/div/form/fieldset")));

		logger.info("Devedor");
		{
			Helper.isClickable(".//*[@id='cmbDevedor']");
			Helper.selectFromDropdown(Devedor, ".//*[@id='cmbDevedor_panel']/div[2]/ul/li");
		}

		logger.info("Executado");
		{
			Helper.isClickable(".//*[@id='cmbExecutado']");
			Helper.selectFromDropdown(Executado, ".//*[@id='cmbDevedor_panel']/div[2]/ul/li");
		}

		logger.info("Gerar Lista de Prioridades?");
		{
			if (Gerar_Lista_Prioridades) {
				Helper.attemptingToClick(".//*[@id='cmbPrioridade']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbPrioridade']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Gerar Lista de Ordem Cronológica?");
		{
			if (Gerar_Lista_Cronologica) {
				Helper.attemptingToClick(".//*[@id='cmbOrdemCronologica']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbOrdemCronologica']/tbody/tr/td[2]/div/div[2]/span");
			}
		}
		logger.info("Informar ano de vencimento?");
		{
			if (Informar_vencimento) {
				Helper.attemptingToClick(".//*[@id='cmbVencimento']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbVencimento']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Buscar?");
		{
			driver.findElement(By.xpath("//table/tbody/tr[5]/td/button")).click();
		}

	}

	/**
	 * Method used to fill in all the necessary fields.
	 * @param Devedor
	 * @param Executado
	 * @param Gerar_Lista_Prioridades
	 * @param Gerar_Lista_Cronológica
	 * @param Informar_vencimento
	 * @throws InterruptedException
	 */
	public void preencher(String Devedor, String Executado, String Gerar_Lista_Prioridades,
			String Gerar_Lista_Cronologica, String Informar_vencimento) throws InterruptedException {

		fluentwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[4]/div/div/div/form/fieldset")));

		logger.info("Devedor");
		{
			Helper.isClickable(".//*[@id='cmbDevedor']");
			Helper.selectFromDropdown(Devedor, ".//*[@id='cmbDevedor_panel']/div[2]/ul/li");
		}

		logger.info("Executado");
		{
			Helper.isClickable(".//*[@id='cmbExecutado']");
			Helper.selectFromDropdown(Executado, ".//*[@id='cmbDevedor_panel']/div[2]/ul/li");
		}

		logger.info("Gerar Lista de Prioridades?");
		{
			if (Gerar_Lista_Prioridades.equals("true")) {
				Helper.attemptingToClick(".//*[@id='cmbPrioridade']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbPrioridade']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Gerar Lista de Ordem Cronológica?");
		{
			if (Gerar_Lista_Cronologica.equals("true")) {
				Helper.attemptingToClick(".//*[@id='cmbOrdemCronologica']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbOrdemCronologica']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Informar ano de vencimento?");
		{
			if (Informar_vencimento.equals("true")) {
				Helper.attemptingToClick(".//*[@id='cmbVencimento']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbVencimento']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Buscar?");
		{
			driver.findElement(By.xpath("//table/tbody/tr[5]/td/button")).click();
		}

	}
	
	/**
	 * Method used to fill in all the necessary fields. 
	 * @param argumentos
	 * @throws InterruptedException
	 */
	public void preencher(List<String> argumentos) throws InterruptedException {

		fluentwait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[4]/div/div/div/form/fieldset")));

		logger.info("Devedor");
		{
			Helper.isClickable(".//*[@id='cmbDevedor']");
			Helper.selectFromDropdown(argumentos.get(0), ".//*[@id='cmbDevedor_panel']/div[2]/ul/li");
		}

		logger.info("Executado");
		{
			Helper.isClickable(".//*[@id='cmbExecutado']");
			Helper.selectFromDropdown(argumentos.get(1), ".//*[@id='cmbDevedor_panel']/div[2]/ul/li");
		}

		logger.info("Gerar Lista de Prioridades?");
		{
			if (argumentos.get(2).equals("true")) {
				Helper.attemptingToClick(".//*[@id='cmbPrioridade']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbPrioridade']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Gerar Lista de Ordem Cronológica?");
		{
			if (argumentos.get(3).equals("true")) {
				Helper.attemptingToClick(".//*[@id='cmbOrdemCronologica']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbOrdemCronologica']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Informar ano de vencimento?");
		{
			if (argumentos.get(4).equals("true")) {
				Helper.attemptingToClick(".//*[@id='cmbVencimento']/tbody/tr/td[1]/div/div[2]/span");
			} else {
				Helper.attemptingToClick(".//*[@id='cmbVencimento']/tbody/tr/td[2]/div/div[2]/span");
			}
		}

		logger.info("Buscar?");
		{
			driver.findElement(By.xpath("//table/tbody/tr[5]/td/button")).click();
		}

	}

}
