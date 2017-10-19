package listar_ordem_interna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Pagina {

	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private Logger logger;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.logger = Logger.getLogger(this.getClass().getCanonicalName());
		this.fluentwait = new FluentWait<WebDriver>(this.driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);

	}

	public Preenche novo() {
		Helper.pageSearcher(this.driver);
		logger.info("Buscando na lista".toUpperCase());
		return new Preenche(this.driver);

	}

	public boolean resultado(List<String> argumentos) throws InterruptedException {

		Thread.sleep(2000);
		logger.info("Verificando resultadona listagem".toUpperCase());
		List<String> tabela = Helper.getCellsfromTable(
				"/html/body/div[4]/div/div/div/form/table/tbody/tr[1]/td/div/div[2]/table");

		if (tabela.size() >= 11) {
			while (tabela.size() >= 10) {
				tabela.remove(tabela.size() - 1);
			}
		}
		
		System.out.println(Arrays.toString(argumentos.toArray()));
		System.out.println(Arrays.toString(tabela.toArray()));

		return tabela.equals(argumentos);
	}

	public boolean resultadoPDF(List<String> argumentos) throws InterruptedException {

		List<String> tabela = new ArrayList<String>();

		logger.info("Verificando PDF".toLowerCase());
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[5]/td/button[2]"))).click();

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='dlgPdfViewer_title']")));

		driver.findElement(By.xpath(".//*[@id='pageContainer1']")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath(".//*[@id='pageContainer1']")).sendKeys(Keys.CONTROL + "c");

		logger.info("Fechando PDF".toLowerCase());
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form[2]/div/div[2]/button")))
				.click();

		logger.info("Verificando resultadona listagem".toUpperCase());

		System.out.println(Arrays.toString(argumentos.toArray()));
		System.out.println(Arrays.toString(tabela.toArray()));

		return tabela.equals(argumentos);
	}

}
