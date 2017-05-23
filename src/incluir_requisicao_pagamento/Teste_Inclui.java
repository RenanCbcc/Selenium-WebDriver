package incluir_requisicao_pagamento;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import gep_pagamento_auxiliary.Documents;

import static org.junit.Assert.assertTrue;
import incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario;
import incluir_requisicao_pagamento_terceiro_interessado.Teste_Inclui_Terceiros_Interessados;

/**
 * This class implements one of the scenarios of test case described in
 * 'Maintain Payment Requisition'
 * 
 * @author Renan Thiago
 * @version 1.0
 * @since 15-03-2017
 */
public class Teste_Inclui {

	private WebDriver driver;
	private Pagina pagina;

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
	public void UC002_CT002_PD002_1() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00001/2017", "0000006-55.2008.5.08.0009", "Precatório",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT002_PD002_1",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "448.985.451-06");

		// assertTrue(pagina.resultado("Operação Realizada com Sucesso"));

	}

	@Ignore
	public void UC002_CT002_PD002_2() {

		this.pagina.novo().preencher("00001/2017");

		assertTrue(pagina.resultado("Erro: Registro duplicado. Já existe uma RP cadastrada com este número."));

	}

	@Ignore
	public void UC002_CT002_PD002_3() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00002/2017", "0000008-25.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT002_PD002_3",
				/* Datas de Referência */ "01/01/2016", "01/02/2016", "01/01/2016", "01/01/2016", "01/01/2016",
				"01/01/2016"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "557.353.606-04");

		assertTrue(pagina.resultado(
				"Erro: Data inválida. A Data de recebimento do ofício no protocolo deve ser maior que a Data do trânsito em julgado do processo de conhecimento."));

	}

	@Ignore
	public void UC002_CT002_PD002_4() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00002/2017", "0000008-25.2008.5.08.0009", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT002_PD002_4",
				/* Datas de Referência */ "01/01/2016", "08/11/2016", "09/12/2016", "10/01/2017", "11/02/2017",
				"12/03/2017"
				/* Dados do Executado */ , "34.621.748/0001-23", "UNIVERSIDADE FEDERAL DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "052.430.784-92");

		Teste_Inclui_Beneficiario.incluir_Beneficiario(this.driver, "Pessoa Física", "357.579.517-70", "Nemo", "1950",
				false, "1.000,00", "100,00", "100,00", "100,00", "Per aspera ad astra");

		Thread.sleep(2000);
		System.out.println("Aba Processos");
		driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).sendKeys("357.579.517-70");
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt170']")).click();

		assertTrue(pagina
				.resultado("Erro: Procurador informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD002_5() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00003/2017", "0000008-25.2008.5.08.0009", "Precatório",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_5",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "448.985.451-06");

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='tabGeral:inCnpjExec']")).clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCnpjExec']")).sendKeys("34.621.748/0001-23");
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt149']")).click();
		System.out.println("Preenchendo ou nao Dados do Executado");
		assertTrue(pagina
				.resultado("Erro: Executado informado já está cadastrado como Beneficiário. Operação não permitida."));

	}

	// TODO Is necessary fix the use case 'Include a Lawyer'
	@Test
	public void UC002_CT003_PD002_6() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00006/2017", "0109400-24.2004.5.08.0013", "RPV",
				"Alimentar", "VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_6",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "01.175.497/0001-41", "AGENCIA BRASILEIRA DE INTELIGENCIA-ABIN/GSI/PR", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "874.816.504-20");

		Teste_Inclui_Beneficiario.incluir_Beneficiario(this.driver, "Pessoa Jurídica", "34.621.748/0001-23", "UFPA",
				"1.000,00", "100,00", "100,00", "100,00", "Per aspera ad astra");
		
		
		String cpf = Documents.getCPF();
		//Guarantees that CPF has not been previously registered.
		Teste_Inclui_Beneficiario.incluir_Advogado(this.driver, cpf,"Helene Corina Alexandra","PA","00000","Advogado");

		Thread.sleep(2000);
		System.out.println("Aba Processos");
		driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).sendKeys(cpf);
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt170']")).click();

		assertTrue(pagina
				.resultado("Erro: Procurador informado já está cadastrado como Advogado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD002_7() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00004/2017", "0109400-24.2004.5.08.0013", "RPV", "Comum",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_7",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "05.054.945/0001-00", "ESTADO DO PARA", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		Teste_Inclui_Terceiros_Interessados.incluir_Terceiro_Interessado(driver, "terceiro", "Honorários Periciais",
				"Pessoa Física", "520.153.602-63", "Paulo Sergio Costa da Silva ", "10.000,00", "3.000,00",
				"Per aspera ad astra");

		// Click at process tab again.
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCpfProc']")).sendKeys("520.153.602-63");
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt170']")).click();
		assertTrue(pagina.resultado(
				"Erro: Procurador informado já está cadastrado como Terceiro Interessado. Operação não permitida."));

	}

	@Ignore
	public void UC002_CT003_PD002_8() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00005/2017", "0109400-24.2004.5.08.0013", "RPV", "Comum",
				"VARA DO TRABALHO DE ALTAMIRA", "Test Case UC002_CT003_PD002_8",
				/* Datas de Referência */ "01/01/2016", "08/10/2016", "09/10/2016", "10/10/2016", "11/10/2016",
				"12/10/2016"
				/* Dados do Executado */ , "04.902.979/0001-44", "BANCO DA AMAZONIA S.A. (BASA)", "Federal", "Administração Direta"
				/* Dados do Devedor */ , "UNIVERSIDADE FEDERAL DO PARA - 34.621.748/0001-23", "Regra Geral"
				/* Dados do procurador */ , "303.492.832-73");

		Teste_Inclui_Terceiros_Interessados.incluir_Terceiro_Interessado(driver, "terceiro", "Honorários Periciais",
				"Pessoa Jurídica", "82.863.545/0001-96", "Weyland-Yutani Corporation", "10.000,00", "3.000,00",
				"Per aspera ad astra");

		// Click at process tab again.
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral']/ul/li[1]/a")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCnpjExec']")).clear();
		driver.findElement(By.xpath(".//*[@id='tabGeral:inCnpjExec']")).sendKeys("82.863.545/0001-96");
		driver.findElement(By.xpath(".//*[@id='tabGeral:j_idt149']")).click();
		System.out.println("Preenchendo ou nao Dados do Executado");

		assertTrue(pagina.resultado(
				"Erro: Executado informado já está cadastrado como Terceiro Interessado. Operação não permitida"));

	}

	@Ignore
	public void UC002_CT003_PD002_9() throws NoSuchElementException, ElementNotVisibleException, TimeoutException,
			WebDriverException, InterruptedException {

		/* Dados do Proceso */ this.pagina.novo().preencher("00007/2017", "0000008-18.2011.5.12.0000");

		assertTrue(pagina.resultado("Erro: Campo inválido: Nº do Processo."));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
