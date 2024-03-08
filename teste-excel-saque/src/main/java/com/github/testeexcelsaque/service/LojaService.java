package com.github.testeexcelsaque.service;

import com.github.testeexcelsaque.loja.LojaDTO;
import com.github.testeexcelsaque.util.ConversorDeCsvParaHashMap;
import com.github.testeexcelsaque.util.ConversorDeHashMapParaList;

import java.util.HashMap;
import java.util.List;

public class LojaService {
    private ConversorDeCsvParaHashMap conversorDeCsvParaHashMap = new ConversorDeCsvParaHashMap();
    private ConversorDeHashMapParaList conversorDeHashMapParaList = new ConversorDeHashMapParaList();

    public void exibeTodasLojas() {
        HashMap<String, LojaDTO> lojasHashMap = conversorDeCsvParaHashMap.retornaHashMapDeLojas();
        List<LojaDTO> lojasList = conversorDeHashMapParaList.retornaLojasConvertidasEmList(lojasHashMap);
        lojasList.forEach(lojaDTO -> {
            System.out.println(lojaDTO.toString());
        });
    }

}
