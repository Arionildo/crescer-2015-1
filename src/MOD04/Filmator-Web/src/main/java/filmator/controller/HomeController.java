package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.model.Genero;

@Controller
public class HomeController {

	public static String usuario;
	private String mensagem;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "inicio";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String iniciarSessao(Model model, String nome) {
//RETORNA A REQUISIÇÃO CASO O USUÁRIO NÃO INFORME UM NOME VÁLIDO
		if (nome == null || nome.trim() == "" || nome.trim().length() < 3) {
			mensagem = "Verifique se o nome que você digitou não está vazio "
					+ "ou possui menos de 3 caracteres";
			model.addAttribute("mensagem", mensagem);
			mensagem = "";
			return "inicio"; 
		}
//APÓS INFORMAR UM NOME VÁLIDO, O USUÁRIO É LEVADO À PRÓXIMA PÁGINA
		
		usuario = nome;
		mensagem = "";
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
}

