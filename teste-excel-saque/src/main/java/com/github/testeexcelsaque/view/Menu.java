package com.github.testeexcelsaque.view;

import com.github.testeexcelsaque.loja.FuncaoMaiorMenor;
import com.github.testeexcelsaque.loja.FuncaoRanking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final LojaViewer LOJA_VIEWER = new LojaViewer();

    public void exibeMenuPrincipal() {
        int opcao = -1;
        do {
            try {
                imprimeOpcoesMenuPrincipal();
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        LOJA_VIEWER.imprimeTabelaNoConsole();
                    }
                    case 2 -> {
                        imprimeMenuRanking();
                    }
                    case 0 -> {
                        System.out.println("Encerrando programa...");
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Tente novamente!");
            }
        } while (opcao != 0);
    }

    public void imprimeMenuRanking() {
        FuncaoRanking funcaoRanking = retornaFuncaoRankingSelecionada();
        FuncaoMaiorMenor funcaoMaiorMenor = retornaFuncaoMaiorMenorSelecionada();
        long limiteDeLojas = retornaLimiteDeLojas();
        LOJA_VIEWER.imprimeRankingLojas(funcaoRanking, limiteDeLojas, funcaoMaiorMenor);
    }

    public FuncaoRanking retornaFuncaoRankingSelecionada() {
        imprimeOpcoesFuncaoRanking();
        int opcao = -1;
        FuncaoRanking funcaoRanking = null;
        do {
            try {
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        funcaoRanking = FuncaoRanking.RECEITA_LIQUIDA;
                    }
                    case 2 -> {
                        funcaoRanking = FuncaoRanking.CUSTO;
                    }
                    case 3 -> {
                        funcaoRanking = FuncaoRanking.DESPESA;
                    }
                    case 4 -> {
                        funcaoRanking = FuncaoRanking.RESULTADO_OPERACIONAL;
                    }
                    case 5 -> {
                        funcaoRanking = FuncaoRanking.MARGEM_OPERACIONAL;
                    }
                    case 6 -> {
                        funcaoRanking = FuncaoRanking.LUCRATIVIDADE;
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Tente novamente!");
            }
        } while (opcao == -1);
        return funcaoRanking;
    }

    private FuncaoMaiorMenor retornaFuncaoMaiorMenorSelecionada() {
        imprimeOpcoesFuncaoMaiorMenor();
        int opcao = -1;
        FuncaoMaiorMenor funcaoMaiorMenor = null;
        do {
            try {
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        funcaoMaiorMenor = FuncaoMaiorMenor.MAXIMO;
                    }
                    case 2 -> {
                        funcaoMaiorMenor = FuncaoMaiorMenor.MINIMO;
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Tente novamente!");
            }
        } while (opcao == -1);
        return funcaoMaiorMenor;
    }

    public long retornaLimiteDeLojas() throws IllegalArgumentException {
        long limiteDeLojas = 0;
        do {
            imprimePerguntaLimiteDoRanking();
            try {
                long resposta = SCANNER.nextInt();
                SCANNER.nextLine();
                if (resposta < 1) {
                    System.out.println("Digite apenas números positivos!");
                } else {
                    limiteDeLojas = resposta;
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                System.out.println("Opção inválida! Tente novamente!");
            }
        } while (limiteDeLojas < 1);
        return limiteDeLojas;
    }

    public void imprimeOpcoesMenuPrincipal() {
        System.out.print("""
                                
                Digite a opção desejada:
                                
                (1) - Imprimir todas lojas
                (2) - Imprimir Ranking de lojas
                                
                (0) - Encerrar programa
                """);
    }

    public void imprimeOpcoesFuncaoRanking() {
        System.out.println("""
                                
                Digite a opção de função que você deseja filtrar:
                                
                (1) - Receita Líquida
                (2) - Custo
                (3) - Despesa
                (4) - Resultado Operacional
                (5) - Margem Operacional
                (6) - Lucratividade
                                
                (0) - Voltar
                """);
    }

    private void imprimeOpcoesFuncaoMaiorMenor() {
        System.out.println("""
                                
                Digite a opção que define se o ranking se baseará nos maiores ou menores valores:
                                
                (1) - Maiores valores
                (2) - Menores valores
                                
                (0) - Voltar
                """);
    }

    private void imprimePerguntaLimiteDoRanking() {
        System.out.println("""
                                
                Digite o máximo de lojas que você deseja que apareça no ranking:
                """);
    }
}