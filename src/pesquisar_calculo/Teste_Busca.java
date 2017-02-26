package pesquisar_calculo;
/*Este caso de teste tem como objetivo testar a pesquisa de um c�lculo.
 *(S01) � Pesquisar C�lculo / (E03) � Consulta n�o retornou resultados.
 *Devem ter sido realizados os testes do CT003 (incluir) considerando a planilha de dados PD002 e n�o terem sido
 * realizados os testes do CT004 (excluir) nem o CT005 (alterar). 
 * 
=======Pocedimento do Teste.===========================================================================
[1]  O usu�rio inicia o sistema;
[2]  O sistema apresenta as op��es para Pesquisar C�lculo, Incluir C�lculo e Abrir C�lculo habilitadas;
[3]  O usu�rio seleciona a op��o para Pesquisar C�lculo;
[4]  O sistema exibe a tela de pesquisa de c�lculo;
[5]  O usu�rio preenche os crit�rios de busca conforme planilha de dados PD001;
[6]  O sistema exibe o resultado conforme planilha de dados PD001.
========================================================================================================
 * */

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.NoSuchElementException;
import java.util.logging.*;

public class Teste_Busca {
	private final static Logger logger = Logger.getLogger(Pesquisa.class.getCanonicalName());
	private WebDriver driver;
	private Pesquisa pesquisa; // esta classe visita a pagina de pesquisa e
								// preenche os formul�rios

	@Before
	public void inicilizar() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		this.driver = new FirefoxDriver(capabilities);
		this.pesquisa = new Pesquisa(this.driver);

	}

	@Test
	public void PesquisarCalculo() {
		try {
			// Acessa o site do Pje-Calc
			this.pesquisa.visitar_Pagina();

			// Preenche os formularios
			this.pesquisa.novo().preenche("", "", null, null, null, null, null, null, null, null, null, true);
		}

		catch (NoSuchElementException nsee) {
			logger.log(Level.SEVERE, "Elemento nao Encontrado", nsee.getCause());
		}

		// Verifica se o resutado � verdadeiro
		assertTrue(pesquisa.resultado("Registros encontrados: 795"));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
