package incluir_requisicao_pagamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;

public class Pagina {
	private WebDriver driver;
	private WebDriverWait wait;
	private Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void visitar() throws NotFoundException {
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

	public Preenche novo() throws NoSuchElementException,ElementNotVisibleException,TimeoutException  {
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), "Login realizado com sucesso!"));
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
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/ul/li[1]/a"))).click().build().perform();
				
		
		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));
		
		logger.info("Incluir Requisicoes de Pagamento");
		driver.findElement(By.xpath(".//*[@id='j_idt89']")).click();
		
		logger.info("Aguardando....");
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_idt71")));
		
		return new Preenche(driver);
	}

	
	
	public boolean resultado(String resultado) throws TimeoutException {

		
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"),resultado));
		
		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));

		return driver.getPageSource().contains(resultado);
		
	}
}
