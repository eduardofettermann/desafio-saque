package com.github.excelsaquepague.loja;

public enum FuncaoRanking {
    RECEITA_LIQUIDA("receitaLiquida"),
    CUSTO("custo"),
    DESPESA("despesa"),
    RESULTADO_OPERACIONAL("resultadoOperacional"),
    MARGEM_OPERACIONAL("margemOperacional"),
    LUCRATIVIDADE("lucratividade");
    private String valor;

    FuncaoRanking(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return this.valor;
    }
}
