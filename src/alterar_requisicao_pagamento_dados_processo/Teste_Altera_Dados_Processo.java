package alterar_requisicao_pagamento_dados_processo;

import consultar_requisicao_pagamento.Teste_Consulta;
import static org.junit.Assert.assertTrue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Teste_Altera_Dados_Processo {
	private Logger logger = Logger.getLogger(Teste_Altera_Dados_Processo.class.getCanonicalName());
	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);

	}

	@Test
	public void UC002_CT003_PD002_1() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0000002-18.2008.5.08.0009", "Precatório",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "557.353.606-04");

			assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_2() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			this.pagina.novo().preencher("00010/2017");

			assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe uma RP cadastrada com este número."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	// *****************************Revisar TODOS os caso de teste
	// abaixo*****************************//
	@Ignore
	public void UC002_CT003_PD002_3() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "01/09/2016", "01/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "557.353.606-04");

			assertTrue(pagina.resultado(
					"Erro: Data inválida. A Data do ajuizamento do processo de conhecimento deve ser menor que a Data do trânsito em julgado do processo de conhecimento."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_4() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "071.275.546-25");

			assertTrue(pagina
					.resultado("Procurador informado já está cadastrado como Beneficiário. Operação não permitida."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_5() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "071.275.546-25");

			assertTrue(pagina.resultado(
					"Erro: Executado informado já está cadastrado como Beneficiário. Operação não permitida."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_6() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "303.492.832-73");

			assertTrue(pagina
					.resultado("Erro: Procurador informado já está cadastrado como Advogado. Operação não permitida."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_7() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "303.492.832-73");

			assertTrue(pagina.resultado(
					"Erro: Procurador informado já está cadastrado como Terceiro Interessado. Operação não permitida."));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_8() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "04.902.979/0001-44", "BANCO DA AMAZONIA S.A. (BASA)", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "303.492.832-73");

			assertTrue(pagina.resultado(
					"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@Ignore
	public void UC002_CT003_PD002_9() {
		try {

			assertTrue(Teste_Consulta.consultar("00254/2009", "Não", this.driver));
			this.pagina = new Pagina(this.driver);

			/* Dados do Proceso */ this.pagina.novo().preencher("00254/2009", "0109400-24.2004.5.08.0013", "RPV",
					"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
					/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
					"12/10/2016"
					/* Dados do Executado */ , "04.902.979/0001-44", "BANCO DA AMAZONIA S.A. (BASA)", "Federal", "Administração Direta"
					/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
					/* Dados do procurador */ , "303.492.832-73");

			assertTrue(pagina.resultado(
					"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

		}

		catch (InvalidSelectorException ise) {
			logger.log(Level.SEVERE, ise.getMessage(), ise);
			assertTrue(false);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, nsee.getMessage(), nsee);
			assertTrue(false);
		} catch (NotFoundException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			assertTrue(false);
		} catch (ElementNotVisibleException enve) {
			logger.log(Level.SEVERE, enve.getMessage(), enve);
			assertTrue(false);
		} catch (TimeoutException toe) {
			logger.log(Level.SEVERE, toe.getMessage(), toe);
			assertTrue(false);
		} catch (WebDriverException ede) {
			logger.log(Level.SEVERE, ede.getMessage(), ede);
			assertTrue(false);
		}

	}

	@After
	public void fechar() {
		driver.close();
	}

}
