package apis;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {
	@Test
	public void adicionandoNaLista_add() {
		List<String> obtido = new ArrayList<>();
		String esperado = "Exemplo01";
		
		obtido.add("Exemplo01");
		assertEquals(esperado, obtido.get(0));
	}
	
	@Test
	public void verificandoSeListaContemAlgo_contains() {
		List<String> obtido = new ArrayList<>();
		boolean esperado = false;
		
		assertEquals(esperado, obtido.contains("Exemplo"));
	}
	
	@Test
	public void pegandoElementoPorIndice_get() {
		List<String> obtido = new ArrayList<>();
		String esperado = "Exemplo01";
		
		obtido.add("Exemplo01");
		assertEquals(esperado, obtido.get(0));
	}
	
	@Test
	public void pegandoQuantidadeDeElementos_size() {
		List<String> obtido = new ArrayList<>();
		int esperado = 1;
		
		obtido.add("Exemplo01");
		assertEquals(esperado, obtido.size());
	}
	
	@Test
	public void verificandoSeListaEstaVazia_isEmpty() {
		List<String> obtido = new ArrayList<>();
		boolean esperado = false;
		
		obtido.add("Exemplo01");
		assertEquals(esperado, obtido.isEmpty());
	}
	
	@Test
	public void adicionandoListaDentroDaLista_addAll() {
		List<String> listaAntiga = new ArrayList<>();
		List<String> obtido = new ArrayList<>();
		
		listaAntiga.add("Exemplo01");
		listaAntiga.add("Exemplo01");
		listaAntiga.add("Exemplo01");
		obtido.addAll(listaAntiga);
		assertTrue(obtido.equals(listaAntiga));
	}
	
	@Test
	public void definindoValor_set() {
		List<String> obtido = new ArrayList<>();
		String esperado = "Exemplo02";
		
		obtido.add("Exemplo01");
		obtido.set(0, "Exemplo02");
		assertEquals(esperado, obtido.get(0));
	}
}
