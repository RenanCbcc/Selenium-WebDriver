package incluir_requisicao_pagamento_beneficiario;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class Teste_Inclui_Beneficiario {
	private final static Logger logger = Logger.getLogger(Teste_Inclui_Beneficiario.class.getCanonicalName());
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

	@Ignore
	public void UC002_CT002_PD002_1()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("30000/2016", "0128300-28.2008.5.08.0009").preencher("557.353.606-04","nome_Benficiario","1950",
							false
							,"1.000,00","100,00","100,00","100,00" 
							,"Observacao");

			assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}
			
	}
	
	@Test
	public void UC002_CT002_PD002_2()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("00065/2009", "0147300-54.2007.5.08.0201").preencher("303.492.832-73","nome_Benficiario","1950",
							false
							,"1.000,00","100,00","100,00","100,00" 
							,"Observacao");

			assertTrue(pagina.resultado("Erro: Beneficiário informado já está cadastrado como Procurador. Operação não permitida."));
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}
			
	}

	@Test
	public void UC002_CT002_PD002_3()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("30000/2016", "0128300-28.2008.5.08.0009").preencher("303.492.832-73","Teste Case"
							,"1.000,00","100,00","100,00","100,00" 
							,"Observacao");

			assertTrue(pagina.resultado("Erro: Beneficiário informado já está cadastrado como Executado. Operação não permitida."));
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}
			
	}

	@Test
	public void UC002_CT002_PD002_5()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("00065/2009", "0147300-54.2007.5.08.0201").preencher("909.882.642-34","nome_Benficiario","1950",
							false
							,"1.000,00","100,00","100,00","100,00" 
							,"Observacao");

			assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um benefício cadastrado para este CPF."));
			} 

		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); }
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);}
			
	}

	@Test
	public void UC002_CT002_PD002_0()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("30000/2016", "0128300-28.2008.5.08.0009").preencher("87.536.154/0001-80","Teste Case"
							,"1.000,00","100,00","100,00","100,00" 
							,"Observacao");

			assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
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
