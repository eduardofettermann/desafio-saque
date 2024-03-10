package com.github.testeexcelsaque.service;

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
        lojasDTO.forEach(lojaDTO -> {
            lojasComDetalhes.add(new LojaModel(lojaDTO));
        });
    }

}
