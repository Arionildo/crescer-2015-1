package mestreCuca;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MestreCucaJSON implements LivroReceitas {
	private List<Receita> receitas = new ArrayList<>();
	private ObjectMapper map = new ObjectMapper();
	private String url;
	
	public MestreCucaJSON(String url) throws IOException {
		this.url = url;
		carregarReceita(url);
	}
	
	@SuppressWarnings("unchecked")
	private void carregarReceita(String url) throws IOException {
		File arquivo = new File(url);
		if (arquivo.exists()) this.setReceitas(map.readValue(arquivo, List.class));
	}
	
	private void salvarReceita() {
		try {
			map.writeValue(new File(url), this.receitas);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void inserir(Receita receita) {
		this.receitas.add(receita);
		salvarReceita();
	}

	

	@Override
	public void atualizar(String nome, Receita receitaAtualizada) {
		if (nome.replaceAll(" ", "").length() > 0 && receitaAtualizada != null) {
			for (Receita r : this.receitas) {
				if (r.getNome() == nome) {
					int nroReceita = this.receitas.indexOf(r);
					this.receitas.set(nroReceita, receitaAtualizada);
					break;
				}
			}
			salvarReceita();
		}
		
	}

	@Override
	public void excluir(String nome) {
		if (nome.replaceAll(" ", "").length() > 0) {
			for (Receita r : this.receitas) {
				if (r.getNome() == nome) {
					this.receitas.remove(r);
					break;
				}
			}
			salvarReceita();
		}
	}

	@Override
	public List<Receita> getTotalReceitas() {
		return receitas;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		if (nome.replaceAll(" ", "").length() > 0) {
			int nroReceita = this.receitas.indexOf(nome);
			this.receitas.remove(nroReceita);
			return receitas.get(nroReceita);
		} else {
			return null;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	private void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}
}
