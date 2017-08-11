package principal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import incluir_requisicao_pagamento.Teste_incluir_requisicao_pagamento;
import incluir_requisicao_pagamento_beneficiario.Teste_Inclui_Beneficiario;
import incluir_requisicao_pagamento_terceiro_interessado.Teste_Inclui_Terceiros_Interessados;

import visualizar_Informacoes_resumidas_requisicao_pagamento.Teste_Visualiza;
import visualizar_detalhes_historicos_requisicao_pagamento.Teste_Visualiza_Detalhes;

import alterar_requisicao_pagamento_beneficiario.Teste_Altera_Beneficiario;
import alterar_requisicao_pagamento_terceiro_interessado.Teste_Altera_Terceiros_Interessados;
import alterar_requisicao_pagamento_dados_processo.Teste_Altera_Dados_Processo;

import excluir_requisicao_pagamento.Teste_Exclui;

import consultar_requisicao_pagamento.Teste_Consulta;

@RunWith(Suite.class)
@SuiteClasses({ Teste_incluir_requisicao_pagamento.class, Teste_Visualiza.class, Teste_Visualiza_Detalhes.class,
		Teste_Altera_Dados_Processo.class, Teste_Altera_Beneficiario.class, Teste_Altera_Terceiros_Interessados.class,
		Teste_Inclui_Beneficiario.class, Teste_Inclui_Terceiros_Interessados.class, Teste_Consulta.class,
		Teste_Exclui.class })

public class Suite_GEP_TC002_ManterRquisicao_Pagamento {

}
