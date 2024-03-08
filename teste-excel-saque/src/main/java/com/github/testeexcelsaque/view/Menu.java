package com.github.testeexcelsaque.view;

import com.github.testeexcelsaque.util.ConversorDeCsvParaHashMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {


    public static final Scanner SCANNER = new Scanner(System.in);
    public static final ConversorDeCsvParaHashMap CONVERSOR_DE_CSV_PARA_HASH_MAP = new ConversorDeCsvParaHashMap();

    public void exibeMenuPrincipal() {
        int opcao = -1;
        do {
            try {
                imprimeMenu();
                opcao = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (opcao) {
                    case 1 -> {
                        CONVERSOR_DE_CSV_PARA_HASH_MAP.retornaHashMapDeLojas();
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

    public static void imprimeMenu() {
        System.out.print("""
                                
                Digite a opção desejada:
                
                (1) - Imprimir todas lojas
                                
                (0) - Encerrar programa
                """);
    }
}