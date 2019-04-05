package com.gft.javadojo.bibliografia;

import org.springframework.stereotype.Service;

@Service
public class BibliografiaService {

	public String formatarNome(String nome) {
		String[] palavras = nome.split(" ");
		String finalNome;
		
		if (palavras.length == 1) {
			
			String unicoNome = palavras[palavras.length - 1];
			finalNome = unicoNome.toUpperCase();
			

		} else {

			String sobrenome = palavras[palavras.length - 1];

			sobrenome = sobrenome.toUpperCase();

			finalNome = sobrenome + ", ";

			for (int i = 0; i < palavras.length - 1; i++) {
				finalNome += palavras[i] + " ";

			}
		}

		return finalNome.trim();
	}
}
