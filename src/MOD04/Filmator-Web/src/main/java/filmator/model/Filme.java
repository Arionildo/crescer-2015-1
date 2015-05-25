package filmator.model;

public class Filme {

	private String nome;
	private String genero;
	private String ano;
	private String foto;
	private String sinopse;
	
	public Filme(String nome, String genero, String ano, String foto, String sinopse){
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
		this.foto = foto;
		this.sinopse = sinopse;
	}
	
	public Filme() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
}
