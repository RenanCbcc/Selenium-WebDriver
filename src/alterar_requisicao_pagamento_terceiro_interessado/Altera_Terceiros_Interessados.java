package alterar_requisicao_pagamento_terceiro_interessado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import consultar_requisicao_pagamento.Teste_Consulta;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Altera_Terceiros_Interessados {

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
	public void UC002_CT0010_PD0010_1() {

		if (!Teste_Consulta.consultar("33333/3333", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
			this.pagina.novo().preencher("10.000,00", "3.000,00", "Per aspera ad astra");
			assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		
	}

	@Ignore
	public void UC002_CT0010_PD0010_2() {
		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		} else {
			this.pagina.novo().preencher("10.000,00", "3.000,00", "Per aspera ad astra");
			assertTrue(pagina.resultado("Operação Realizada com Sucesso"));
		}

	}

	@Ignore
	public void UC002_CT0010_PD0010_3() {

		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Perícias", "Pessoa Física", "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Procurador. Operação não permitida"));

	}

	@Ignore
	public void UC002_CT0010_PD0010_4() {
		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}
		this.pagina.novo().preencher("Honorários Advocatícios", "", "339.666.538-42");

		assertTrue(pagina
				.resultado("Erro: Advogado informado já está cadastrado como Procurador. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_5() {
		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Perícias", "Pessoa Física", "071.275.546-25");
		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Executado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_6() {
		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Advocatícios", "Pessoa Física", "303.492.832-73");

		assertTrue(pagina.resultado(
				"Erro: Terceiro interessado informado já está cadastrado como Executado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_7() {
		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Perícias", "Pessoa Física", "071.275.546-25");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. Já existe um terceiro interessado cadastrado para este CNPJ."));

	}

	@Ignore
	public void UC002_CT0010_PD0010_8() {
		if (!Teste_Consulta.consultar("00000/0000", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo().preencher("Honorários Perícias", "Pessoa Física", "071.275.546-25");
		assertTrue(pagina
				.resultado("Erro: Registro duplicado. Já existe um terceiro interessado cadastrado para este CNPJ."));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
