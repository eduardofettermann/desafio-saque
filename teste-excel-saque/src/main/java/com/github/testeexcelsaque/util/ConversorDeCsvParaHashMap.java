package com.github.testeexcelsaque.util;

import com.github.testeexcelsaque.loja.LojaDTO;

import java.util.HashMap;

public class ConversorDeCsvParaHashMap {
    public HashMap<String, LojaDTO> retornaHashMapDeLojas() {
        LeitorDeDadosCSV leitor = new LeitorDeDadosCSV();
        String[] cabecalhoDasColunas = leitor.retornaProximaLinhaFracionada();

        HashMap<String, LojaDTO> lojas = new HashMap<>();
        String[] dadosDaLinha = {"mock", "mock", "mock"};
        try {

            while (!dadosDaLinha[0].equals("Array")) {
                dadosDaLinha = leitor.retornaProximaLinhaFracionada();
                String codigoDaLoja = dadosDaLinha[0];
                String funcaoDRE = dadosDaLinha[1];
                double resultadoDRE = Double.parseDouble(dadosDaLinha[2].replace(",", "."));
                LojaDTO lojaDTO = new LojaDTO();
                if (!lojas.containsKey(codigoDaLoja)) {
                    lojaDTO.setCodigoDaLoja(codigoDaLoja);
                    lojas.put(codigoDaLoja, lojaDTO);
                }
                switch (funcaoDRE) {
                    case ("Receitas") -> lojas.get(codigoDaLoja).setReceitas(resultadoDRE);
                    case ("Impostos") -> lojas.get(codigoDaLoja).setImpostos(resultadoDRE);
                    case ("Custo") -> lojas.get(codigoDaLoja).setCusto(resultadoDRE);
                    case ("Despesa") -> lojas.get(codigoDaLoja).setDespesa(resultadoDRE);
                    case ("Resultado Financeiro") -> lojas.get(codigoDaLoja).setResultadoFinanceiro(resultadoDRE);
                    case ("Provisão/Perda") -> lojas.get(codigoDaLoja).setProvisaoBarraPerda(resultadoDRE);
                    case ("PPR") -> lojas.get(codigoDaLoja).setPpr(resultadoDRE);
                    case ("IR/CSLL") -> lojas.get(codigoDaLoja).setIrBarraCsll(resultadoDRE);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ocorreu um erro: Provavelmente foi encontrada uma linha com ';' separadores mas sem informações nas cédulas ");
        }
        leitor.fechaLeitor();
        return lojas;
    }
}