package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AvaliacaoController {
	@Inject
	//private FilmeDao filmedao = new FilmeDao();
	
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	public String atualizarAvaliacao(Model model) {
		return "/";
	}
}