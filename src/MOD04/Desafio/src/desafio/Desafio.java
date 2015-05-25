package desafio;

public class Desafio {

	public static void main(String[] args) {
		String palavra = "CWI SoFtware";
		
		System.out.println("As letras maiúsculas entradas na palavra "+ palavra +" foram:\n"+ indiceMaiusculas(palavra));
	}
	
	public static String indiceMaiusculas(String texto) {
		int tamanhoDaPalavra = texto.length();
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < tamanhoDaPalavra; i++) {
			if (Character.isUpperCase(texto.charAt(i))) {
				s.append(texto.charAt(i));
				s.append("\n");
			}
		}
		return s.toString();
	}

}
