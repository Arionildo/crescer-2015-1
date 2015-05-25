package filmator;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Empresa {
	private static HashMap<Genero,Integer> relatorio = new HashMap<>();
	protected Genero genero;
	protected ArrayList<Filme> acervo = new ArrayList<Filme>();
	
	protected String reproduzirFilme(Filme filme) {
		String log = "";
		
		if (acervo.contains(filme)) {
			log = "Reproduzindo o filme "+ filme.getNome();
		} else {
			log = "O filme "+ filme +" n�o est� no nosso acervo ainda";
		}
		
		gerarRelatorio(filme);
		
		return log;
	}
	
	protected void gerarRelatorio(Filme filme) {
		//CADA FILHO DEVE GERAR SEU PR�PRIO RELAT�RIO
	}
	
	protected HashMap<Genero,Integer> verRelatorio(){
		return relatorio;
	}
	
	protected void limparRelatorio(){
		//CADA FILHO DEVE LIMPAR SEU PR�PRIO RELAT�RIO
	}
	
	protected void setAcervo(Filme filme) {
		this.acervo.add(filme);
	}
}
