package gep_pagamento_auxiliary;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
	private Logger logger = Logger.getLogger(LoggingAspect.class.getCanonicalName());

	@Pointcut("execution(* visualizar_Informacoes_resumidas_requisicao_pagamento.Preenche.*(..))")
	private void Loggable() {
	}

	
	@Before("Loggable()")
	public void beforeAdvice(JoinPoint Loggable) {
		logger.info("Method fill in executed with the followed arguments: "+Loggable.toString());

	}
	
	@After("execution(* visualizar_Informacoes_resumidas_requisicao_pagamento.Pagina.resultado(..))")
	public void AfterAdvice(JoinPoint Loggable) {
		logger.info("verifica se existem resultados na listagem " + Loggable.toString());
		

	}

}
