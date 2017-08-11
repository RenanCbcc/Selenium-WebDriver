package alterar_requisicao_pagamento_beneficiario;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import consultar_requisicao_pagamento.Teste_Consulta;

public class Teste_Altera_Beneficiario {

	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("overlappingCheckDisabled", true);
		this.driver = new FirefoxDriver(capabilities);
		this.pagina = new Pagina(driver);
	}

	@Test
	public void UC002_CT008_PD002_1() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");

		}
		this.pagina.novo("Beneficiario").preencher("Não", "", "1.000,00", "100,00", "100,00", "100,00", "Hello World!");

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	@Test
	public void UC002_CT008_PD002_2() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");
		}

		this.pagina.novo("Beneficiario").preencher("", "", "1.000,00", "100,00", "100,00", "100,00", "Hello World!");

		assertTrue(pagina.resultado("Campo Obrigatório: Foi deferido o benefício de prioridade processual?."));

	}

	@Test
	public void UC002_CT008_PD002_3() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("404 Process not found");
		}

		this.pagina.novo("Beneficiario").preencher("Sim","","1.000,00", "100,00", "100,00", "100,00", "Hello World!");

		assertTrue(pagina.resultado("Campo Obrigatório: Tipo de Prioridade."));
	}

	@Test
	public void UC002_CT008_PD002_4() throws TimeoutException, InterruptedException {
		if (!Teste_Consulta.consultar("00001/2018", "Não", this.driver)) {
			fail("Processo nao pode ser alterado");
		}
		this.pagina.novo("Beneficiario").preencher("Não", "", "0", "0", "0", "0", "Hello World!");
		assertTrue(
				pagina.resultado("Erro: O valor total do benefício deve ser maior que zero. Operação não permitida."));

	}


	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}
}
