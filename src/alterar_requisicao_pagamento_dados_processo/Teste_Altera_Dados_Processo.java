package alterar_requisicao_pagamento_dados_processo;
import consultar_requisicao_pagamento.Teste_Consulta;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Teste_Altera_Dados_Processo {

	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		//capabilities.setCapability("overlappingCheckDisabled", true);
		driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(driver);
	}

	@Test // Erro no GEP
	public void UC002_CT003_PD003_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {
		
		
		if (!Teste_Consulta.consultar("00000/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
	

		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0001414-43.2015.5.08.0007", "Precatório",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	@Ignore 
	public void UC002_CT003_PD003_2() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("00010/2017");

		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe uma RP cadastrada com este número."));

	}

	@Ignore // Erro no GEP
	public void UC002_CT003_PD003_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "01/01/2016", "01/01/2016", "01/01/2016", "01/01/2016",
				"01/01/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Data inválida. A Data do ajuizamento do processo de conhecimento deve ser menor que a Data do trânsito em julgado do processo de conhecimento."));

	}

	@Ignore
	public void UC002_CT003_PD003_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "071.275.546-25");

		assertTrue(
				pagina.resultado("Procurador informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD003_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/2017", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		/* Dados do Proceso */ this.pagina.novo().preencher("00000/2017", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41");

		assertTrue(pagina
				.resultado("Erro: Executado informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD003_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ ,"34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "341.594.602-91");

		assertTrue(pagina
				.resultado("Erro: Procurador informado já está cadastrado como Advogado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD003_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		assertTrue(pagina.resultado(
				"Erro: Procurador informado já está cadastrado como Terceiro Interessado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD003_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44");

		assertTrue(pagina.resultado(
				"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

	}

	@Ignore
	public void UC002_CT003_PD003_9() throws NoSuchElementException, ElementNotVisibleException, TimeoutException, WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		/* Dados do Proceso */ this.pagina.novo().preencher("00000/0000", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44");

		assertTrue(pagina.resultado(
				"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

	}

	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}

}
