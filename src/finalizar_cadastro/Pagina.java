package finalizar_cadastro;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagina {

	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 5);

	}

	public void novo()
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException, InterruptedException {

		logger.info("FINALIZAR REQUISICAO DE PAGAMENTO");
		// TODO Thread is a bad programming practice. It must be replaced.
		Thread.sleep(2000);
		this.driver
				.findElement(By.xpath("/html/body/div[4]/div/div/div/form/div/div[2]/table/tbody/tr/td[9]/button[4]"))
				.click();

		logger.info("SAVAR E CONTINUAR");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[7]/td/table/tbody/tr/td[1]/button")))
				.click();

		logger.info("FINALIZAR CADASTRO");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[2]/table/tbody/tr/td[2]/button"))).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("/html/body/div[4]/div/div/form[2]/div/div/div[1]/table/tbody/tr[7]/td/table/tbody/tr/td[2]/button")))
					.click();

		}
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

		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

}
