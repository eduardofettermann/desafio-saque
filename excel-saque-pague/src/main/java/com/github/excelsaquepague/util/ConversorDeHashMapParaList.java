package com.github.excelsaquepague.util;

import com.github.excelsaquepague.loja.LojaDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversorDeHashMapParaList {
    public List<LojaDTO> retornaLojasConvertidasEmList(HashMap<String, LojaDTO> hashMapLojas) {
        List<LojaDTO> lojasList = new ArrayList<>();
        lojasList.addAll(hashMapLojas.values());
        return lojasList;
    }
}
