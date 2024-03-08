package com.github.testeexcelsaque.view;

import com.github.testeexcelsaque.loja.LojaDTO;
import com.github.testeexcelsaque.util.ConversorDeCsvParaHashMap;

import java.util.HashMap;

public class MenuLojas {
    ConversorDeCsvParaHashMap conversorDeCsvParaHashMap;

    public void retornaLojas() {
        try {
            HashMap<String, LojaDTO> lojas = conversorDeCsvParaHashMap.retornaHashMapDeLojas();
            lojas.entrySet().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Deu erro: " + e.getMessage());
        }


    }
}
