package listator;

import java.io.File;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Teste {
	
	public static void main(String[] args) {
		Teste t = new Teste();
		
		/*EXERCÍCIO00
		String empresa = "CWI SOFTWARE";
		ArrayList<String> teste = new ArrayList<String>();
		Empresa emp = new Empresa();
		
		JOptionPane.showMessageDialog(null, empresa.toLowerCase());
		teste.add("errou!");
		arroz(args);
		emp.setNome(empresa);
		*/
		
		//EXERCÍCIO01
		t.buscarDiretorio();
		t.buscarDiretorio("c:/ovo");
		//-------------------------------------------------------------
	}

	public void arroz(String[] a) {
		for (String argumento : a)
			JOptionPane.showMessageDialog(null, argumento);
	}
	
	public void buscarDiretorio() {
		File f = new File("C:/");
		
		JOptionPane.showMessageDialog(null, f.list());
	}
	
	public void buscarDiretorio(String caminho) {
		File f = new File(caminho);
		
		if (f.isDirectory()) {
			JOptionPane.showMessageDialog(null, f.list());
		} else {
			JOptionPane.showMessageDialog(null, f.list());
		}
	}
	
	public String retornaBuscarDiretorio(String caminho) {
		File f = new File(caminho);
		String[] arquivos = f.isDirectory() ?  f.list(): new String[]{"Caminho não especificado"};
		
		return Arrays.toString(arquivos);
	}
}
