package visualizar_detalhes_historicos_requisicao_pagamento;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NotFoundException;
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
                .ignoring(WebDriverException.class)
                .ignoring(ElementNotVisibleException.class);
		
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
		
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='j_idt33']/ul/li[4]/a"))); 
		
		Actions actions = new Actions(driver);
		logger.info("Opcoes de Requisisao de pagamento!");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/a")));
		logger.info("Gerenciar");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/a")));
		logger.info("Requisicoes de Pagamento");
		actions.moveToElement(driver.findElement(By.xpath(".//*[@id='j_idt33']/ul/li[4]/ul/li[2]/ul/li[1]/a"))).click().build().perform();
		
		return new Preenche(driver);
	} // fim do metodo novo()

	public boolean resultado(String numero,String processo,String requsicao,String credito,String vara, String situacao,String situacao_calculos
			, String data_envio, String data_recebmento, String data_atualizacao ,String resp_atualizacao, String lista_beneficiarios,
			String doc_fical, String prioridade, String data_atualizacao_beneficiario ) throws TimeoutException {

		
		
		// Bug_Mr_Anderson, why do you persist? <==========================================
				{
			
				
				WebElement Bug_Mr_Anderson = fluentwait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tblRequisicoes:0:j_idt150']")));
					
				Actions actions = new Actions(driver);
				    Integer iBottom = Bug_Mr_Anderson.getSize().height;
				    Integer iRight = Bug_Mr_Anderson.getSize().width;
				    actions.moveToElement(Bug_Mr_Anderson, iRight/2, iBottom/2).click().perform();
				    System.out.println("Bug_Mr_Anderson, why do you persist?");
				   
				
				} // fim do bloco Bug_Mr_Anderson.
		
		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='dlgInformacoesRequisicaoPagamento_title']"),"Mais informações da Requisição de Pagamento"));
				
		logger.info("verifica se existem resultados na listagem");
		return driver.getPageSource().contains(numero) && driver.getPageSource().contains(processo) && driver.getPageSource().contains(vara)
				&& driver.getPageSource().contains(requsicao) && driver.getPageSource().contains(credito)&& driver.getPageSource().contains(situacao)
				&& driver.getPageSource().contains(data_envio) && driver.getPageSource().contains(data_recebmento)&& driver.getPageSource().contains(data_atualizacao)
				&& driver.getPageSource().contains(resp_atualizacao)&& driver.getPageSource().contains(doc_fical)&& driver.getPageSource().contains(prioridade)
				&& driver.getPageSource().contains(prioridade)&& driver.getPageSource().contains(data_atualizacao_beneficiario);
		
		//66258375391
		
		
		
	} // fim do metodo resultado()
	
	
}
