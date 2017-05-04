package incluir_requisicao_pagamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.junit.Assert.assertTrue;

public class Teste_Inclui {

	private WebDriver driver;
	private Pagina pagina; // esta classe visita a pagina de consulta e
	// preenche os formulários

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		//capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(this.driver);

	}

	@Test
	public void UC002_CT002_PD002_1() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0000006-55.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina
				.resultado("Erro: org.hibernate.exception.ConstraintViolationException: could not execute statement"));

	}

	@Ignore
	public void UC002_CT002_PD002_2() {

		this.pagina.novo().preencher("00010/2017");

		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe uma RP cadastrada com este número."));

	}

	@Ignore
	public void UC002_CT002_PD002_3() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0000008-25.2008.5.08.0009", "RPV",
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
	public void UC002_CT002_PD002_4() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0000008-25.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/11/2016", "09/12/2016", "10/01/2017", "11/02/2017",
				"12/03/2017"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "052.430.784-92");

		assertTrue(
				pagina.resultado("Procurador informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD002_5() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00254/2017", "0000008-25.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "01.175.497/0001-41");

		assertTrue(pagina
				.resultado("Erro: Executado informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD002_6() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0000008-25.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		assertTrue(pagina
				.resultado("Erro: Procurador informado já está cadastrado como Advogado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD002_7() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0109400-24.2004.5.08.0013", "RPV",
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
	public void UC002_CT003_PD002_8() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44", "BANCO DA AMAZONIA S.A. (BASA)", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		assertTrue(pagina.resultado(
				"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

	}

	@Ignore
	public void UC002_CT003_PD002_9() {

		/* Dados do Proceso */ this.pagina.novo().preencher("00214/2017", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Teste case",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44", "BANCO DA AMAZONIA S.A. (BASA)", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		assertTrue(pagina.resultado(
				"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
