package apis;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class StringTest {
	@Test
	public void encontrandoCaractere_charAt() {
		String exemplo = "Exemplo";
		char obtido = exemplo.charAt(3);
		char esperado = 'm';
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void encontrandoPrimeiroCaractere_startsWith() {
		String exemplo = "Exemplo";
		boolean obtido = exemplo.startsWith("E");
		
		assertEquals(true, obtido);
	}
	
	@Test
	public void encontrandoUltimoCaractere_endsWith() {
		String exemplo = "Exemplo";
		boolean obtido = exemplo.endsWith("o");
		
		assertEquals(true, obtido);
	}
	
	@Test
	public void contendoCaractere_contains() {
		String exemplo = "Exemplo";
		boolean obtido = exemplo.contains("em");
		
		assertEquals(true, obtido);
	}
	
	@Test
	public void comparandoStrings_compareTo() {
		String exemplo = "Exemplo";
		int obtido = exemplo.compareTo("Exemplo02");
		int esperado = -2;
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void pegandoIndiceDoCaractere_indexOf() {
		String exemplo = "Exemplo";
		int obtido = exemplo.indexOf("p");
		int esperado = 4;
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void deixandoPalavraEmMinusculo_toLowerCase() {
		String exemplo = "Exemplo";
		String obtido = exemplo.toLowerCase();
		String esperado = "exemplo";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void deixandoPalavraEmMaiusculo_toUpperCase() {
		String exemplo = "Exemplo";
		String obtido = exemplo.toUpperCase();
		String esperado = "EXEMPLO";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void pegandoNroDeCaracteres_length() {
		String exemplo = "Exemplo";
		int obtido = exemplo.length();
		int esperado = 7;
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void substituindoCaracteres_replace() {
		String exemplo = "Exemplo";
		String obtido = exemplo.replace("mpl", "rcíci");
		String esperado = "Exercício";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void substituindoPrimeiroCaractere_replaceFirst() {
		String exemplo = "Exemplo";
		String obtido = exemplo.replaceFirst("Ex", "T");
		String esperado = "Templo";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void separandoCaracteres_split() {
		String exemplo = "Exemplo";
		String[] obtido = exemplo.split("");
		String[] esperado = {"E", "x", "e", "m", "p", "l", "o"};
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void clonandoString_trim() {
		String exemplo = "Exemplo";
		String obtido = exemplo.trim();
		String esperado = "Exemplo";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void mostrandoDeterminadosCaracteres_substring() {
		String exemplo = "Exemplo";
		String obtido = exemplo.substring(4);
		String esperado = "plo";
		
		assertEquals(esperado, obtido);
	}
}
