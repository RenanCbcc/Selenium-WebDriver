package listar_ordem_interna;

import java.util.List;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Teste_Lista {
	

	/**
	 * 
	 * @param List
	 *            processo [Devedor, Executado,Gerar Lista de Prioridades?,Gerar
	 *            Lista de Ordem Cronológica?, Informar ano de vencimento?]
	 * 
	 * @param List
	 *            beneficiario [todos os dados]
	 * @throws InterruptedException
	 * 
	 */
	public static boolean listar(List<String> processo, List<String> beneficiario, WebDriver driver)
			throws InterruptedException, NoSuchElementException, ElementNotVisibleException,
			ElementNotSelectableException {

		Pagina pagina = new Pagina(driver);
		pagina.novo().preencher(processo);

		return pagina.resultado(beneficiario);

	}

}
