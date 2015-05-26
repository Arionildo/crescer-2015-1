package filmator.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import filmator.model.Usuario;

@Component
public class UsuarioDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public void inserirUsuario(Usuario usuario) {
		if (autenticarRegistro(usuario.getNome(), usuario.getEmail())) return; 
		jdbcTemplate.update("INSERT INTO usuarios (nome, senha, email, tipoAcesso) VALUES (?, ?, ?, ?)", usuario.getNome(), usuario.getSenha(), usuario.getEmail(), usuario.getTipoAcesso());
	}
	
	
	public boolean autenticarUsuario(String nome, String senha){
		List<Usuario> usuario = jdbcTemplate.query("SELECT nome, senha FROM usuarios WHERE nome = '"+ nome.toLowerCase() +"' AND senha = '"+ senha.toLowerCase() +"'", (ResultSet rs, int rowNum) -> {
			Usuario u = new Usuario();
			u.setNome(rs.getString("nome"));
			u.setSenha(rs.getString("senha"));
			return u;
		});
		
//SE NÃO HOUVER USUÁRIO COM O MESMO NOME E SENHA INFORMADOS, O USUÁRIO DEVERÁ SE REGISTRAR ANTES
		return usuario.isEmpty() ? false : true;
	}
	
	public boolean autenticarRegistro(String nome, String email){
		List<Usuario> usuario = jdbcTemplate.query("SELECT nome, senha FROM usuarios WHERE nome = '"+ nome.toLowerCase() +"' AND senha = '"+ email.toLowerCase() +"'", (ResultSet rs, int rowNum) -> {
			Usuario u = new Usuario();
			u.setNome(rs.getString("nome"));
			u.setSenha(rs.getString("senha"));
			return u;
		});

//SE NÃO HOUVER USUÁRIO COM O MESMO NOME E EMAIL INFORMADOS, O USUÁRIO PODERÁ SER REGISTRADO
		return usuario.isEmpty() ? true : false;
	}

	public List<Usuario> buscaTodosUsuarios(){
		return jdbcTemplate.query("SELECT * FROM usuarios", (ResultSet rs, int rowNum) -> {
			Usuario usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTipoAcesso(rs.getString("tipoAcesso").charAt(0));
			return usuario;
		});
	}
	
	public boolean isNotDuplicado(Usuario usuario){
		return !buscaTodosUsuarios().contains(usuario);
	}
}
 