package visualizar_requisicao_pagamento;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import consultar_requisicao_pagamento.Teste_Consulta;

public class Teste_Visualizar_Requisicao_Pagamento {
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
	public void UC002_CT0012_PD0012_1() throws TimeoutException, InterruptedException {

		if (!Teste_Consulta.consultar("00005/2017", "Sim", this.driver)) {
			fail("Processo nao pode ser alterado");

		}

		this.pagina.novo();
		assertTrue(pagina.resultado(Arrays.asList(/* Dados do Processo */"00005/2017", "0109400-24.2004.5.08.0013",
				"RPV", "Alimentar", "13ª VARA DO TRABALHO DE BELÉM", "Test Case UC002_CT003_PD002_8",
				/* Datas de Referência */"13/04/2009", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016", /* Dados do Executado */"04.902.979/0001-44", "BANCO DA AMAZONIA SA", "Federal",
				"Administração Direta", /* Dados do Procurador */ "303.492.832-73", "Luisa Valerie Chesley",
				/* Dados Ente Devedor */ "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral",
				/* Beneficiários */"Weyland-Yutani Corporation.", "82.863.545/0001-96", "Não", "12.000,00",
				"Pessoa Jurídica", "82.863.545/0001-96", "Weyland-Yutani Corporation.", /* Valor (R$) */ "9.000,00",
				"0,00", "0,00", "3.000,00", /* Observação */ "Per aspera ad astra",
				/* Total Requisitado Beneficiários */"9.000,00", "0,00", "3.000,00", "12.000,00",
				/* Advogados  "BAPTISTE KYOSTI TIMOTHE", "557.353.606-04", "DF00000S", "Weyland-Yutani Corporation."*/
				/* Terceiros Interessados */"Tyrell Corporation Inc.", "88.741.750/0001-65","", "Honorários Periciais","11.000,00",
				/* Visualização do Terceiro Interessado */ "Honorários Periciais", "Pessoa Jurídica", "88.741.750/0001-65",
				"Tyrell Corporation Inc.", /* Valor (R$) */ "1.000,00", "10.000,00", /* Observação */ "Faber est quisque tortunae suae",
				/* Total Requisitado */ "12.000,00", "11.000,00", "23.000,00")));

	}

	@After
	public void fechar() {
		driver.close();
	}

}
