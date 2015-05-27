package filmator.model;

public class Usuario {

	private String nome;
	private String senha;
	private String email;
	private char tipoAcesso;
	
	public Usuario(String nome, String senha, String email, char tipoAcesso) {
		super();
		this.nome = nome.toLowerCase();
		this.senha = senha.toLowerCase();
		this.email = email.toLowerCase();
		this.tipoAcesso = tipoAcesso;
	}

	public Usuario() {
		
	}
	
	public String getNomeComInicialMaiuscula(String nome) {
		return nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getTipoAcesso() {
		return tipoAcesso;
	}

	public void setTipoAcesso(char tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
}
