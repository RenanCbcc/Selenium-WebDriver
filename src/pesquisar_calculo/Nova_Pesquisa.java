package pesquisar_calculo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.logging.*;

// Esta clase faz o preenchimento do formulario de buscas e os submete.
public class Nova_Pesquisa {
	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(Nova_Pesquisa.class.getCanonicalName());

	public Nova_Pesquisa(WebDriver driver) {
		this.driver = driver;

	}

	public void preenche(String tipo, String situacao, String numero, String digito, String ano, 
			String justica,String tribunal,String vara, String n_calculo,String reclamante, String reclamado, boolean setor) 
					throws NoSuchElementException {
		
		// 1ª linha
		Select campo_Situacao = new Select(driver.findElement(By.id("formulario:situacaoCalculoBusca")));
		Select campo_tipo = new Select(driver.findElement(By.id("formulario:tipoCalculoBusca")));
		WebElement campo_numero = driver.findElement(By.id("formulario:numeroProcessoBusca"));
		WebElement campo_digito = driver.findElement(By.id("formulario:digitoProcessoBusca"));
		WebElement campo_ano = driver.findElement(By.id("formulario:anoProcessoBusca"));
		WebElement campo_justica = driver.findElement(By.id("formulario:justicaBusca"));
		WebElement campo_tribunal = driver.findElement(By.id("formulario:regiaoBusca"));
		WebElement campo_vara = driver.findElement(By.id("formulario:varaProcessoBusca"));
		// 2ª linha
		WebElement campo_reclamante = driver.findElement(By.id("formulario:reclamanteBusca"));
		WebElement campo_reclamado = driver.findElement(By.id("formulario:reclamadoBusca"));
		WebElement campo_n_calculo = driver.findElement(By.id("formulario:numeroCalculoBusca"));

		if (setor) { // Se true, então click.
			WebElement checkBox = driver.findElement(By.id("formulario:setor"));
			checkBox.click();
		}
		
		logger.info("Preenchendo ou nao campo Tipo");
		campo_tipo.selectByVisibleText(tipo);

		logger.info("Preenchendo ou nao campo Situacao");
		campo_Situacao.selectByVisibleText(situacao);

		
		logger.info("Preenchendo ou nao campo Numero");
		campo_numero.sendKeys(numero);

		logger.info("Preenchendo ou nao campo Digito");
		campo_digito.sendKeys(digito);

		logger.info("Preenchendo ou nao campo Ano");
		campo_ano.sendKeys(ano);

		logger.info("Preenchendo ou nao campo Justica");
		campo_justica.sendKeys(justica);
		
		logger.info("Preenchendo ou nao campo Tribunal");
		campo_tribunal.sendKeys(tribunal);
		
		
		logger.info("Preenchendo ou nao campo Justica");
		campo_vara.sendKeys(vara);
		
		logger.info("Preenchendo ou nao campo Reclamante");
		campo_reclamante.sendKeys(reclamante);

		logger.info("Preenchendo ou nao campo Reclamado");
		campo_reclamado.sendKeys(reclamado);

		logger.info("Preenchendo ou nao campo Calculo");
		campo_n_calculo.sendKeys(n_calculo);

		logger.info("Buscando...");
		driver.findElement(By.name("formulario:buscar")).click();

	}

}
