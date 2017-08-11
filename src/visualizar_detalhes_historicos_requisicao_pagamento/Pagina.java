package visualizar_detalhes_historicos_requisicao_pagamento;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import gep_pagamento_auxiliary.Helper;

public class Pagina {
	private WebDriver driver;
	Wait<WebDriver> fluentwait;
	private final static Logger logger = Logger.getLogger(Pagina.class.getCanonicalName());

	public Pagina(WebDriver driver) {
		this.driver = driver;
		fluentwait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class)
				.ignoring(ElementNotVisibleException.class);

	}

	public Preenche novo() throws NoSuchElementException, ElementNotVisibleException, TimeoutException {

		Helper.pageSearcher(this.driver);
		logger.info("Aguardando....");
		fluentwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='tblRequisicoes']/div[1]")));

		return new Preenche(driver);
	}

	public boolean resultado(String Numero, String Nº_Processo, String Tipo_Requisição, String Natureza_Credito,
			String Vara_Origem, String Situacao, String Situacao_calculos, String data_envio, String data_recebmento,
			String data_atualizacao, String resp_atualizacao, String lista_beneficiarios, String doc_fical,
			String prioridade, String data_atualizacao_beneficiario) throws TimeoutException {

		String[] args = { Numero, Nº_Processo, Tipo_Requisição, Natureza_Credito, Vara_Origem, Situacao,
				Situacao_calculos, data_envio, data_recebmento, data_atualizacao, resp_atualizacao, lista_beneficiarios,
				doc_fical, prioridade, data_atualizacao_beneficiario };

		List<String> aux = new ArrayList<String>();

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='dlgInformacoesRequisicaoPagamento_title']"),
				"Mais informações da Requisição de Pagamento"));

		logger.info("verifica se existem resultados na listagem");

		{
			try {
				fluentwait.until(ExpectedConditions
						.textToBePresentInElementLocated(By.xpath(".//*[@id='tblRequisicoes_data']/tr/td[1]"), Numero));
			} catch (TimeoutException toe) {
				print("Numero de RP diferentes, prosseguindo");
			}

		}

		for (int i = 1; i <= 4; i++) {

			aux.add(driver.findElement(By.xpath(".//*[@id='j_idt123']/tbody/tr[" + i + "]/td[2]")).getText());

			aux.add(driver.findElement(By.xpath(".//*[@id='tblBeneficiosAtualizacao_data']/tr/td[" + i + "]"))
					.getText());
		}

		for (int i = 1; i <= 2; i++) {

			aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[" + i + "]/td[2]")).getText());
			aux.add(driver.findElement(By.xpath(".//*[@id='j_idt123']/tbody/tr[" + i + "]/td[4]")).getText());
		}

		aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[3]/td[2]")).getText());
		aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[2]/td[4]")).getText());
		aux.add(driver.findElement(By.xpath(".//*[@id='j_idt158']/tbody/tr[3]/td[4]")).getText());

		String[] rsut = aux.toArray(new String[args.length]);

		Arrays.sort(args);
		Arrays.sort(rsut);

		for (int i = 0; i < args.length; i++) {
			print(args[i]);
			print(rsut[i]);
		}

		return Arrays.equals(args, rsut);

	}

	/**
	 * Method verifies whether the current information is correct.
	 * 
	 * @param Numero
	 * @param Nº_Processo
	 * @param Tipo_Requisição
	 * @param Natureza_Credito
	 * @param Vara_Origem
	 * @param Situacao
	 * @return boolean
	 * @throws TimeoutException
	 * @throws InterruptedException
	 */
	public boolean resultado(String Numero, String Nº_Processo, String Tipo_Requisição, String Natureza_Credito,
			String Vara_Origem, String Situacao) throws TimeoutException, InterruptedException {

		String[] args = { Numero, Nº_Processo, Tipo_Requisição, Natureza_Credito, Vara_Origem, Situacao, };

		List<String> aux = new ArrayList<String>();

		fluentwait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath(".//*[@id='dlgInformacoesRequisicaoPagamento_title']"),
				"Mais informações da Requisição de Pagamento"));

		logger.info("verifica se existem resultados na listagem");

		aux.addAll(Helper.getTextFromTable("j_idt118"));

		String[] rsut = aux.toArray(new String[args.length]);

		Arrays.sort(args);
		Arrays.sort(rsut);

		for (int i = 0; i < args.length; i++) {
			print(args[i]);
			print(rsut[i]);
		}

		return Arrays.equals(args, rsut);

	}

	public void print(String s) {
		System.out.println(s);
	}

	public void print(boolean s) {
		System.out.println(s);
	}

	public void print(int s) {
		System.out.println(s);
	}

}
