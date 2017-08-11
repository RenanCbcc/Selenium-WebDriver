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
 * @author Renan Thiago, Estagiário, SETIN.
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
		logger.info("Entrar por Login e Senha");
		driver.findElement(By.xpath(".//*[@id='j_idt20:sFormaAcesso']/div[3]/span")).click();
		WebElement username = fluentwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='name']")));
		username.clear();
		username.sendKeys("669.271.102-91");
		logger.info("Preenchendo campo Login");
		driver.findElement(By.xpath(".//*[@id='j_idt31']")).click();
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
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt96']/ul/li[4]/a"))));
		logger.info("Gerenciar");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt96']/ul/li[4]/ul/li[2]/a")));
		logger.info("Requisicoes de Pagamento");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt96']/ul/li[4]/ul/li[2]/ul/li[1]/a"))).click()
				.build().perform();
	}

	public static boolean attemptingToClick(String xpath) throws InterruptedException {

		boolean result = false;
		int attempts = 0;
		while (attempts < 4) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath(xpath)).click();
				result = true;
				break;
			} catch (Exception e) {
			}
			attempts++;
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
	 * the 'DropDown' path,the last ; the desired option. Like
	 * this:<div class="ui-helper-hidden-accessible">
	 * <select id="cmbSituacao_input" name="cmbSituacao_input" tabindex="-1"
	 * aria-hidden="true">
	 * <option value="" selected="selected">Selecione</option>
	 * <option value="465bb65a-a09d-44bc-9f3e-d9fc546024eb">Autuada</option>
	 * <option value="1706faf1-cc25-4f9b-a5eb-6c619a14e513">Cancelada</option>
	 * <option value="666abfac-3d5f-4e9a-95ce-facbdc6a73de">Paga</option>
	 * <option value="6666b15a-acf8-4dea-ba69-01d0e3dce353">Parcialmente
	 * Paga</option> </select> </div>
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

		System.out.println("Cannot find " + option + " in dropdown");
		// TODO I would gravely doubt the sanity of any testing code which
		// ignores exceptions thrown from tested code.
		// throw new NoSuchElementException("Cannot find " + option + " in
		// dropdown");
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
	 * Primarily, it locates the Table and, soon after, returns all its cells.
	 * 
	 * @param xpath
	 * @return List<<code>String</code>>
	 */
	public static List<String> getCellsfromTable(String xpath) {
		List<String> aux = new ArrayList<String>();

		List<WebElement> rows_table = driver.findElement(By.xpath(xpath)).findElements(By.tagName("tr"));

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
	 * Method locates a Table and, soon after, returns all its text cells
	 * without the buttons. Like this:
	 * <table role="grid">
	 * <thead id="tabGeral:tblBeneficios_head">
	 * <tr role="row">
	 * <th scope="col" aria-label="Beneficiário" role="columnheader" class=
	 * "ui-state-default" id="tabGeral:tblBeneficios:j_idt211"><span class=
	 * "ui-column-title">Beneficiário</span></th>
	 * <th scope="col" aria-label="CPF/CNPJ" role="columnheader" class=
	 * "ui-state-default" id="tabGeral:tblBeneficios:j_idt213"><span class=
	 * "ui-column-title">CPF/CNPJ</span></th>
	 * <th scope="col" aria-label="Prioridade" role="columnheader" class=
	 * "ui-state-default" id="tabGeral:tblBeneficios:j_idt216"><span class=
	 * "ui-column-title">Prioridade</span></th>
	 * <th scope="col" aria-label="Total Bruto (R$)" role="columnheader" class=
	 * "ui-state-default" id="tabGeral:tblBeneficios:j_idt218"><span class=
	 * "ui-column-title">Total Bruto (R$)</span></th>
	 * <th scope="col" role="columnheader" class="ui-state-default" id=
	 * "tabGeral:tblBeneficios:j_idt222"><span class=
	 * "ui-column-title"></span></th>
	 * </tr>
	 * </thead> <tbody class="ui-datatable-data ui-widget-content" id=
	 * "tabGeral:tblBeneficios_data">
	 * <tr role="row" class="ui-widget-content ui-datatable-even" data-ri="0">
	 * <td role="gridcell">Weyland-Yutani Corporation.</td>
	 * <td role="gridcell">82.863.545/0001-96</td>
	 * <td role="gridcell">Não</td>
	 * <td role="gridcell">12.000,00</td>
	 * <td role="gridcell"><button type="submit" title="Visualizar" onclick=
	 * "PrimeFaces.ab({s:&quot;tabGeral:tblBeneficios:0:j_idt223&quot;,u:&quot;dlgVisualizacaoBeneficio&quot;,g:false});return
	 * false;" class="ui-button ui-widget ui-state-default ui-corner-all
	 * ui-button-icon-only" name="tabGeral:tblBeneficios:0:j_idt223" id=
	 * "tabGeral:tblBeneficios:0:j_idt223" role="button" aria-disabled=
	 * "false"><span class="ui-button-icon-left ui-icon ui-c
	 * ui-icon-search"></span><span class="ui-button-text
	 * ui-c">Visualizar</span></button><button type="submit" title="Visualizar
	 * histórico de atualizações" onclick=
	 * "PrimeFaces.ab({s:&quot;tabGeral:tblBeneficios:0:j_idt224&quot;,u:&quot;dlgHistoricoAtualizacao&quot;,g:false});return
	 * false;" class="ui-button ui-widget ui-state-default ui-corner-all
	 * ui-button-icon-only" name="tabGeral:tblBeneficios:0:j_idt224" id=
	 * "tabGeral:tblBeneficios:0:j_idt224" role="button" aria-disabled=
	 * "false"><span class="ui-button-icon-left ui-icon ui-c
	 * ui-icon-note"></span><span class="ui-button-text ui-c">Visualizar
	 * histórico de
	 * atualizações</span></button><button type="submit" title="Visualizar
	 * histórico de pagamentos" onclick=
	 * "PrimeFaces.ab({s:&quot;tabGeral:tblBeneficios:0:j_idt225&quot;,u:&quot;dlgHistoricoPagamento&quot;,g:false});return
	 * false;" class="ui-button ui-widget ui-state-default ui-corner-all
	 * ui-button-icon-only" name="tabGeral:tblBeneficios:0:j_idt225" id=
	 * "tabGeral:tblBeneficios:0:j_idt225" role="button" aria-disabled=
	 * "false"><span class="ui-button-icon-left ui-icon ui-c
	 * ui-icon-suitcase"></span><span class="ui-button-text ui-c">Visualizar
	 * histórico de pagamentos</span></button></td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * 
	 * @param xpath
	 * @return List<["Weyland-Yutani
	 *         Corporation.","82.863.545/0001-96","Não","12.000,00"]</code>>
	 */
	public static List<String> getCellsfromTableWithoutButton(String xpath) {
		List<String> aux = new ArrayList<String>();

		List<WebElement> rows_table = fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)))
				.findElements(By.tagName("tr"));

		for (int row = 1; row < rows_table.size(); row++) {

			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			int columns_count = Columns_row.size();

			for (int column = 0; column < columns_count
					- 1/* The last one is a button */; column++) {
				aux.add(Columns_row.get(column).getText());

			}

		}

		return aux;
	}

	/**
	 * Method locates a Table and, soon after, returns all values at specified
	 * tags without its respective titles. Like this :<tbody>
	 * <tr class="ui-widget-content ui-panelgrid-even" role="row">
	 * <td role="gridcell" class="ui-panelgrid-cell">
	 * <div style="min-width: 119px;" id="cmbTpPessoa" class="ui-selectonemenu
	 * ui-widget ui-state-default ui-corner-all">
	 * <div class="ui-helper-hidden-accessible">
	 * <select id="cmbTpPessoa_input" name="cmbTpPessoa_input" tabindex="-1"
	 * aria-hidden="true" onchange=
	 * "PrimeFaces.ab({s:&quot;cmbTpPessoa&quot;,e:&quot;valueChange&quot;,p:&quot;cmbTpPessoa&quot;,u:&quot;pnlCadastro&quot;});">
	 * <option value="" disabled="disabled">Selecione</option>
	 * <option value="9ee12318-74c1-46bf-87a1-fe10b8100c38" selected=
	 * "selected">Pessoa Física</option>
	 * <option value="59b661ad-e313-460c-acef-15fb2c9d9370">Pessoa
	 * Jurídica</option> </select> </div> </div></td>
	 * <td role="gridcell" class="ui-panelgrid-cell"><input aria-readonly=
	 * "false" aria-disabled="false" role="textbox" id="inCpfBenef" name=
	 * "inCpfBenef" value="000.000.000-00" size="15" aria-required="true" class=
	 * "ui-inputfield ui-inputmask ui-widget ui-state-default ui-corner-all"
	 * type="text"></td>
	 * 
	 * </tr>
	 * </tbody>
	 * 
	 * @param
	 * @return List<["000.000.000-00","Documento Fiscal"]>
	 * @throws InterruptedException
	 */
	public static List<String> getTextFromTable(String xpath) throws InterruptedException {
		List<String> aux = new ArrayList<String>();
		Thread.sleep(1000);
		List<WebElement> rows = driver.findElement(By.xpath(xpath)).findElements(By.tagName("tr"));

		for (int i = 0; i < rows.size(); i++) {

			List<WebElement> Columns = rows.get(i).findElements(By.tagName("td"));
			System.out.println("Numero de celulas na linha " + i + " : " + Columns.size());

			// Loop will execute till the last cell of that specific row.
			for (int j = 0; j < Columns.size(); j++) {
				// To retrieve text from that specific cell.
				if (j % 2 != 0) {
					// System.out.println("Elemento da limha " + i + " coluna "
					// + j + ":" + Columns.get(j).getText());
					if (Columns.get(j).getText().length() != 0) {
						aux.add(Columns.get(j).getText());
					} else if (!Columns.get(j).findElement(By.tagName("input")).getAttribute("value").equals(null)) {
						aux.add(Columns.get(j).findElement(By.tagName("input")).getAttribute("value"));
					} else if (!Columns.get(j).findElement(By.tagName("textarea")).getAttribute("value").equals(null)) {
						aux.add(Columns.get(j).findElement(By.tagName("textarea")).getAttribute("value"));
					}

				}
			}
			System.out.println("--------------------------------------------------");
		}
		return aux;
	}

}
