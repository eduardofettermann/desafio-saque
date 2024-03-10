package com.github.excelsaquepague.view;

import com.github.excelsaquepague.loja.FuncaoMaiorMenor;
import com.github.excelsaquepague.loja.FuncaoRanking;
import com.github.excelsaquepague.loja.LojaModel;
import com.github.excelsaquepague.service.LojaService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

public class LojaViewer {
    LojaService service = new LojaService();

    public void imprimeTabelaNoConsole() {
        List<LojaModel> lojas = service.retornaTodasLojasComDetalhes();
        String linhaDivisora = "-------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------------------";
        System.out.println(linhaDivisora);
        System.out.printf("%20s %20s %20s %20s %20s %30s %30s %30s %30s %30s %30s %30s %30s %30s"
                , "CÓDIGO DA LOJA"
                , "RECEITAS"
                , "IMPOSTOS"
                , "CUSTO"
                , "DESPESA"
                , "RESULTADO FINANCEIRO"
                , "PROVISÃO/PERDA"
                , "PPR"
                , "IR/CSLL"
                , "RECEITA LÍQUIDA"
                , "RESULTADO OPERACIONAL"
                , "MARGEM OPERACIONAL"
                , "LUCRO"
                , "LUCRATIVIDADE"
        );
        System.out.println();
        System.out.println(linhaDivisora);

        for (LojaModel loja : lojas) {
            System.out.format("%20s %20s %20s %20s %20s %30s %30s %30s %30s %30s %30s %30.2f %% %30s %30.2f %%"
                    , loja.getCodigoDaLoja()
                    , retornaValorEmReal(loja.getReceitas())
                    , retornaValorEmReal(loja.getImpostos())
                    , retornaValorEmReal(loja.getCusto())
                    , retornaValorEmReal(loja.getDespesa())
                    , retornaValorEmReal(loja.getResultadoFinanceiro())
                    , retornaValorEmReal(loja.getProvisaoBarraPerda())
                    , retornaValorEmReal(loja.getPpr())
                    , retornaValorEmReal(loja.getIrBarraCsll())
                    , retornaValorEmReal(loja.getReceitaLiquida())
                    , retornaValorEmReal(loja.getResultadoOperacional())
                    , loja.getMargemOperacional()
                    , retornaValorEmReal(loja.getLucro())
                    , loja.getLucratividade());
            System.out.println();
        }
        System.out.println(linhaDivisora);
    }

    public void imprimeRankingLojas(FuncaoRanking funcaoRanking, long limiteResultado, FuncaoMaiorMenor funcaoMaiorMenor) {
        List<LojaModel> lojas = service.retornaRankingDasLojas(funcaoRanking, service.retornaTodasLojasComDetalhes(), limiteResultado, funcaoMaiorMenor);
        String linhaDivisora = "-------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------------------";
        System.out.println(linhaDivisora);
        String cabecalho = String.format("TOP %d LOJAS COM %s %s", limiteResultado, funcaoMaiorMenor, funcaoRanking);
        System.out.printf("%90s", cabecalho);
        System.out.println();
        System.out.println(linhaDivisora);
        System.out.printf("%20s %20s %20s %20s %20s %30s %30s %30s %30s %30s %30s %30s %30s %30s"
                , "CÓDIGO DA LOJA"
                , "RECEITAS"
                , "IMPOSTOS"
                , "CUSTO"
                , "DESPESA"
                , "RESULTADO FINANCEIRO"
                , "PROVISÃO/PERDA"
                , "PPR"
                , "IR/CSLL"
                , "RECEITA LÍQUIDA"
                , "RESULTADO OPERACIONAL"
                , "MARGEM OPERACIONAL"
                , "LUCRO"
                , "LUCRATIVIDADE"
        );
        System.out.println();
        System.out.println(linhaDivisora);

        for (LojaModel loja : lojas) {
            System.out.format("%20s %20s %20s %20s %20s %30s %30s %30s %30s %30s %30s %30.2f %% %30s %30.2f %%"
                    , loja.getCodigoDaLoja()
                    , retornaValorEmReal(loja.getReceitas())
                    , retornaValorEmReal(loja.getImpostos())
                    , retornaValorEmReal(loja.getCusto())
                    , retornaValorEmReal(loja.getDespesa())
                    , retornaValorEmReal(loja.getResultadoFinanceiro())
                    , retornaValorEmReal(loja.getProvisaoBarraPerda())
                    , retornaValorEmReal(loja.getPpr())
                    , retornaValorEmReal(loja.getIrBarraCsll())
                    , retornaValorEmReal(loja.getReceitaLiquida())
                    , retornaValorEmReal(loja.getResultadoOperacional())
                    , loja.getMargemOperacional()
                    , retornaValorEmReal(loja.getLucro())
                    , loja.getLucratividade());
            System.out.println();
        }
        System.out.println(linhaDivisora);
    }

    public String retornaValorEmReal(double valor) {
        Locale localBrasil = new Locale("pt", "BR");
        DecimalFormat doubleFormatado = new DecimalFormat("#,###.00");

        return doubleFormatado.getCurrencyInstance(localBrasil).format(valor);
    }
}
