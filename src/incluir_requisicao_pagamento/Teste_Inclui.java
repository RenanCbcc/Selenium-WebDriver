package incluir_requisicao_pagamento;
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

public class Teste_Inclui {
	private Logger logger = Logger.getLogger(Teste_Inclui.class.getCanonicalName());
	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
								// preenche os formulários

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}

	@Test
	public void UC002_CT002_PD002_1()
	{
		try{
			this.pagina.visitar();
/*Dados do Proceso*/		this.pagina.novo().preencher("00000/0000", "0000002-18.2008.5.08.0009","RPV","Alimentar",".//*[@id='tabGeral:cmbVara_panel']/div[2]/ul/li[2]","Teste case",
/*Datas de Referência*/		"01/01/2016","08/10/2016","09/10/2016","10/10/2016","11/10/2016","12/10/2016"
/*Dados do Executado*/		,"34.621.748/0001-23",".//*[@id='tabGeral:cmbEsfera_panel']/div/ul/li[3]",".//*[@id='tabGeral:cmbTpEnte_panel']/div/ul/li[2]"
/*Dados do Devedor*/		,".//*[@id='tabGeral:cmbDevedor_panel']/div/ul/li[4]",".//*[@id='tabGeral:cmbLegislacao_panel']/div/ul/li[2]" 
/*Dados do procurador*/		,"557.353.606-04");

			assertTrue(pagina.resultado("Erro: org.hibernate.exception.ConstraintViolationException: could not execute statement"));
			} 

		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
			
	}
	
	
	@Test
	public void UC002_CT002_PD002_2()
	{
		try{
			this.pagina.visitar();
			this.pagina.novo().preencher("00010/2017");
			
			assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe uma RP cadastrada com este número.")); 
			
		}
		
		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
		
	}
	
	@Test
	public void UC002_CT002_PD002_3()
	{
		try{
			this.pagina.visitar();
			/*Dados do Proceso*/		this.pagina.novo().preencher("00000/0000", "0000002-18.2008.5.08.0009","RPV","Alimentar",".//*[@id='tabGeral:cmbVara_panel']/div[2]/ul/li[2]","Teste case",
			/*Datas de Referência*/		"01/01/2016","01/09/2016","01/10/2016","10/10/2016","11/10/2016","12/10/2016"
			/*Dados do Executado*/		,"34.621.748/0001-23",".//*[@id='tabGeral:cmbEsfera_panel']/div/ul/li[3]",".//*[@id='tabGeral:cmbTpEnte_panel']/div/ul/li[2]"
			/*Dados do Devedor*/		,".//*[@id='tabGeral:cmbDevedor_panel']/div/ul/li[4]",".//*[@id='tabGeral:cmbLegislacao_panel']/div/ul/li[2]" 
			/*Dados do procurador*/		,"557.353.606-04");

						assertTrue(pagina.resultado("Erro: Data inválida. A Data do ajuizamento do processo de conhecimento deve ser menor que a Data do trânsito em julgado do processo de conhecimento."));

			
		}
		
		catch (InvalidSelectorException ise){ logger.log(Level.SEVERE, ise.getMessage(), ise);assertTrue(false);}
		catch (NoSuchElementException nsee){ logger.log(Level.SEVERE, nsee.getMessage(), nsee); assertTrue(false);}
		catch (NotFoundException nfe){ logger.log(Level.SEVERE, nfe.getMessage(), nfe);assertTrue(false);}
		catch (ElementNotVisibleException enve){ logger.log(Level.SEVERE, enve.getMessage(), enve);assertTrue(false);}
		catch (TimeoutException toe){ logger.log(Level.SEVERE, toe.getMessage(), toe);assertTrue(false);}
		catch (WebDriverException ede){ logger.log(Level.SEVERE, ede.getMessage(), ede);assertTrue(false);}
		
	}
	
	
	@Ignore
	public void UC002_CT002_PD002_4()
	{
		try{
			this.pagina.visitar();
			/*Dados do Proceso*/		this.pagina.novo().preencher("00000/0000", "0000002-18.2008.5.08.0009","RPV","Alimentar",".//*[@id='tabGeral:cmbVara_panel']/div[2]/ul/li[2]","Teste case",
			/*Datas de Referência*/		"01/01/2016","01/09/2016","01/10/2016","10/10/2016","11/10/2016","12/10/2016"
			/*Dados do Executado*/		,"34.621.748/0001-23",".//*[@id='tabGeral:cmbEsfera_panel']/div/ul/li[3]",".//*[@id='tabGeral:cmbTpEnte_panel']/div/ul/li[2]"
			/*Dados do Devedor*/		,".//*[@id='tabGeral:cmbDevedor_panel']/div/ul/li[4]",".//*[@id='tabGeral:cmbLegislacao_panel']/div/ul/li[2]" 
			/*Dados do procurador*/		,"557.353.606-04");

						assertTrue(pagina.resultado(" Procurador informado já está cadastrado como Beneficiário. Operação não permitida."));

			
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
