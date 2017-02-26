package pesquisar_calculo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.util.logging.*;
import org.openqa.selenium.NoSuchElementException;

public class Pesquisa {
	private WebDriver driver;
	private WebDriverWait wait;
	private final static Logger logger = Logger.getLogger(Pesquisa.class.getCanonicalName());

	public Pesquisa(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void visitar_Pagina() {
		logger.info("Acessando à página: " + this.driver.getTitle());
		driver.get("http://macunaima:8180/pjecalc/logon.jsf?conversationId=1027");

		WebElement username = driver.findElement(By.name("loginUS:usuarioUS"));
		username.sendKeys("00000000191");
		logger.info("Preenchendo campo usuário");
		driver.findElement(By.name("loginUS:j_id25")).click();
		logger.info("Autenticando no sistema");
	}

	public Nova_Pesquisa novo() throws NoSuchElementException {
		logger.info("clica no link de Buscar Cálculo");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sprite-abrir")));
		driver.findElement(By.className("sprite-abrir")).click();

		return new Nova_Pesquisa(driver);
	}

	public boolean resultado(String resultado_Esperado) {

		logger.info("verifica se existem resultados na listagem");

		// espera que o elemento esteja visivel
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formulario:panelListagem")));
		return driver.getPageSource().contains(resultado_Esperado);

	}
}
