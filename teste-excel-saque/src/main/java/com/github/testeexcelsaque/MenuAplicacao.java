package com.github.testeexcelsaque;

import java.util.HashMap;

public class MenuAplicacao {
    RegistradorDeLojas registradorDeLojas;

    public void retornaLojas() {
        try {
            HashMap<String, LojaDTO> lojas = registradorDeLojas.retornaHashMapDeLojas();
            lojas.entrySet().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Deu erro: " + e.getMessage());
        }


    }
}
