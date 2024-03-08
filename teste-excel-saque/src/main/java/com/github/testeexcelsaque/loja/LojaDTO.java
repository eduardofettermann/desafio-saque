package com.github.testeexcelsaque.loja;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LojaDTO {
    private String codigoDaLoja;
    private double receitas;
    private double impostos;
    private double custo;
    private double despesa;
    private double resultadoFinanceiro;
    private double provisaoBarraPerda;
    private double ppr;
    private double IrBarraCsll;

    @Override
    public String toString() {
        return "LojaDTO{" +
                "codigoDaLoja='" + codigoDaLoja + '\'' +
                ", receitas=" + receitas +
                ", impostos=" + impostos +
                ", custo=" + custo +
                ", despesa=" + despesa +
                ", resultadoFinanceiro=" + resultadoFinanceiro +
                ", provisaoBarraPerda=" + provisaoBarraPerda +
                ", ppr=" + ppr +
                ", IrBarraCsll=" + IrBarraCsll +
                '}';
    }
}
