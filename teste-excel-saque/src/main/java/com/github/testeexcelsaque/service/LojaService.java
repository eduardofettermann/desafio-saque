package com.github.testeexcelsaque.service;

import com.github.testeexcelsaque.loja.FuncaoMaiorMenor;
import com.github.testeexcelsaque.loja.FuncaoRanking;
import com.github.testeexcelsaque.loja.LojaDTO;
import com.github.testeexcelsaque.loja.LojaModel;
import com.github.testeexcelsaque.util.ConversorDeCsvParaHashMap;
import com.github.testeexcelsaque.util.ConversorDeHashMapParaList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class LojaService {
    private final ConversorDeCsvParaHashMap conversorDeCsvParaHashMap = new ConversorDeCsvParaHashMap();
    private final ConversorDeHashMapParaList conversorDeHashMapParaList = new ConversorDeHashMapParaList();

    public HashMap<String, LojaDTO> retornaLojasDTOHashMap() {
        return conversorDeCsvParaHashMap.retornaHashMapDeLojas();
    }

    public List<LojaDTO> retornaLojasDTOList() {
        return conversorDeHashMapParaList.retornaLojasConvertidasEmList(this.retornaLojasDTOHashMap());
    }

    public List<LojaModel> retornaTodasLojasComDetalhes() {
        List<LojaDTO> lojasDTO = this.retornaLojasDTOList();
        List<LojaModel> lojasComDetalhes = new ArrayList<>();
        lojasDTO.forEach(lojaDTO -> lojasComDetalhes.add(new LojaModel(lojaDTO)));
        return lojasComDetalhes;
    }

    public List<LojaModel> retornaRankingDasLojas(FuncaoRanking rankingFuncao, List<LojaModel> lojas, long limiteDoResultado, FuncaoMaiorMenor funcaoMaiorMenor) {
        List<LojaModel> lojasRankeadas = new ArrayList<>();

        switch (rankingFuncao) {
            case RECEITA_LIQUIDA -> {
                switch (funcaoMaiorMenor) {
                    case MAXIMO ->
                            lojasRankeadas = lojas.stream().sorted(Comparator.comparing(LojaModel::getReceitaLiquida).reversed()).limit(limiteDoResultado).toList();
                    case MINIMO ->
                            lojasRankeadas = lojas.stream().sorted(Comparator.comparing(LojaModel::getReceitaLiquida)).limit(limiteDoResultado).toList();
                }
            }
            case CUSTO -> {
                switch (funcaoMaiorMenor) {
                    case MAXIMO ->
                            lojasRankeadas = lojas.stream().sorted(Comparator.comparing(LojaModel::getCusto).reversed()).limit(limiteDoResultado).toList();
                    case MINIMO ->
                            lojasRankeadas = lojas.stream().sorted(Comparator.comparing(LojaModel::getCusto)).limit(limiteDoResultado).toList();
                }
            }
            case LUCRATIVIDADE -> {
                switch (funcaoMaiorMenor) {
                    case MAXIMO ->
                            lojasRankeadas = lojas.stream().sorted(Comparator.comparing(LojaModel::getLucratividade).reversed()).limit(limiteDoResultado).toList();
                    case MINIMO ->
                            lojasRankeadas = lojas.stream().sorted(Comparator.comparing(LojaModel::getLucratividade)).limit(limiteDoResultado).toList();
                }
            }
        }
        return lojasRankeadas;
    }
}



