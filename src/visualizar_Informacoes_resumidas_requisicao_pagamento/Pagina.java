package visualizar_Informacoes_resumidas_requisicao_pagamento;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;
import gep_pagamento_auxiliary.Helper;

public class Pagina {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private final static Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver)  
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(2, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(WebDriverException.class);
	}



	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		
		Helper.pageSearcher(this.driver);
		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	} // fim do metodo novo()

	public boolean resultado(String numero, String processo, String vara, String requsicao, String credito, String data,
			String situacao, String cadastro) throws TimeoutException {

		// List<String> argumentos = new
		// ArrayList<String>(Arrays.asList(numero,processo, vara, requsicao,
		// data, situacao, cadastro));
		String[] args = { numero, processo, vara, requsicao, credito, data, situacao, cadastro };
		String[] tabela = new String[args.length];

		logger.info("verifica se existem resultados na listagem");

		// espera por tabela de requisicoes.
		{ // este bloco eh uma maneira de garantir uma espera, porém muito
			// instavel. Se removido, gera 'AssertException'.
			try {
				fluentwait.until(ExpectedConditions
						.textToBePresentInElementLocated(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[1]"), numero));
			} catch (TimeoutException toe) {
				print("Numero de RP diferentes, prosseguindo");
			}

		}
		for (int i = 0; i < args.length; i++) {
			tabela[i] = driver.findElement(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[" + (i + 1) + "]"))
					.getText();
			print("Obsevado: " + tabela[i]);
			print("Esperado: " + args[i]);
		}

		Arrays.sort(args);
		Arrays.sort(tabela);
		return Arrays.equals(args, tabela);

	} // fim do metodo resultado()
	
	private void print(String s) {
		System.out.println(s);
	}
}
