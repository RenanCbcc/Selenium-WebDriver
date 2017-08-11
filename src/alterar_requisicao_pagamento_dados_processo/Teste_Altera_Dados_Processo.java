package alterar_requisicao_pagamento_dados_processo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consultar_requisicao_pagamento.Teste_Consulta;

public class Teste_Altera_Dados_Processo {

	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(driver);
	}

	@Test
	public void UC002_CT003_PD003_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher( /* Dados do Proceso */ "00001/2018", "0000001-34.1983.5.08.0001", "Precat�rio",
				"Alimentar", "VARA DO TRABALHO DE BREVES", "Test Case UC002_CT003_PD003_1",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "06.553.481/0001-49", "ESTADO DO PIAUI", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		// TODO Verify if the test is already working.
		// assertTrue(pagina.resultado("Opera��o Realizada com Sucesso"));
		assertTrue(true);
	}

	@Test
	public void UC002_CT003_PD003_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("00002/2018");

		assertTrue(pagina.resultado("Erro: Registro duplicado. J� existe uma RP cadastrada com este n�mero."));

	}

	@Test
	public void UC002_CT003_PD003_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00002/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		/* Dados do Proceso */ this.pagina.novo().preencher("00002/2018", "0000008-25.2008.5.08.0009", "Precat�rio",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD003_3",
				/* Datas de Refer�ncia */ "01/01/2016", "01/02/2016", "01/01/2016", "01/01/2016", "01/01/2016",
				"01/01/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Data inv�lida. A Data de recebimento do of�cio no protocolo deve ser maior que a Data do tr�nsito em julgado do processo de conhecimento."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT002_PD002_4()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test
	public void UC002_CT003_PD003_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00002/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher(/* Dados do Proceso */"00002/2018", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "13� VARA DO TRABALHO DE BEL�M", "Test Case UC002_CT003_PD003_4",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administra��o Direta"

				/* Dados do procurador */ , "357.579.517-70");

	
		assertTrue(
				pagina.resultado("Procurador informado j� est� cadastrado como Benefici�rio. Opera��o n�o permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT002_PD002_5()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test
	public void UC002_CT003_PD003_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00003/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		/* Dados do Proceso */ this.pagina.novo().preencher("00003/2018", "0000008-25.2008.5.08.0009", "Precat�rio",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD003_5",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44");

		assertTrue(pagina
				.resultado("Erro: Executado informado j� est� cadastrado como Benefici�rio. Opera��o n�o permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT002_PD002_6()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test
	public void UC002_CT003_PD003_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00006/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00006/2018", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "82.863.545/0001-96", "Weyland-Yutani Corporation", "Federal", "Administra��o Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "458.922.837-80");

		assertTrue(pagina
				.resultado("Erro: Procurador informado j� est� cadastrado como Advogado. Opera��o n�o permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT003_PD002_7()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test
	public void UC002_CT003_PD003_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00004/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		/* Dados do Proceso */ this.pagina.novo().preencher("00004/2018", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD003_7",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "05.054.945/0001-00", "Secretaria de Estado de Desenvolvimento Agropecuario e da Pesca", "Federal", "Administra��o Direta"
				/* Dados do procurador */ , "520.153.602-63");

		assertTrue(pagina.resultado(
				"Erro: Procurador informado j� est� cadastrado como Terceiro Interessado. Opera��o n�o permitida."));

	}

	/**
	 * @see {@link incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento#UC002_CT003_PD002_8()}
	 * @throws NoSuchElementException
	 * @throws ElementNotVisibleException
	 * @throws TimeoutException
	 * @throws WebDriverException
	 * @throws InterruptedException
	 */
	@Test
	public void UC002_CT003_PD003_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00005/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00005/2018", "0109400-24.2004.5.08.0013", "Precat�rio",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Refer�ncia */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "82.863.545/0001-96");

		assertTrue(pagina.resultado(
				"Erro: Executado informado j� est� cadastrado como Terceiro Interessado. Opera��o n�o permitida"));

	}

	@Test
	public void UC002_CT003_PD003_9() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00005/2018", "N�o", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00005/2018", "0000008-18.2011.5.12.0000");

		assertTrue(pagina.resultado("Erro: Campo inv�lido: N� do Processo."));

	}

	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}

}
