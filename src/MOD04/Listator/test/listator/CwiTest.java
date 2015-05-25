package listator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CwiTest {
	
	@Test
	public void quandoExecutaToLowerCase() throws Exception {
		assert(false);
	}
	
	@Test
	public void recebeNomeDiretorioEImprime() {
		Teste t = new Teste();
		
		String obtido = t.retornaBuscarDiretorio("C:/Users/projetocrescer/Desktop/CWI");
		String esperado = "[.git, Aula1]";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void naoRecebeNomeDiretorio() {
		Teste t = new Teste();
		
		String obtido = t.retornaBuscarDiretorio("");
		String esperado = "[Caminho não especificado]";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void recebeNomeDiretorioIncorreto() {
		Teste t = new Teste();
		
		String obtido = t.retornaBuscarDiretorio("");
		String esperado = "[Caminho não especificado]";
		
		assertEquals(esperado, obtido);
	}	
}
