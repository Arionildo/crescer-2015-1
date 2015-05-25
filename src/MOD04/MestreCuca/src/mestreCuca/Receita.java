package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita{
	private String nome;
	private List<Ingrediente> ingrediente = new ArrayList<>();
	private List<Instrucao> instrucao = new ArrayList<>();
	
	public Receita(String nome, List<Ingrediente> ingrediente, List<Instrucao> instrucao) {
		this.nome = nome;
		this.ingrediente.addAll(ingrediente);
		this.instrucao.addAll(instrucao);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String listarIngredientes(){
		String texto = "";
		for (Ingrediente i : ingrediente) {
			texto += "Nome do Ingrediente: "+ i.getNome()
					+" / Quantidade: "+ i.getQuantidade()
					+"\n";
		}
		
		return texto;
	}
	
	public String listarInstrucoes(){
		String texto = "";
		for (Instrucao i : instrucao) {
			texto += i.getDescricao() +"\n";
		}
		
		return texto;
	}
	
	public double getValorTotalIngredientes(){
		double valor = 0.0;
		for (Ingrediente i : ingrediente) {
			valor += i.getValor();
		}
		return valor;
	}
	
	public List<Ingrediente> getListaIngredientes(){
		return ingrediente;
	}
	
	@Override
	public String toString() {
		String texto = String.format("Nome da Receita: %s\n"
									+ "Ingredientes: %s"
									+ "Instruções: %s"
							, this.nome, this.listarIngredientes(), this.listarInstrucoes());
		return texto;
	}
}