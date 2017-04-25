package ancillary;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterThrowing;

@Aspect
public class ExceptionAspect {
	private Logger logger = Logger.getLogger(ExceptionAspect.class.getCanonicalName());

	 @Pointcut("execution(* consultar_requisicao_pagamento.Teste_Consulta.*(..))")
	 private void NSEexception(){}
	
	
		
	 @AfterThrowing(
		      pointcut = "execution(* consultar_requisicao_pagamento.Teste_Consulta.*(..))",
		      throwing= "error")
		    public void afterThrowing_Teste_Consulta(JoinPoint joinPoint, Throwable error) {
		 	logger.info("logAfterThrowing() is running!");
		 	logger.info("Local : " + joinPoint.getSignature().getName());
		 	logger.log(Level.SEVERE, error.getMessage(), error);
		    }
	 
	 @AfterThrowing(
		      pointcut = "execution(* incluir_requisicao_pagamento.Teste_Inclui.*(..))",
		      throwing= "error")
		    public void afterThrowing_Teste_Inclui_Pagamento(JoinPoint joinPoint, Throwable error) {
		 	logger.info("logAfterThrowing() is running!");
		 	logger.info("Local : " + joinPoint.getSignature().getName());
		 	logger.log(Level.SEVERE, error.getMessage(), error);
		    }

	 @AfterThrowing(
		      pointcut = "execution(* alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo.*(..))",
		      throwing= "error")
		    public void afterThrowing_Teste_Altera_Dados_Processo(JoinPoint joinPoint, Throwable error) {
		 	logger.info("logAfterThrowing() is running!");
		 	logger.info("Local : " + joinPoint.getSignature().getName());
		 	logger.log(Level.SEVERE, error.getMessage(), error);
		    }

	 @AfterThrowing(
		      pointcut = "execution(* incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario.*(..))",
		      throwing= "error")
		    public void afterThrowing_Teste_Inclui_Beneficiario(JoinPoint joinPoint, Throwable error) {
		 	logger.info("logAfterThrowing() is running!");
		 	logger.info("Local : " + joinPoint.getSignature().getName());
		 	logger.log(Level.SEVERE, error.getMessage(), error);
		    }

	 

	


	}
