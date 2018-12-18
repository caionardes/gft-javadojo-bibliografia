package com.gft.javadojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gft.javadojo.bibliografia.BibliografiaService;

/**
 * Quando se lista o nome de autores de livros, artigos e outras publicações é comum que se apresente o nome do autor ou dos autores da seguinte forma:
 * sobrenome do autor em letras maiúsculas, seguido de uma vírgula e da primeira parte do nome apenas com as iniciais maiúsculas.
 */
@SpringBootApplication
public class ExecutaAplicacaoBibliografia {

	public static void main(String[] args) {
		SpringApplication.run(ExecutaAplicacaoBibliografia.class, args).close();
	}

	@Autowired
	private BibliografiaService bibliografiaService;

	@Bean
	public CommandLineRunner run() {
		return args -> {
			bibliografiaService.toString();
		};
	}
}

