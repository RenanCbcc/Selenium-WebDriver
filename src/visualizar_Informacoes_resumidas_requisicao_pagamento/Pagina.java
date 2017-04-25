package visualizar_Informacoes_resumidas_requisicao_pagamento;
import ancillary.Helper;
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


	public Preenche novo() throws NoSuchElementException,ElementNotVisibleException,TimeoutException  {
		
		Helper.pageSearcher(this.driver);
		
		return new Preenche(driver);
	} // fim do metodo novo()

	public boolean resultado(String numero,String processo,String vara,String requsicao,String credito) throws TimeoutException {

		// Bug_Mr_Anderson, why do you persist? <==========================================
		{
	
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tblRequisicoes:0:j_idt148']")));
		WebElement Bug_Mr_Anderson = driver.findElement(By.xpath(".//*[@id='tblRequisicoes:0:j_idt148']"));
			
		Actions actions = new Actions(driver);
		    Integer iBottom = Bug_Mr_Anderson.getSize().height;
		    Integer iRight = Bug_Mr_Anderson.getSize().width;
		    actions.moveToElement(Bug_Mr_Anderson, iRight/2, iBottom/2).click().perform();
		    System.out.println("Bug_Mr_Anderson, why do you persist?");
		   
		
		} // fim do bloco Bug_Mr_Anderson.
		
		fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tabGeral']/ul/li[3]/a"))).click();
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='tabGeral:j_idt239']/legend"),"Dados da Requisição de Pagamento"));
		
		logger.info("verifica se existem resultados na listagem");

		return driver.getPageSource().contains(numero) && driver.getPageSource().contains(processo) && driver.getPageSource().contains(vara)
				&& driver.getPageSource().contains(requsicao) && driver.getPageSource().contains(credito);
		
		
		
	} // fim do metodo resultado()
	
	
}
