package visualizar_Informacoes_resumidas_requisicao_pagamento;

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
	Wait<WebDriver> fluentwait;
	

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		Helper.pageSearcher(this.driver);
		Teste_Visualiza.getLogger().info("Aguardando....");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	}

	public boolean resultado(List<String> argumentos) throws TimeoutException, InterruptedException {

		List<String> tabela = new ArrayList<String>();
		Thread.sleep(2000);

		if (argumentos.size() > 1) {
			tabela = Helper.getCellsfromTableWithoutButton(".//*[@id='tblRequisicoes']/div[2]/table");
		} else {
			tabela = Helper.getCellsfromTable(".//*[@id='tblRequisicoes']/div[2]/table");
		}

		if (tabela.size() > argumentos.size()) {
			while (tabela.size() != argumentos.size()) {
				tabela.remove(tabela.size()-1);
			}
		}
		System.out.println("tabela"+Arrays.toString(tabela.toArray()));
		System.out.println("argume"+Arrays.toString(argumentos.toArray()));
		Report.getLogger().info("Retornando Resultados");
		return tabela.equals(argumentos);

	}

}
