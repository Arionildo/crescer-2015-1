package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.model.Genero;

@Controller
public class ConsultaController {
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String voltarAoCadastro(Model model) {
		model.addAttribute("usuario", HomeController.usuario);
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
}

