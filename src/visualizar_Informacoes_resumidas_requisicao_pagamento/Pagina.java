package visualizar_Informacoes_resumidas_requisicao_pagamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;

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

	public void visitar() throws NotFoundException {
		logger.info("Acessando à página: " + this.driver.getTitle());
		driver.get("http://10.8.17.214:8080/gep_teste");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("name"));
		username.clear();
		username.sendKeys("66258375391");
		logger.info("Preenchendo campo Login");
		driver.findElement(By.id("j_idt22")).click();
		logger.info("Autenticando no sistema");
	}

	public Preenche novo() throws NoSuchElementException,ElementNotVisibleException,TimeoutException  {
		
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ui-growl-item"), "Login realizado com sucesso!"));
		logger.info("Login realizado com sucesso!");
		
		driver.findElement(By.xpath(".//*[@id='cmbPermissoes_label']")).click(); 
		driver.findElement(By.xpath("//*[@id='cmbPermissoes_panel']/div[2]/ul/li[1]")).click();
		logger.info("Divisão de Precatórios | Diretor!");
		
		fluentwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt72']/ul/li[4]/a"))); 
		
		Actions actions = new Actions(driver);
		logger.info("Opcoes de Requisisao de pagamento!");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt72']/ul/li[4]/a/span[3]")));
		logger.info("Gerenciar");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt72']/ul/li[4]/ul/li[2]/a")));
		logger.info("Requisicoes de Pagamento");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt72']/ul/li[4]/ul/li[2]/ul/li[1]/a/span"))).click().build().perform();
		
		return new Preenche(driver);
	} // fim do metodo novo()

	public boolean resultado(String numero,String processo,String vara,String requsicao,String credito) throws TimeoutException {

		logger.info("verifica se existem resultados na listagem");

		// Codigo com error <==========================================
		{
	
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tblRequisicoes:0:j_idt148']"))).click();
		
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt152']"));
			
		
		 Actions actions = new Actions(driver);
		    Integer iBottom = element.getSize().height;
		    Integer iRight = element.getSize().width;
		    actions.moveToElement(element, iRight/2, iBottom/2).click().perform();
		    System.out.println("AHHHHHHHHHHHHHHHHHHHHH");
		}
		
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[3]/a"))).click();
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='tabGeral:j_idt239']/legend"),"Dados da Requisição de Pagamento"));
		
		return driver.getPageSource().contains(numero) && driver.getPageSource().contains(processo) && driver.getPageSource().contains(vara)
				&& driver.getPageSource().contains(requsicao) && driver.getPageSource().contains(credito);
		
		
		
	} // fim do metodo resultado()
	
	
}
