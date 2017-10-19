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

import com.aventstack.extentreports.ExtentTest;

import gep_pagamento_auxiliary.Helper;

public class Pagina {
	private WebDriver driver;
	private Wait<WebDriver> fluentwait;
	private ExtentTest logger = Teste_Visualiza_Requisicao_Pagamento.getLogger();

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public void novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Visualizar Registro de pagamento");
		driver.findElement(By.xpath("//td[9]/button")).click();

	}

	public boolean resultado(List<String> argumentos) throws TimeoutException, InterruptedException {

		List<String> tabela = new ArrayList<String>();

		logger.info("Dados do Processo");
		{

			tabela.add(fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[1]/td[2]/input")))
					.getAttribute("value"));

			tabela.add(driver.findElement(By.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[2]/td[2]/input"))
					.getAttribute("value"));

			if (driver
					.findElement(By
							.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/div/div[1]/input"))
					.isSelected()) {
				tabela.add(driver
						.findElement(By
								.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/label"))
						.getText());

			} else {
				tabela.add(driver
						.findElement(By
								.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/label"))
						.getText());
			}

			if (driver
					.findElement(By
							.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/div/div[1]/input"))
					.isSelected()) {
				tabela.add(driver
						.findElement(By
								.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/label"))
						.getText());

			} else {
				tabela.add(driver
						.findElement(By
								.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[2]/label"))
						.getText());
			}

			tabela.add(driver.findElement(By.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[5]/td[2]/div"))
					.getText());

			tabela.add(
					driver.findElement(By.xpath("//table/tbody/tr[1]/td/fieldset/div/table/tbody/tr[6]/td[2]/textarea"))
							.getAttribute("value"));

			System.out.println(Arrays.toString(tabela.toArray()));

		}

		logger.info("Datas de Referência");
		{

			tabela.addAll(Helper.getTextAndValueFromTable("//table/tbody/tr[2]/td/fieldset/div/table[1]"));

			tabela.addAll(Helper.getTextAndValueFromTable("//table/tbody/tr[2]/td/fieldset/div/table[2]"));

		}

		logger.info("Dados do Executado");
		{

			tabela.addAll(Helper.getTextAndValueFromTable("//table/tbody/tr[3]/td/fieldset/div/table"));

		}

		logger.info("Dados do Procurador");
		{
			tabela.addAll(Helper.getTextAndValueFromTable("//table/tbody/tr[4]/td/fieldset/div/table"));
		}

		logger.info("Ente Devedor (Responsável pelo Pagamento)");
		{

			tabela.addAll(Helper.getTextAndValueFromTable("//table/tbody/tr[5]/td/fieldset/div/table/tbody"));
			System.out.println(Arrays.toString(tabela.toArray()));
		}

		logger.info("Beneficiários");
		{

			driver.findElement(By.xpath("//table/tbody/tr[7]/td/table/tbody/tr/td[2]/button")).click();

			fluentwait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("/html/body/div[4]/div/div/div/form/div/div/div[2]/fieldset[1]/legend")));

			tabela.addAll(Helper.getCellsfromTableWithoutButton(".//*[@id='tabGeral:tblBeneficios']/div/table"));

			tabela.addAll(Helper.getCellsfromTableWithoutButton(
					"/html/body/div[4]/div/div/div/form/div/div/div[2]/fieldset[2]/div/fieldset/div/table/tbody/tr"));
		}

		logger.info("Visualização do Beneficiário");
		{

			driver.findElement(By.xpath("//table/tbody/tr/td[5]/button[1]")).click();

			fluentwait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div/form[2]/div[3]/div[1]/span")));

			tabela.add(driver
					.findElement(By.xpath("//table[1]/tbody/tr[1]/td/fieldset/div/table[1]/tbody/tr[1]/td[2]/div"))
					.getText());
			tabela.add(driver
					.findElement(By.xpath("//table[1]/tbody/tr[1]/td/fieldset/div/table[1]/tbody/tr[1]/td[4]/input"))
					.getAttribute("value"));

			tabela.add(driver
					.findElement(By
							.xpath("/html/body/div[4]/div/div/form[2]/div[3]/div[2]/table[1]/tbody/tr[1]/td/fieldset/div/table[1]/tbody/tr[2]/td[2]/input"))
					.getAttribute("value"));

			if (driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td/fieldset/div/table[1]/tbody/tr[1]/td[2]/div"))
					.getText().equals("Pessoa Física")) {
				if (driver
						.findElement(By
								.xpath("/html/body/div[4]/div/div/form[2]/div[3]/div[2]/table[1]/tbody/tr[1]/td/fieldset/div/table[1]/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/div/div[2]/span"))
						.getAttribute("checked").equals("true")) {
					tabela.add("Sim");
				} else {
					tabela.add("Não");
				}
			}

			System.out.println(Arrays.toString(tabela.toArray()));
		}

		logger.info("Valor (R$) e Observação");
		{

			tabela.addAll(Helper.getTextAndValueFromTable(
					"/html/body/div[4]/div/div/form[2]/div[3]/div[2]/table[1]/tbody/tr[2]/td/fieldset/div/table/tbody"));

			logger.info("Observação)");

			tabela.add(driver.findElement(By.xpath("//table[1]/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
					.getText());
		}

		driver.findElement(By.xpath("/html/body/div[4]/div/div/form[2]/div[3]/div[2]/table[2]/tbody/tr/td/button"))
				.click();

		System.out.println(Arrays.toString(tabela.toArray()));

		logger.info("Total Requisitado Beneficiários)");
		{

			tabela.addAll(Helper.getTextAndValueFromTable(
					"/html/body/div[4]/div/div/div/form/div/div/div[2]/fieldset[2]/div/fieldset/div/table/tbody"));
			System.out.println(Arrays.toString(tabela.toArray()));
		}

		// TODO For now, the is no lawyer!
		/*
		 * logger.info("Advogados"); if
		 * (Helper.getCellsfromTableWithoutButton("").size() != 0) {
		 * tabela.addAll(Helper.getCellsfromTableWithoutButton(
		 * ".//*[@id='tabGeral:tblAdvogados']/div/table")); }
		 * 
		 */
		logger.info("Terceiros Interessados)");
		{

			fluentwait
					.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("/html/body/div[4]/div/div/div/form/div/div/div[2]/table/tbody/tr/td[2]/button")))
					.click();

			fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr/td[6]/button[1]")));

			tabela.addAll(Helper.getCellsfromTableWithoutButton(".//*[@id='tabGeral:tblTerceiros']/div/table"));
			System.out.println(Arrays.toString(tabela.toArray()));
		}

		logger.info("Visualização do Terceiro Interessado");
		{

			driver.findElement(By.xpath("//table/tbody/tr/td[6]/button[1]")).click();

			fluentwait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='dlgVisualizacaoTerceiro_title']")));

			tabela.addAll(Helper.getTextAndValueFromTable(
					"/html/body/div[4]/div/div/form[2]/div[4]/div[2]/table[1]/tbody/tr[1]/td/fieldset"));

			System.out.println(Arrays.toString(tabela.toArray()));
		}

		logger.info("Valor e Observação");
		{

			tabela.addAll(Helper.getTextAndValueFromTable(
					"/html/body/div[4]/div/div/form[2]/div[4]/div[2]/table[1]/tbody/tr[2]/td/fieldset/div"));

			tabela.add(driver.findElement(By.xpath("//table[1]/tbody/tr[3]/td/fieldset/div/table/tbody/tr/td/textarea"))
					.getAttribute("value"));

			System.out.println(Arrays.toString(tabela.toArray()));

			driver.findElement(By.xpath("/html/body/div[4]/div/div/form[2]/div[4]/div[2]/table[2]/tbody/tr/td/button"))
					.click();
		}

		logger.info("Total Requisitado");
		{
			tabela.addAll(Helper.getTextAndValueFromTable(
					"/html/body/div[4]/div/div/div/form/div/div/div[3]/fieldset[2]/div/fieldset/div/table"));
			System.out.println("Tabela:     " + Arrays.toString(tabela.toArray()));
			System.out.println("Argumentos: " + Arrays.toString(argumentos.toArray()));
		}

		return tabela.equals(argumentos);

	}
}
