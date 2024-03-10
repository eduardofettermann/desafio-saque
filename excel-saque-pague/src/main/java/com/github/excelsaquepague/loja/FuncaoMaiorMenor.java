package com.github.excelsaquepague.loja;

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
