package consultar_requisicao_pagamento;

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
	private final static Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void visitar_Pagina() throws NotFoundException {
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
		
		return new Preenche(driver);
	} // fim do metodo novo()

	public boolean resultado(String numero,String processo,String vara,String requsicao,String credito,String data
			,String situacao,String cadastro) throws TimeoutException {

		logger.info("verifica se existem resultados na listagem");

		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='tblRequisicoes:j_idt130']"),"Requisições de Pagamento"));
		
		return driver.getPageSource().contains(numero) && driver.getPageSource().contains(processo) && driver.getPageSource().contains(vara)
				&& driver.getPageSource().contains(requsicao) && driver.getPageSource().contains(credito) && driver.getPageSource().contains(data)
				&& driver.getPageSource().contains(situacao) && driver.getPageSource().contains(cadastro);
		
		
		
	} // fim do metodo resultado()
	
	
	public boolean resultado(String resultado) throws TimeoutException {

		
		// espera por tabela de requisicoes.
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(".//*[@id='tblRequisicoes:j_idt130']"),"Requisições de Pagamento"));
		
		// verifico se este elemento contém a messagem dejejada.
		logger.info("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));
		System.out.println("verifica se existem resultados na listagem: "+driver.getPageSource().contains(resultado));
		
		return driver.getPageSource().contains(resultado);
		
	}
}
