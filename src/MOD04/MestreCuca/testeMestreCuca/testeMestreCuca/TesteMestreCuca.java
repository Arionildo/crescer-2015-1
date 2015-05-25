package testeMestreCuca;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import mestreCuca.Conexao;
import mestreCuca.Ingrediente;
import mestreCuca.Instrucao;
import mestreCuca.MestreCuca;
import mestreCuca.Receita;
import mestreCuca.UnidadeMedida;

import org.junit.Test;



public class TesteMestreCuca {

	@Test
	public void criandoReceita() {
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		instrucao.add(ins01);
		
		Receita r = new Receita("miojo", ingrediente, instrucao);
		
		String esperado = "Nome da Receita: miojo\n"
					+ "Ingredientes: Nome do Ingrediente: Massa / Quantidade: 400.0\n"
					+ "Instruções: 1 - Aqueça a água por 5 minutos; 2 - Ponha a água e a massa numa panela e espere 5 minutos; 3 - Sirva com tempero à gosto.\n";
		String obtido = r.toString();
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void inserindoReceita() {
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		instrucao.add(ins01);
		Receita r = new Receita("miojo", ingrediente, instrucao);
		
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		m.inserir(r);
		
		List<Receita> esperado = new ArrayList<Receita>();
		List<Receita> obtido = new ArrayList<Receita>();
		
		esperado.add(r);
		obtido.addAll(m.getTotalReceitas());
		
		assertEquals(esperado.get(0), obtido.get(0));
	}
	
	@Test
	public void atualizandoReceita() {
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");		
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		instrucao.add(ins01);		
		Receita r01 = new Receita("miojo", ingrediente, instrucao);
		Receita r02 = new Receita("macarrão", ingrediente, instrucao);
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		m.inserir(r01);
		m.atualizar("miojo", r02);
		
		List<Receita> esperado = new ArrayList<Receita>();
		List<Receita> obtido = new ArrayList<Receita>();
		
		esperado.add(r02);
		obtido.addAll(m.getTotalReceitas());		
		
		assertEquals(esperado.get(0), obtido.get(0));		
	}
	
	@Test
	public void excluindoReceita() {
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		instrucao.add(ins01);
		Receita r = new Receita("miojo", ingrediente, instrucao);
		
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		m.inserir(r);
		m.excluir("miojo");
		
		List<Receita> esperado = new ArrayList<Receita>();
		List<Receita> obtido = new ArrayList<Receita>();
		
		obtido.addAll(m.getTotalReceitas());
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void pesquisandoValorTotalDaReceita(){
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Ingrediente ing02 = new Ingrediente("Salsicha", 50, 0.75, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		Instrucao ins02 = new Instrucao("1 - Picar e colocar a salsicha misturada com a massa.");
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		ingrediente.add(ing02);
		instrucao.add(ins01);
		instrucao.add(ins02);
		Receita r = new Receita("miojo com salsicha", ingrediente, instrucao);
		
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		m.inserir(r);
		
		double esperado = 2.75;
		double obtido = m.getValorUmaReceita(r);
				
		assertEquals(esperado, obtido, 0.1);
	}
	
	@Test
	public void pesquisandoValorTotalVariasReceitas(){
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Ingrediente ing02 = new Ingrediente("Salsicha", 50, 0.75, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		Instrucao ins02 = new Instrucao("1 - Picar e colocar a salsicha misturada com a massa.");
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		ingrediente.add(ing02);
		instrucao.add(ins01);
		instrucao.add(ins02);
		Receita r01 = new Receita("miojo com salsicha", ingrediente, instrucao);
		Receita r02 = new Receita("miojo com salsicha", ingrediente, instrucao);
		
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		listaReceitas.add(r01);
		listaReceitas.add(r02);
		
		double esperado = 5.50;
		double obtido = m.getValorListaReceitas(listaReceitas);
				
		assertEquals(esperado, obtido, 0.1);
	}
	
	@Test
	public void proibindoUmaReceita(){
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		instrucao.add(ins01);
		Receita r = new Receita("miojo", ingrediente, instrucao);
		
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		m.inserir(r);
		
		List<Ingrediente> proibidos = new ArrayList<Ingrediente>();
		proibidos.add(ing01);
		
		List<Receita> esperado = new ArrayList<Receita>();
		List<Receita> obtido = new ArrayList<Receita>();
		
		obtido.addAll(m.protecaoAosAlergicos(proibidos));
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void liberandoUmaReceita(){
		Ingrediente ing01 = new Ingrediente("Massa", 400, 2, UnidadeMedida.GRAMA);
		Ingrediente ing02 = new Ingrediente("Salsicha", 50, 0.75, UnidadeMedida.GRAMA);
		Ingrediente ing03 = new Ingrediente("Carne", 50, 2.45, UnidadeMedida.GRAMA);
		Instrucao ins01 = new Instrucao("1 - Aqueça a água por 5 minutos; "
				+ "2 - Ponha a água e a massa numa panela e espere 5 minutos; "
				+ "3 - Sirva com tempero à gosto.");
		Instrucao ins02 = new Instrucao("1 - Picar e colocar a salsicha misturada com a massa.");
		List<Ingrediente> ingrediente = new ArrayList<>();
		List<Ingrediente> ingrediente02 = new ArrayList<>();
		List<Instrucao> instrucao = new ArrayList<>();
		ingrediente.add(ing01);
		ingrediente.add(ing02);
		ingrediente02.add(ing01);
		ingrediente02.add(ing02);
		ingrediente02.add(ing03);
		instrucao.add(ins01);
		instrucao.add(ins02);
		Receita r01 = new Receita("miojo com salsicha", ingrediente02, instrucao);
		Receita r02 = new Receita("miojo com salsicha", ingrediente, instrucao);
		
		List<Receita> listaReceitas = new ArrayList<Receita>();
		MestreCuca m = new MestreCuca(listaReceitas);
		m.inserir(r01);
		m.inserir(r02);
		
		List<Ingrediente> proibidos = new ArrayList<Ingrediente>();
		proibidos.add(ing03);
		
		List<Receita> esperado = new ArrayList<Receita>();
		List<Receita> obtido = new ArrayList<Receita>();
		
		esperado.add(r02);
		obtido.addAll(m.protecaoAosAlergicos(proibidos));
		
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void pesquisandoNoBanco(){
		Conexao c = new Conexao();
		
		String obtido = c.pesquisarNoBanco();
		String esperado = "bolo de abacate";
		
		assertEquals(esperado, obtido);
	}
}