package gep_pagamento_auxiliary;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class ExceptionAspect {
	private Logger logger = Logger.getLogger(ExceptionAspect.class.getCanonicalName());

	@AfterThrowing(pointcut = "execution(* alterar_requisicao_pagamento_beneficiario.Teste_Altera_Beneficiario.*(..))", throwing = "error")
	public void afterThrowing_Teste_Altera_Beneficiario(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo.*(..))", throwing = "error")
	public void afterThrowing_Teste_Altera_Dados_Processo(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* alterar_requisicao_pagamento_terceiro_interessado.Teste_Altera_Terceiros_Interessados.*(..))", throwing = "error")
	public void afterThrowing_Teste_Altera_Terceiros_Interessados(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* consultar_requisicao_pagamento.Teste_Consulta.*(..))", throwing = "error")
	public void afterThrowing_Teste_Consulta(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* excluir_requisicao_pagamento.Teste_Exclui.*(..))", throwing = "error")
	public void afterThrowing_Teste_Exclui(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento.*(..))", throwing = "error")
	public void afterThrowing_Teste_incluir_requisicao_pagamento(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario.*(..))", throwing = "error")
	public void afterThrowing_Teste_Inclui_Beneficiario(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* incluir_requisicao_pagamento_terceiro_interessado.Teste_Inclui_Terceiros_Interessados.*(..))", throwing = "error")
	public void afterThrowing_Teste_Inclui_Terceiros_Interessados(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* visualizar_detalhes_historicos_requisicao_pagamento.Teste_Visualiza_Detalhes.*(..))", throwing = "error")
	public void afterThrowing_Teste_Visualiza_Detalhes(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "execution(* visualizar_Informacoes_resumidas_requisicao_pagamento.Teste_Visualiza.*(..))", throwing = "error")
	public void afterThrowing_Teste_Visualiza(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}
	
	@AfterThrowing(pointcut = "execution(* visualizar_requisicao_pagamento.Teste_Visualizar_Requisicao_Pagamento.*(..))", throwing = "error")
	public void afterThrowing_Teste_Visualizar_Requisicao_Pagamento(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}
	
	@AfterThrowing(pointcut = "execution(* finalizar_cadastro.Teste_Finalizar_Cadastro.*(..))", throwing = "error")
	public void afterThrowing_Teste_Finalizar_Cadastro(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

	@AfterThrowing(pointcut = "call(* gep_pagamento_auxiliary.Helper.*(..))", throwing = "error")
	public void afterThrowing_Helper(JoinPoint joinPoint, Throwable error) {
		logger.info("logAfterThrowing() is running!");
		logger.info("Local : " + joinPoint.getSignature().getName());
		logger.log(Level.SEVERE, error.getMessage(), error);
	}

}
