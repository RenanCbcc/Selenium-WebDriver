package incluir_requisicao_pagamento_beneficiario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
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

	public Preenche novo(String tipo, String numero, String processo)
			throws NoSuchElementException, ElementNotVisibleException, TimeoutException {
		visitar();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"),
				"Login realizado com sucesso!"));
		logger.info("Login realizado com sucesso!");

		driver.findElement(By.xpath(".//*[@id='cmbPermissoes_label']")).click();
		driver.findElement(By.xpath("//*[@id='cmbPermissoes_panel']/div[2]/ul/li[1]")).click();
		logger.info("Divisão de Precatórios | Diretor!");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt33']/ul/li[4]/a")));

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Preenchendo Numero requsicao de Pagamento");
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrReq']")).sendKeys(numero);

		logger.info("Preenchendo Numero processo");
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='inNrProc']")).sendKeys(processo);
		driver.findElement(By.xpath(".//*[@id='j_idt86']")).click();// clica no
																	// botão
		// buscar
		// processo

		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		logger.info("Retificar Requisicoes de Pagamento");
		driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt113']")).click();

		logger.info("Selecionando Aba Beneficiario");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[2]/a"))).click();

		if (tipo.equals("Beneficiario")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt207']"))).click();
		}

		else {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral:j_idt237']"))).click();
		}

		return new Preenche(driver);

	}

	public boolean resultado(String resultado) throws TimeoutException {

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), resultado));

		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: " + driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);

	}
}
