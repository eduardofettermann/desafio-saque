package com.github.excelsaquepague.loja;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LojaDTO {
    private String codigoDaLoja;
    private double receitas;
    private double impostos;
    private double custo;
    private double despesa;
    private double resultadoFinanceiro;
    private double provisaoBarraPerda;
    private double ppr;
    private double irBarraCsll;
}
