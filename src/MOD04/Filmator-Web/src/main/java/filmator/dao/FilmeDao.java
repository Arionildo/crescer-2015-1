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
	
	public void inserirFilme(Filme filme) {
		jdbcTemplate.update("INSERT INTO filmes (nome, genero, ano, foto, sinopse) VALUES (?, ?, ?, ?, ?)", filme.getNome(), filme.getGenero(), filme.getAno(), filme.getFoto(), filme.getSinopse());
	}
	
	public List<Filme> buscaTodosFilmes(){
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
		for (Filme f : buscaTodosFilmes()) {
			if (f.getNome().equals(filme.getNome())) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}
}
 