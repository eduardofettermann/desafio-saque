package com.github.excelsaquepague.loja;

import com.github.excelsaquepague.util.ConverteOpostoDoNumero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LojaModel {
    private String codigoDaLoja;
    private double receitas;
    private double impostos;
    private double custo;
    private double despesa;
    private double resultadoFinanceiro;
    private double provisaoBarraPerda;
    private double ppr;
    private double irBarraCsll;
    private double receitaLiquida;
    private double resultadoOperacional;
    private double margemOperacional;
    private double lucro;
    private double lucratividade;

    public void geraCustos() {
        if (this.custo == 0) {
            double resultadoCusto = ConverteOpostoDoNumero.retornaOpostoDoNumero(this.impostos)
                    + ConverteOpostoDoNumero.retornaOpostoDoNumero(this.despesa)
                    + ConverteOpostoDoNumero.retornaOpostoDoNumero(this.provisaoBarraPerda)
                    + ConverteOpostoDoNumero.retornaOpostoDoNumero(this.irBarraCsll)
                    + ConverteOpostoDoNumero.retornaOpostoDoNumero(this.ppr);
            this.custo = resultadoCusto == 0 ? 0 : resultadoCusto;
        }
    }

    public void geraResultadoFinanceiro() {
        double resultadoFinanceiroResultado = this.receitas - (this.custo > 0 ? this.custo : ConverteOpostoDoNumero.retornaOpostoDoNumero(this.custo));
        if (this.resultadoFinanceiro == 0) {
            this.resultadoFinanceiro = resultadoFinanceiroResultado == 0 ? 0 : resultadoFinanceiroResultado;
        }
    }

    public void geraReceitaLiquida() {
        double receitaLiquidaResultado = this.receitas - (this.custo > 0 ? this.custo : ConverteOpostoDoNumero.retornaOpostoDoNumero(this.custo));
        this.receitaLiquida = receitaLiquidaResultado == 0 ? 0 : receitaLiquidaResultado;
    }

    public void geraResultadoOperacional() {
        this.resultadoOperacional = this.custo - this.receitaLiquida;
    }

    public void geraMargemOperacional() {
        this.margemOperacional = (this.custo / this.receitaLiquida) * 100;
    }

    public void geraLucro() {
        this.lucro = this.resultadoOperacional - this.despesa - this.resultadoFinanceiro - this.provisaoBarraPerda - this.ppr - this.irBarraCsll;
    }

    public void geraLucratividade() {
        this.lucratividade = (this.lucro / this.receitaLiquida) * 100;
    }

    public void geraTodosDadosAdicionaisEValidaResultadoFinanceiro() {
        this.geraCustos();
        this.geraReceitaLiquida();
        this.geraResultadoFinanceiro();
        this.geraResultadoOperacional();
        this.geraMargemOperacional();
        this.geraLucro();
        this.geraLucratividade();
    }

    public LojaModel(LojaDTO lojaDTO) {
        this.codigoDaLoja = lojaDTO.getCodigoDaLoja();
        this.receitas = lojaDTO.getReceitas();
        this.impostos = lojaDTO.getImpostos();
        this.custo = lojaDTO.getCusto();
        this.despesa = lojaDTO.getDespesa();
        this.resultadoFinanceiro = lojaDTO.getResultadoFinanceiro();
        this.provisaoBarraPerda = lojaDTO.getProvisaoBarraPerda();
        this.ppr = lojaDTO.getPpr();
        this.irBarraCsll = lojaDTO.getIrBarraCsll();
        this.geraTodosDadosAdicionaisEValidaResultadoFinanceiro();
    }
}
