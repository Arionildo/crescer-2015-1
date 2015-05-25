package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class CadastroController {

	private FilmeDao dao = new FilmeDao();
	private String mensagem;
	
	@RequestMapping(value = "/consulta", method = RequestMethod.POST)
	public String adicionarFilme(Model model, String nome, String genero, String ano, String foto, String sinopse) {
		if (nome.trim() == ""
				|| nome.trim().length() < 3
				|| ano.trim() == ""
				|| ano.trim().length() != 4
				|| foto.trim() == ""
				|| sinopse.trim() == "") {
			mensagem = "Verifique se nenhum campo está vazio "
					+ "ou possui menos de 3 caracteres(4, para o ano).";
			model.addAttribute("mensagem", mensagem);
			return "cadastro";
		}
		
		Filme filme = new Filme(nome, genero, ano, foto, sinopse);
//IMPEDE QUE HAJA FILME COM NOME DUPLICADO
		if (dao.isNotDuplicado(filme)) dao.inserirFilme(filme);
		
		model.addAttribute("usuario", HomeController.usuario);
		model.addAttribute("filmes",  dao.buscaTodosFilmes());
		return "consulta";
	}
}

