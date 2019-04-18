package com.gft.javadojo.bibliografia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

@Service
public class BibliografiaService {

	// exemplo de nome com sufixo "SILVA NETO, Joao" 
	public String formatarNome(String nome) {
		
		LinkedList<String> listaDeNomes = new LinkedList<>(Lists.list(nome.toUpperCase().split(" ")));
		
		System.out.println("lista de nomes: " + listaDeNomes + " Primeiro nome: " + listaDeNomes.getFirst());
		String finalNome = null;
		
		if (listaDeNomes.size() == 1) {
			
			finalNome = listaDeNomes.getFirst();
		
		} else {

			String ultima = listaDeNomes.getLast();
			
			ultima = ultima.toUpperCase();
			
			if (listaDeNomes.size() > 2 && ehSufixoEspecial(ultima)) {
				
				finalNome = listaDeNomes.get(listaDeNomes.size()-2)+ " " + ultima;
				listaDeNomes.removeLast();
				listaDeNomes.removeLast();
			} else {
				finalNome = ultima;
				listaDeNomes.removeLast();
			}
			
			finalNome += ", ";
			for (String parteNome : listaDeNomes) {
				
				if (ehConectivo(parteNome)) {
					finalNome += parteNome.toLowerCase() + " ";
				} else {
					finalNome += soPrimeiraLetraMaiuscula(parteNome) + " ";
				}
			}
			
		}

		return finalNome.trim();
	}
	
	private String soPrimeiraLetraMaiuscula(String palavra) {
		String resultado = null;
		
	    resultado = palavra.substring(0, 1).toUpperCase() + palavra.substring(1).toLowerCase();
		
		return resultado;
	}
	
	// trata os sufixos possiveis
	private boolean ehSufixoEspecial(String parteDoNome) {
		Stream<String> stream = Stream.of("FILHO", "FILHA", "NETO", "NETA", "SOBRINHO", "SOBRINHA" , "JUNIOR");
		
		boolean anyMatch = stream.anyMatch(sufixo -> {
			return sufixo.equals(parteDoNome);
		});
		
		return anyMatch;
	}
	
	// trata os conectivos
		private boolean ehConectivo(String parteDoNome) {
			Stream<String> stream = Stream.of("da", "de", "do", "das", "dos");
			
			boolean anyMatch = stream.anyMatch(sufixo -> {
				return sufixo.equalsIgnoreCase(parteDoNome);
			});
			
			return anyMatch;
		}
	
//	Function<String, Boolean> verifica
//	public class VerificaSufixo {
//		public boolean egSuf(String a) {
//			return a.equals("X");
//		}
//	}
		
}
