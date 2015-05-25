package filmator.dao;

import java.util.ArrayList;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {

	private List<Filme> filmes = new ArrayList<Filme>();
	
	public void inserirFilme(Filme filme) {
		this.filmes.add(filme);
	}
	
	public List<Filme> buscaTodosFilmes(){
		//Imagina que estes dados estao vindo do banco
		return filmes;
	}
	
	public boolean isNotDuplicado(Filme filme){
		List<String> nomes = new ArrayList<String>();
		
		for (Filme f : filmes) {
			nomes.add(f.getNome());
		}
		
		return !nomes.contains(filme.getNome());
	}
}
 