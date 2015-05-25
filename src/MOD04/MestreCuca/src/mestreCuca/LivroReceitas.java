package mestreCuca;

import java.util.List;

public interface LivroReceitas {
	void inserir(Receita receita);
	void atualizar(String nome, Receita receitaAtualizada);
	void excluir(String nome);
	List<Receita> getTotalReceitas();
	Receita buscaReceitaPeloNome(String nome);
}
