package filmator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class FilmatorTest {

	@Test
	public void atorPossuiString() {
		Ator a01 = new Ator("Jack");
		Ator a02 = new Ator("Maryanne");
		Ator a03 = new Ator("Johnnie");
		Ator a04 = new Ator("Paul");
		Ator a05 = new Ator("Rebeckie");
		ArrayList<Ator> lista = new ArrayList<Ator>();
		lista.add(a01);
		lista.add(a02);
		lista.add(a03);
		lista.add(a04);
		lista.add(a05);
		
		Filme f01 = new Filme("abc", Genero.AVENTURA, lista);
		ArrayList<Ator> obtido = f01.atorComNome("Mary");
		ArrayList<Ator> esperado = new ArrayList<Ator>();
		esperado.add(a02);
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void reproduzirFilme() {
		Ator a01 = new Ator("Jack");
		Ator a02 = new Ator("Maryanne");
		Ator a03 = new Ator("Johnnie");
		Ator a04 = new Ator("Paul");
		Ator a05 = new Ator("Rebeckie");
		ArrayList<Ator> lista = new ArrayList<Ator>();
		lista.add(a01);
		lista.add(a02);
		lista.add(a03);
		lista.add(a04);
		lista.add(a05);
		
		Filme f01 = new Filme("abc", Genero.AVENTURA, lista);
		Netflox net = new Netflox();
		net.setAcervo(f01);
		
		String obtido = net.reproduzirFilme(f01);
		String esperado = "Reproduzindo o filme abc";
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void geraRelatorioNetflox() {
		Ator a01 = new Ator("Jack");
		Ator a02 = new Ator("Maryanne");
		Ator a03 = new Ator("Johnnie");
		Ator a04 = new Ator("Paul");
		Ator a05 = new Ator("Rebeckie");
		ArrayList<Ator> lista = new ArrayList<Ator>();
		lista.add(a01);
		lista.add(a02);
		lista.add(a03);
		lista.add(a04);
		lista.add(a05);
		
		Filme f01 = new Filme("abc", Genero.AVENTURA, lista);
		Netflox net = new Netflox();
		net.setAcervo(f01);
		net.limparRelatorio();
		net.reproduzirFilme(f01);
		net.reproduzirFilme(f01);
		
		HashMap<Genero,Integer> obtido = net.verRelatorio();
		HashMap<Genero,Integer> esperado = new HashMap<>();
		esperado.put(Genero.AVENTURA, 2);
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void geraRelatorioIltube() {
		Ator a01 = new Ator("Jack");
		Ator a02 = new Ator("Maryanne");
		Ator a03 = new Ator("Johnnie");
		Ator a04 = new Ator("Paul");
		Ator a05 = new Ator("Rebeckie");
		ArrayList<Ator> lista = new ArrayList<Ator>();
		lista.add(a01);
		lista.add(a02);
		lista.add(a03);
		lista.add(a04);
		lista.add(a05);
		
		Filme f01 = new Filme("abc", Genero.AVENTURA, lista);
		Filme f02 = new Filme("qwe", Genero.DRAMA, lista);
		Iltube il = new Iltube();
		il.setAcervo(f01);
		il.setAcervo(f02);
		il.limparRelatorio();
		il.reproduzirFilme(f01);
		il.reproduzirFilme(f02);
		
		HashMap<Genero,Integer> obtido = il.verRelatorio();
		HashMap<Genero,Integer> esperado = new HashMap<>();
		esperado.put(Genero.AVENTURA, 1);
		esperado.put(Genero.DRAMA, 1);
		
		assertEquals(esperado, obtido);
	}

}
