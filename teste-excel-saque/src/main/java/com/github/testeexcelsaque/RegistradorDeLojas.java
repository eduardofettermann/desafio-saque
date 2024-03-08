package com.github.testeexcelsaque;

import java.util.HashMap;

public class RegistradorDeLojas {
    public HashMap<String, LojaDTO> retornaHashMapDeLojas() {
        LeitorDeDadosCSV leitor = new LeitorDeDadosCSV();
        String[] cabecalhoDasColunas = leitor.retornaProximaLinhaFracionada();
        for (String cabecalhoDaColuna : cabecalhoDasColunas) {
            System.out.println(cabecalhoDaColuna);
        }

        HashMap<String, LojaDTO> lojas = new HashMap<>();
        String[] dadosDaLinha = {"mockado", "mock", "mockei"};
        try {

            while (!dadosDaLinha[0].equals("Array")) {
                dadosDaLinha = leitor.retornaProximaLinhaFracionada();
                for (String dadoDaLinha : dadosDaLinha) {
                    System.out.println(dadoDaLinha);
                }
                System.out.println("codigo da loja " + dadosDaLinha[0]);
                System.out.println("tamanho da array: " + dadosDaLinha.length);
                String codigoDaLoja = dadosDaLinha[0];
                System.out.println("codigo da loja atribuido: " + codigoDaLoja);
                String funcaoDRE = dadosDaLinha[1];
                System.out.println("funcao atribuida: " + funcaoDRE);
                double resultadoDRE = Double.parseDouble(dadosDaLinha[2].replace(",", "."));
                System.out.println("resultado atribuido " + resultadoDRE);
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
                System.out.println("Informacao atribuida");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ocorreu um erro: Provavelmente foi encontrada uma linha com ';' separadores mas sem informações nas cédulas ");
        }
        leitor.fechaLeitor();
        return lojas;
    }
}