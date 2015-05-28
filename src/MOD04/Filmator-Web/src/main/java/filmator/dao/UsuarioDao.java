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
		jdbcTemplate.update("INSERT INTO usuarios (nome, senha, email, tipoAcesso) VALUES (?, ?, ?, ?)", usuario.getNome(), usuario.getSenha(), usuario.getEmail(), usuario.getTipoAcesso());
	}
	
	
	public boolean autenticarUsuario(String nome, String senha){
		List<Usuario> usuario = jdbcTemplate.query("SELECT nome, senha FROM usuarios WHERE nome = ? AND senha = ?", (ResultSet rs, int rowNum) -> {
			Usuario u = new Usuario();
			u.setNome(rs.getString("nome"));
			u.setSenha(rs.getString("senha"));
			return u;
		}, nome.toLowerCase(), senha.toLowerCase());
		
//SE NÃO HOUVER USUÁRIO COM O MESMO NOME E SENHA INFORMADOS, O USUÁRIO DEVERÁ SE REGISTRAR ANTES
		return usuario.isEmpty() ? false : true;
	}
	
	public boolean autenticarRegistro(String nome, String email){
		List<Usuario> usuario = jdbcTemplate.query("SELECT nome, email FROM usuarios WHERE nome = ? OR email = ?", (ResultSet rs, int rowNum) -> {
			Usuario u = new Usuario();
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			return u;
		}, nome, email);
		
//SE NÃO HOUVER USUÁRIO COM O MESMO NOME E EMAIL INFORMADOS, O USUÁRIO PODERÁ SER REGISTRADO
		return usuario.isEmpty() ? true : false;
	}
	
	public Usuario buscarUsuario(String nome) {
		return jdbcTemplate.query("SELECT * FROM usuarios WHERE nome = ?", (ResultSet rs, int rowNum) -> {
			Usuario usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			usuario.setTipoAcesso(rs.getString("tipoAcesso").charAt(0));
			return usuario;
		}, nome).get(0);
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
 