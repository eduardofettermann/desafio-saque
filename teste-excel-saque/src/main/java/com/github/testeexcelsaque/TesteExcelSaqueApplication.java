package com.github.testeexcelsaque;

import com.github.testeexcelsaque.loja.FuncaoMaiorMenor;
import com.github.testeexcelsaque.loja.FuncaoRanking;
import com.github.testeexcelsaque.view.LojaViewer;

public class TesteExcelSaqueApplication {

    public static void main(String[] args) {
        LojaViewer view = new LojaViewer();
        view.imprimeRankingLojas(FuncaoRanking.CUSTO, 10, FuncaoMaiorMenor.MINIMO);
    }
}