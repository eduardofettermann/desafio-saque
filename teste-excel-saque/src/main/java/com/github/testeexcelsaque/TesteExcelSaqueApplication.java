package com.github.testeexcelsaque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class TesteExcelSaqueApplication {

	public static void main(String[] args) {
		SaquePagueLojas saquePagueLojas = new SaquePagueLojas();
		saquePagueLojas.menuPrincipal();
	}

}
