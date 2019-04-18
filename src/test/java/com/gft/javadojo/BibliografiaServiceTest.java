package com.gft.javadojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gft.javadojo.bibliografia.BibliografiaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BibliografiaServiceTest {

	@Autowired
	private BibliografiaService bibliografiaService;
	
	@Test
	public void test_formatarNome_TresNomes() {
		String formatado = bibliografiaService.formatarNome("Jose Silva");

		assertEquals("SILVA, Jose", formatado);
	}

	@Test
	public void test_formatarNome_QuatroNomes() {
		String formatado = bibliografiaService.formatarNome("Jose Silva Moreira Fernandes");

		assertEquals("FERNANDES, Jose Silva Moreira", formatado);
	}
	
	@Test
	public void test_formatarNome_UnicoNome() {
		String formatado = bibliografiaService.formatarNome("Santos");

		assertEquals("SANTOS", formatado);
	}

	// Caio Nardes, Cassia de Oliveira, Ricardo Martins Taques, Mohamad Al Salim U Meca
	@Test
	public void test_formatarNome_NomesBonitosCodingDojo() {
			assertEquals("NARDES, Caio", bibliografiaService.formatarNome("Caio Nardes"));
			assertEquals("OLIVEIRA, Cassia de", bibliografiaService.formatarNome("Cassia de Oliveira"));
			assertEquals("TAQUES, Ricardo Martins", bibliografiaService.formatarNome("Ricardo Martins Taques"));
			assertEquals("MECA, Mohamad Al Salim U", bibliografiaService.formatarNome("Mohamad Al Salim U Meca"));
	}
	
	
	//"FILHO", "FILHA", "NETO", "NETA", "SOBRINHO", "SOBRINHA" ou "JUNIOR"
	@Test
	public void test_formatarNome_SufixoEspecialNoSobrenome() {
		String formatado = bibliografiaService.formatarNome("Jose Silva Filho");

		assertEquals("SILVA FILHO, Jose", formatado);
	}

	//"da", "de", "do", "das", "dos"
	@Test
	public void test_formatarNome_ConectivosNoSobrenome() {
		String formatado = bibliografiaService.formatarNome("Jose da Silva");

		assertEquals("SILVA, Jose da", formatado);
	}
}

