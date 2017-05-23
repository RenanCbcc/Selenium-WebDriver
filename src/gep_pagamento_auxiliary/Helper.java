package gep_pagamento_auxiliary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * This class consists exclusively of static methods and was made to modularize
 * common behaviors of the test case such as open the main page, select a
 * desired option from a 'DropDown', verify whether a WebElement is enabled and
 * so forth.
 * 
 * @author Renan Thiago
 *
 */
public class Helper {

	private static Wait<WebDriver> fluentwait;
	private static Logger logger = Logger.getLogger(Helper.class.getCanonicalName());
	private static WebDriver driver;

	public static void init(WebDriver drive) {
		driver = drive;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public static boolean attemptingToClick(String xpath) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 3) {
			try {

				driver.findElement(By.xpath(xpath)).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
			System.out.println(attempts);
		}
		return result;
	}

	/**
	 * Method receives as argument a path from a WebElement and verifies whether
	 * this element is enabled and visible.
	 * 
	 * @param xpath
	 * @return <b>boolean</b>
	 */
	public static boolean isClickable(String xpath) {
		try {
			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	/**
	 * Static method receives as argument two Strings; the first representing
	 * the 'DropDown' path,the last ; the desired option.
	 * 
	 * @param option
	 * @param path
	 */
	public static void selectFromDropdown(String option, String path) {
		List<WebElement> options = driver.findElements(By.xpath(path));
		for (WebElement opt : options) {
			if (opt.getText().equals(option)) {
				opt.click();
				return;
			}
		}
		throw new NoSuchElementException("Cannot find " + option + " in dropdown");
	}

	/**
	 * Static method used to drag an WebElement to another.
	 * 
	 * @param draggble
	 * @param droppble
	 */
	public static void dragAndDrop(String draggble, String droppble) {

		Actions act = new Actions(driver);
		WebElement drag = driver.findElement(By.xpath(draggble));
		WebElement drop = driver.findElement(By.xpath(droppble));
		act.dragAndDrop(drag, drop).build().perform();
	}

	/**
	 * Method opens the main page of 'GEP' and set the necessary permissions to
	 * continue the rest of the test case.
	 * 
	 * @param driver
	 * @throws NotFoundException
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 */
	public static void pageSearcher(WebDriver driver)

			throws NotFoundException, NoSuchElementException, ElementNotVisibleException, TimeoutException {
		init(driver);
		logger.info("Acessando à página: " + driver.getTitle());
		driver.get("http://10.8.17.214:8080/gep_teste");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("name"));
		username.clear();
		username.sendKeys("669.271.102-91");
		logger.info("Preenchendo campo Login");
		driver.findElement(By.xpath(".//*[@id='j_idt167']")).click();
		logger.info("Autenticando no sistema");

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"),
				"Login realizado com sucesso!"));
		logger.info("Login realizado com sucesso!");

		driver.findElement(By.xpath(".//*[@id='cmbPermissoes_label']")).click();
		driver.findElement(By.xpath("//*[@id='cmbPermissoes_panel']/div[2]/ul/li[1]")).click();
		logger.info("Divisão de Precatórios | Diretor!");

		Actions actions = new Actions(driver);
		logger.info("Opcoes de Requisisao de pagamento!");
		actions.moveToElement(fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt33']/ul/li[4]/a"))));
		logger.info("Gerenciar");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/a")));
		logger.info("Requisicoes de Pagamento");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/ul/li[1]/a"))).click()
				.build().perform();
	}

	/**
	 * Primarily, it locates the Table and, soon after, returns all its cells.
	 * 
	 * @param xpath
	 * @return List<<code>String</code>>
	 */
	public static List<String> getCellsfromTable(String id) {
		List<String> aux = new ArrayList<String>();

		List<WebElement> rows_table = driver.findElement(By.id(id)).findElements(By.tagName("tr"));

		for (int row = 1; row < rows_table.size(); row++) {

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			int columns_count = Columns_row.size();

			for (int column = 0; column < columns_count; column++) {
				aux.add(Columns_row.get(column).getText());

			}

		}

		return aux;
	}

	/**
	 *  Primarily, it locates the Table and, soon after, returns all its cells without its respective titles.
	 * @param 
	 * @return List<<code>String</code>> 
	 */
	public static List<String> getCellsfromTableWithoutTititle(String id) {
		List<String> aux = new ArrayList<String>();

		List<WebElement> rows = driver.findElement(By.id(id)).findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> Columns = rows.get(i).findElements(By.tagName("td"));
			System.out.println("Numero de celulas na linha " + i + " : " + Columns.size());

			// Loop will execute till the last cell of that specific row.
			for (int j = 0; j < Columns.size(); j++) {
				// To retrieve text from that specific cell.
				if (j == 1 || j == 3) {
					System.out.println("Elemento da limha " + i + " coluna " + j + ":" + Columns.get(j).getText());
					aux.add(Columns.get(j).getText());
				}
			}
			System.out.println("--------------------------------------------------");
		}
		return aux;
	}

}
