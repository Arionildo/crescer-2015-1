package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Filme;

@Component
public class FilmeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	//private List<Filme> filmes = new ArrayList<Filme>();
	
	public void inserirFilme(Filme filme) {
		jdbcTemplate.update("INSERT INTO filmes (nome, genero, ano, foto, sinopse) VALUES (?, ?, ?, ?, ?)", filme.getNome(), filme.getGenero(), filme.getAno(), filme.getFoto(), filme.getSinopse());
		//this.filmes.add(filme);
	}
	
	public List<Filme> buscaTodosFilmes(){
		//return filmes;
		return jdbcTemplate.query("SELECT * FROM filmes", (ResultSet rs, int rowNum) -> {	
			Filme filme = new Filme();
			filme.setNome(rs.getString("nome"));
			filme.setGenero(rs.getString("genero"));
			filme.setAno(rs.getString("ano"));
			filme.setFoto(rs.getString("foto"));
			filme.setSinopse(rs.getString("sinopse"));
			return filme;
		});
	}
	
	public boolean isNotDuplicado(Filme filme){
		/*List<String> nomes = new ArrayList<String>();
		
		for (Filme f : filmes) {
			nomes.add(f.getNome());
		}
		
		return !nomes.contains(filme.getNome());
		*/
		return true;
	}
}
 