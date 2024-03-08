package com.github.testeexcelsaque;

import com.github.testeexcelsaque.service.LojaService;

public class TesteExcelSaqueApplication {

    public static void main(String[] args) {
        LojaService service = new LojaService();
        service.exibeTodasLojas();
    }
}