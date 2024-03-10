package com.github.testeexcelsaque.loja;

public enum FuncaoMaiorMenor {
    MAXIMO("maximo"),
    MINIMO("minimo");
    private String valor;

    FuncaoMaiorMenor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
