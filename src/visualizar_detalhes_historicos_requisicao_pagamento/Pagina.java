package visualizar_detalhes_historicos_requisicao_pagamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;

public class Pagina {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private final static Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class)
				.ignoring(ElementNotVisibleException.class);

	}

	private void visitar() throws NotFoundException {
		logger.info("Acessando à página: " + this.driver.getTitle());
		driver.get("http://10.8.17.214:8080/gep_teste");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("name"));
		username.clear();
		username.sendKeys("66258375391");
		logger.info("Preenchendo campo Login");
		driver.findElement(By.xpath(".//*[@id='j_idt166']")).click();
		logger.info("Autenticando no sistema");
	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		visitar();
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"),
				"Login realizado com sucesso!"));
		logger.info("Login realizado com sucesso!");

		driver.findElement(By.xpath(".//*[@id='cmbPermissoes_label']")).click();
		driver.findElement(By.xpath("//*[@id='cmbPermissoes_panel']/div[2]/ul/li[1]")).click();
		logger.info("Divisão de Precatórios | Diretor!");

		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt33']/ul/li[4]/a")));

		Actions actions = new Actions(driver);
		logger.info("Opcoes de Requisisao de pagamento!");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/a")));
		logger.info("Gerenciar");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/a")));
		logger.info("Requisicoes de Pagamento");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/ul/li[1]/a"))).click()
				.build().perform();

		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	} // fim do metodo novo()do metodo novo()

	public boolean resultado(String Numero, String Nº_Processo, String Tipo_Requisição, String Natureza_Credito,
			String Vara_Origem, String Situacao, String Situacao_calculos, String data_envio, String data_recebmento,
			String data_atualizacao, String resp_atualizacao, String lista_beneficiarios, String doc_fical,
			String prioridade, String data_atualizacao_beneficiario) throws TimeoutException {
		
		String[] args = { Numero, Nº_Processo, Tipo_Requisição, Natureza_Credito, Vara_Origem, Situacao,
				Situacao_calculos, data_envio, data_recebmento, data_atualizacao, resp_atualizacao,
				lista_beneficiarios, doc_fical, prioridade, data_atualizacao_beneficiario };
		
		List<String> aux = new ArrayList<String>();
		
		
		
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='dlgInformacoesRequisicaoPagamento_title']"),
				"Mais informações da Requisição de Pagamento"));

		logger.info("verifica se existem resultados na listagem");

		// espera por tabela de requisicoes.
		{ // este bloco eh uma maneira de garantir uma espera, porém muito
			// instavel. Se removido, gera 'AssertException'.
			try {
				fluentwait.until(ExpectedConditions
						.textToBePresentInElementLocated(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[1]"), Numero));
			} catch (TimeoutException toe) {
				print("Numero de RP diferentes, prosseguindo");
			}

		}

		for (int i = 1; i <= 4; i++) {

			aux.add(driver.findElement(By.xpath(".//*[@id='j_idt123']/tbody/tr[" + i + "]/td[2]")).getText());
			
			aux.add(driver.findElement(By.xpath(".//*[@id='tblBeneficiosAtualizacao_data']/tr/td[" + i + "]"))
					.getText());
		}
		
		
		for (int i = 1; i <= 2; i++) {
			
			aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[" + i + "]/td[2]")).getText());
			aux.add(driver.findElement(By.xpath(".//*[@id='j_idt123']/tbody/tr[" + i + "]/td[4]"))
					.getText());
		}
		
		aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[3]/td[2]")).getText());
		aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[2]/td[4]")).getText());
		aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[3]/td[4]")).getText());
		
		String[] rsut = aux.toArray(new String[args.length]);
		
	
		Arrays.sort(args);
		Arrays.sort(rsut);
		
		for (int i = 0; i < args.length; i++){
			print(args[i]);
			print(rsut[i]);
		}
		
		return Arrays.equals(args, rsut);
		
		

	} // fim do metodo resultado()

	public void print(String s) {
		System.out.println(s);
	}
	
	public void print(boolean s) {
		System.out.println(s);
	}
	
	public void print(int s) {
		System.out.println(s);
	}
}
