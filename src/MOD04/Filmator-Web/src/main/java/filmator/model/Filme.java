package filmator.model;

public class Filme {

	private String nome;
	@SuppressWarnings("unused")
	private String genero;
	@SuppressWarnings("unused")
	private String ano;
	@SuppressWarnings("unused")
	private String foto;
	@SuppressWarnings("unused")
	private String sinopse;
	
	public Filme(String nome, String genero, String ano, String foto, String sinopse){
		this.nome = nome;
		this.genero = genero;
		this.ano = ano;
		this.foto = foto;
		this.sinopse = sinopse;
	}
	
	public String getNome() {
		return nome;
	}
}
