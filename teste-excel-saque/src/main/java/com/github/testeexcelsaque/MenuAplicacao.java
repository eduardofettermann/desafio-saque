package com.github.testeexcelsaque;

import java.util.HashMap;

public class MenuAplicacao {
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
