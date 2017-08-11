package finalizar_cadastro;

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

public class Teste_Finalizar_Cadastro {

	private WebDriver driver;
	private Pagina pagina;

	@Before
	public void inicialize() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		this.driver = new FirefoxDriver(capabilities);

		this.pagina = new Pagina(this.driver);
	}

	@Test
	public void UC002_CT011_PD011_1() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00001/2017", "Não", this.driver)) {
			fail("Error 404: Precess not found");

		}

		this.pagina.novo();

		assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	@Test
	public void UC002_CT011_PD011_2() throws ElementNotVisibleException, NoSuchElementException, TimeoutException,
			WebDriverException, InterruptedException {

		if (!Teste_Consulta.consultar("00005/2017", "Sim", this.driver)) {
			fail("Error 404: Precess not found");

		}

		this.pagina.novo();

		assertTrue(pagina.resultado(
				"Erro: Não foi possível finalizar o cadastro. É necessário cadastrar pelo menos um beneficiário."));

	}

	@After
	public void fechar() {
		System.out.println("Fechando...");
		driver.close();
	}
}
