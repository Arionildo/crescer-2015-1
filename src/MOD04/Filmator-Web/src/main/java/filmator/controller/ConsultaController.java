package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;

@Controller
public class ConsultaController {
	@Inject
	private FilmeDao filmedao = new FilmeDao();
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String voltarAoCadastro(Model model) {
		
//O USUÁRIO É LEVADO À PÁGINA CONSULTA.HTML CASO SEJA UM CLIENTE
		if (HomeController.usuario.getTipoAcesso() == 'C') {
			String nome = "";
			HomeController.usuario.getNomeComInicialMaiuscula(nome);
			HomeController.usuario.setNome(nome);
			
			model.addAttribute("usuario", HomeController.usuario.getNome());
			model.addAttribute("filmes",  filmedao.buscaTodosFilmes());
			return "consulta";
		}
				
		model.addAttribute("usuario", HomeController.usuario.getNome());
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
}