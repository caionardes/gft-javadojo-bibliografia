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
	public void formatarNome_test() {
		String formatado = bibliografiaService.formatarNome("Jose da Silva");

		assertEquals(formatado, "SILVA, Jose da");
	}

	@Test
	public void formatarNomeUnico_test() {
		String formatado = bibliografiaService.formatarNome("Santos");

		assertEquals(formatado, "SANTOS");
	}

}

