package com.github.testeexcelsaque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SaquePagueLojas {


    public static final Scanner SCANNER = new Scanner(System.in);
    public static final RegistradorDeLojas registradorDeLojas = new RegistradorDeLojas();

    public static void menuPrincipal() {
        int opcao = -1;
        imprimeMenuPrincipal();
        do {
            try {
                System.out.print("Digite a opção desejada: ");
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        registradorDeLojas.retornaHashMapDeLojas();
                        imprimeMenuPrincipal();
                    }
                    case 0 -> {
                        System.out.println("Fechando programa...");
                    }
                    default -> {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException ime) {
                SCANNER.nextLine();
                opcao = -1;
                System.out.println("Opção inválida! Digite 9 para ver as opções");
            }
        } while (opcao != 0);
    }

    public static void imprimeMenuPrincipal() {
        System.out.println("""
                1 - Ver lojas
                0 - Sair
                """);
    }
}