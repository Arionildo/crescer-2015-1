package filmator;

import java.util.HashMap;

public class Netflox extends Empresa{
	private static HashMap<Genero,Integer> relatorioNF = new HashMap<>();
	
	@Override
	public void gerarRelatorio(Filme filme) {
		genero = filme.getGenero();
		int visualizado = 0;
		
		if (relatorioNF.get(genero) == null) {
			relatorioNF.put(genero, 0);
			visualizado = relatorioNF.get(genero).intValue();
		} else {
			visualizado = relatorioNF.get(genero).intValue();
		}
		
		visualizado++;
		relatorioNF.put(genero, visualizado);
	}
	
	@Override
	public HashMap<Genero,Integer> verRelatorio(){
		return relatorioNF;
	}
	
	@Override
	protected void limparRelatorio(){
		Netflox.relatorioNF = new HashMap<>();
	}
}