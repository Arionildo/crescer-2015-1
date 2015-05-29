package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AvaliacaoController {
	
	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public String atualizarAvaliacao(Model model) {
		
		System.out.println("Entrou no método avaliar");
		
		return "";
	}
}