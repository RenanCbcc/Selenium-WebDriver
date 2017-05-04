package consultar_requisicao_pagamento;
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
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;

public class Pagina {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
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

	public boolean resultado(String numero, String cadastro) throws TimeoutException {

		// List<String> argumentos = new
		// ArrayList<String>(Arrays.asList(numero,processo, vara, requsicao,
		// data, situacao, cadastro));
		String[] args = { numero, cadastro };
		String[] tabela = new String[args.length];

		logger.info("Verifica se existem resultados na listagem");

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

		tabela[0] = driver.findElement(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[1]")).getText();
		tabela[1] = driver.findElement(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[8]")).getText();

		Arrays.sort(args);
		Arrays.sort(tabela);
		
		logger.info("Retornando Resultado");
		return Arrays.equals(args, tabela);

	} // fim do metodo resultado()

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='tblRequisicoes:j_idt91']"), "Requisições de Pagamento"));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}

	public void print(String s) {
		System.out.println(s);
	}
	
	

}
