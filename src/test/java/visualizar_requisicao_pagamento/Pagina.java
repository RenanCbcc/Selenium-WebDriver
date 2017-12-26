package visualizar_requisicao_pagamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
import gep_pagamento_auxiliary.Report;

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public void novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		Report.getLogger().info("Aguardando....");

		fluentwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		Report.getLogger().info("Visualizar Registro de pagamento");
		driver.findElement(By.xpath("//td[9]/button")).click();

	}

	public boolean resultado(List<String> argumentos) throws TimeoutException, InterruptedException {

		List<String> tabela = new ArrayList<String>();

		Report.getLogger().info("Dados do Processo");
		{

			tabela.add(fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[1]/td[2]/input")))
					.getAttribute("value"));

			tabela.add(driver.findElement(By.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[2]/td[2]/input"))
					.getAttribute("value"));

		}

		Report.getLogger().info("Dados do Executado");
		{

			tabela.add(fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//table/tbody/tr[3]/td/fieldset/div/table/tbody/tr[1]/td[2]/input")))
					.getAttribute("value"));

			tabela.add(driver.findElement(By.xpath("//table/tbody/tr[3]/td/fieldset/div/table/tbody/tr[1]/td[4]/input"))
					.getAttribute("value"));

		}

		Report.getLogger().info("Dados do Procurador");
		{
			tabela.add(fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//table/tbody/tr[4]/td/fieldset/div/table/tbody/tr/td[2]/input")))
					.getAttribute("value"));

			tabela.add(driver.findElement(By.xpath("//table/tbody/tr[4]/td/fieldset/div/table/tbody/tr/td[4]/input"))
					.getAttribute("value"));
			
		}

		Report.getLogger().info("Beneficiarios");
		{

			driver.findElement(By.xpath("//table/tbody/tr[7]/td/table/tbody/tr/td[2]/button")).click();

			fluentwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/fieldset/legend")));

			tabela.addAll(Helper.getCellsfromTableWithoutButton(".//*[@id='tabGeral:tblBeneficios']/div/table"));

		}

		Report.getLogger().info("Terceiros Interessados)");
		{

			fluentwait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/table/tbody/tr/td[2]/button")))
					.click();

			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[6]/button")));

			tabela.addAll(Helper.getCellsfromTableWithoutButton(".//*[@id='tabGeral:tblTerceiros']/div/table"));
		}

		System.out.println("tabela" + Arrays.toString(tabela.toArray()));
		System.out.println("argume" + Arrays.toString(argumentos.toArray()));
		return tabela.equals(argumentos);

	}
}
