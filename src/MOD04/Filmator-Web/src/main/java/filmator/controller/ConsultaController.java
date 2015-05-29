package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class ConsultaController {
	@Inject
	private FilmeDao filmedao = new FilmeDao();
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String voltarAoCadastro(HttpSession session, Model model) {
		Usuario usuario = new Usuario();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		
//O USUÁRIO É LEVADO À PÁGINA CONSULTA.HTML CASO SEJA UM CLIENTE
		if (usuario.getTipoAcesso() == 'C') {
			model.addAttribute("usuario", usuarioLogado);
			model.addAttribute("filmes",  filmedao.buscaTodosFilmes());
			return "consulta";
		}
		
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
}