package com.github.excelsaquepague.util;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorDeDadosCSV {
    private BufferedReader leitorBufferizado;
    @Getter
    private FileReader arquivoCSV;

    public String[] retornaProximaLinhaFracionada() {
        String[] dadosDaLinha;
        String proximaLinha;
        try {
            proximaLinha = leitorBufferizado.readLine();
            dadosDaLinha = proximaLinha.split(";");
            if (dadosDaLinha.length < 3) {
                dadosDaLinha[0] = "Array";
            }
            return dadosDaLinha;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Pode ser que linhas da tabela estejam sem valor, então foi gerado um erro: " + e.getMessage());
        }
    }

    public void fechaLeitor() {
        try {
            leitorBufferizado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LeitorDeDadosCSV(String urlDoArquivoCSV) {
        try {
            String caminhoDoArquivo = urlDoArquivoCSV;
            this.setArquivoCSV(caminhoDoArquivo);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.err.println("Ocorreu um erro: Arquivo não encontrado! Verifique se o caminho indicado do arquivo .csv está correto!");
        } catch (NullPointerException e) {
            System.err.println("Ocorreu um erro: NullPointer Exception! Verifique se o caminho indicado do arquivo .csv está correto!");
        }
        setLeitorBufferizado(getArquivoCSV());
    }

    public void setLeitorBufferizado(FileReader arquivoCSV) {
        this.leitorBufferizado = new BufferedReader(arquivoCSV);
    }

    public void setArquivoCSV(String caminhoArquivoCSV) throws FileNotFoundException {
        this.arquivoCSV = new FileReader(caminhoArquivoCSV);
    }
}