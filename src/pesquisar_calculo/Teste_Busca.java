package pesquisar_calculo;
/*Este caso de teste tem como objetivo testar a pesquisa de um cálculo.
 *(S01) – Pesquisar Cálculo / (E03) – Consulta não retornou resultados.
 *Devem ter sido realizados os testes do CT003 (incluir) considerando a planilha de dados PD002 e não terem sido
 * realizados os testes do CT004 (excluir) nem o CT005 (alterar). 
 * 
=======Pocedimento do Teste.===========================================================================
[1]  O usuário inicia o sistema;
[2]  O sistema apresenta as opções para Pesquisar Cálculo, Incluir Cálculo e Abrir Cálculo habilitadas;
[3]  O usuário seleciona a opção para Pesquisar Cálculo;
[4]  O sistema exibe a tela de pesquisa de cálculo;
[5]  O usuário preenche os critérios de busca conforme planilha de dados PD001;
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
								// preenche os formulários

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

		// Verifica se o resutado é verdadeiro
		assertTrue(pesquisa.resultado("Registros encontrados: 795"));

	}

	@After
	public void fechar() {
		driver.close();
	}
}
