package filmator;

import java.util.ArrayList;

public class Filme {
	private String nome;
	private Genero genero;
	private ArrayList<Ator> elenco = new ArrayList<Ator>();
	
	public Filme(String nome, Genero genero, ArrayList<Ator> elenco) {
		this.nome = nome;
		this.genero = genero;
		this.elenco = elenco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public ArrayList<Ator> getElenco() {
		return elenco;
	}

	public void setElenco(ArrayList<Ator> a) {
		for (Ator ator : a) {
			this.elenco.add(ator);
		}
	}
	
	public ArrayList<Ator> atorComNome(String nome) {
		ArrayList<Ator> atores = new ArrayList<Ator>();
		
		for (Ator a : elenco) {
			if (a.getNome().toLowerCase().contains(nome.toLowerCase())) atores.add(a);
		}
		return atores;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
