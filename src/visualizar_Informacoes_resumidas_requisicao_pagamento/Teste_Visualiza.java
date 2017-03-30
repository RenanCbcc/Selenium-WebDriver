package visualizar_Informacoes_resumidas_requisicao_pagamento;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;

public class Teste_Visualiza {
	private final static Logger logger = Logger.getLogger(Teste_Visualiza.class.getCanonicalName());
	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
							// preenche os formulários

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}


	@Test
	public void UC002_CT001_PD001_1()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo().preencher("00002/2016", "0021700-91.2006.5.08.0125");/* Número, N_Processo, Situação, Devedor */
			assertTrue(this.pagina.resultado("0010/2017","0128300-28.2008.5.08.0009","VARA DO TRABALHO DE ALTAMIRA","Precatório",
					"Alimentar"));		
				
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}

			
	}
	
	@Ignore
	public void UC002_CT002_PD001_2()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo().preencher("00282/2009", "0071200-63.2004.5.08.0201");/* Numero, N_Processo, Situação, Devedor */
			assertTrue(this.pagina.resultado("0010/2017","0109400-24.2004.5.08.0013","1ª VARA DO TRABALHO DE MACAPÁ","Precatório",
					"Alimentar"));
 
			
		}
		
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}

	}
	
	
	
	@After
	public void fechar() {
		driver.close();
	}
	
	
}
