package filmator;

import java.util.HashMap;

public class Iltube extends Empresa{
	private static HashMap<Genero,Integer> relatorioIT = new HashMap<>();
	
	@Override
	public void gerarRelatorio(Filme filme) {
		genero = filme.getGenero();
		int visualizado = 0;
		
		if (relatorioIT.get(genero) == null) {
			relatorioIT.put(genero, 0);
			visualizado = relatorioIT.get(genero).intValue();
		} else {
			visualizado = relatorioIT.get(genero).intValue();
		}
		
		visualizado++;
		relatorioIT.put(genero, visualizado);
	}
	
	@Override
	public HashMap<Genero,Integer> verRelatorio(){
		return relatorioIT;
	}
	
	@Override
	protected void limparRelatorio(){
		Iltube.relatorioIT = new HashMap<>();
	}
}
