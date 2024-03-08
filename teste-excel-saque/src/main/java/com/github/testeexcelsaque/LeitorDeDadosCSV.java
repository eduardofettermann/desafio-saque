package com.github.testeexcelsaque;

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
            return dadosDaLinha;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fechaLeitor() {
        try {
            leitorBufferizado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public LeitorDeDadosCSV() {
        try {
            String caminhoDoArquivo = "C:\\Users\\eduar\\Desktop\\teste-excel-saque\\teste-excel-saque\\teste-excel-ponto-virgula.CSV";
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