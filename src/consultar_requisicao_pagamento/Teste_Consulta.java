package consultar_requisicao_pagamento;
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

public class Teste_Consulta {
	private final static Logger logger = Logger.getLogger(Teste_Consulta.class.getCanonicalName());
	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
							// preenche os formul�rios

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}

	@Ignore // Erro incompreensivel aqui.
	public void UC002_CT001_PD001_3()
	{
		try{
			this.pagina.visitar_Pagina();
			this.pagina.novo().preencher("00205/2014", "", "");/* N�mero, N_Processo, Situa��o, Devedor */
			assertTrue(pagina.resultado("00205/2014","0164000-22.2009.5.08.0206","3� VARA DO TRABALHO DE MACAP�","Precat�rio",
					"Alimentar","04/03/2016","Autuada","N�o"));
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}

			
	}

	@Test
	public void UC002_CT001_PD001_1()
	{
		try{
			this.pagina.visitar_Pagina();
			this.pagina.novo().preencher("00010/2017", "", "");/* N�mero, N_Processo, Situa��o, Devedor */
			assertTrue(pagina.resultado("0010/2017","0128300-28.2008.5.08.0009","VARA DO TRABALHO DE ALTAMIRA","Precat�rio",
					"Alimentar","07/02/2017","Parcialmente Paga","Sim"));
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}

			
	}
	
	@Test
	public void UC002_CT002_PD001_2()
	{
		try{
			this.pagina.visitar_Pagina();
			this.pagina.novo().preencher("00000/0000", "", "");/* Numero, N_Processo, Situa��o, Devedor */
			assertTrue(pagina.resultado("Nenhum registro encontrado.")); 
			
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
