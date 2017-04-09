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
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

public class Teste_Inclui_Beneficiario {
	private Logger logger = Logger.getLogger(Teste_Inclui_Beneficiario.class.getCanonicalName());
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
	public void UC002_CT007_PD002_1()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("Beneficiario","00065/2009", "0147300-54.2007.5.08.0201").preencher("357.579.517-70","nome_Benficiario","1950",
							false
							,"1.000,00","100,00","100,00","100,00" 
							,"Observacao");

			assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}
	
	@Ignore
	public void UC002_CT007_PD002_2()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("Beneficiario","00065/2009", "0147300-54.2007.5.08.0201").preencher("303.492.832-73");

			assertTrue(pagina.resultado("Erro: Beneficiário informado já está cadastrado como Procurador. Operação não permitida."));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}

	@Ignore
	public void UC002_CT007_PD002_3()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("Beneficiario","30000/2016", "0128300-28.2008.5.08.0009").preencher("07.954.480/0001-79");

			assertTrue(pagina.resultado("Erro: Beneficiário informado já está cadastrado como Executado. Operação não permitida."));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}

	@Ignore
	public void UC002_CT007_PD002_4()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("Advogado","35138/4313", "0000008-18.2011.5.12.0006").preencher("357.579.517-70");
			assertTrue(pagina.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}

	@Ignore
	public void UC002_CT007_PD002_5()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo("Beneficiario","00065/2009", "0147300-54.2007.5.08.0201").preencher("909.882.642-34");

			assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um benefício cadastrado para este CPF."));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}
	
	@Test
	public void UC002_CT007_PD002_6() 
	{
		try{
			this.pagina.visitar();
		this.pagina.novo("Advogado","00065/2009", "0147300-54.2007.5.08.0201").preencher("557.353.606-04");
			assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe um advogado cadastrado com este CPF."));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}

	
	@After
	public void fechar() {
		driver.close();
	}
}
