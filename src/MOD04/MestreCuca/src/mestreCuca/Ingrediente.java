package mestreCuca;

public class Ingrediente {
	private String nome;
	private double quantidade;
	private double valor;
	private UnidadeMedida unidadeMedida;
	
	public Ingrediente(String nome,	double quantidade, double valor, UnidadeMedida unidadeMedida) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
		this.unidadeMedida = unidadeMedida;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}