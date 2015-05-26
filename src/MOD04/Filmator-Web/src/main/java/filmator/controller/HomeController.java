package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.UsuarioDao;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class HomeController {

	@Inject
	private UsuarioDao dao = new UsuarioDao();
	public static String usuario;
	private String mensagem;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "inicio";
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String iniciarSessao(Model model, String nome, String senha) {
//RETORNA A REQUISIÇÃO CASO O USUÁRIO NÃO INFORME UM NOME VÁLIDO
		if (nome == null || nome.trim() == "" || nome.trim().length() < 3) {
			mensagem = "Verifique se o nome que você digitou não está vazio "
					+ "ou possui menos de 3 caracteres.";
			model.addAttribute("mensagem", mensagem);
			return "inicio"; 
		}
//RETORNA A REQUISIÇÃO CASO O USUÁRIO NÃO INFORME UM NOME JÁ REGISTRADO		
		if (!dao.autenticarUsuario(nome, senha)) {
			mensagem = "O usuário e/ou senha informado(s) não está(ão) registrado(o). Verifique se você digitou tudo corretamente.";
			model.addAttribute("mensagem", mensagem);
			return "inicio";
		}
//APÓS INFORMAR UM NOME VÁLIDO, O USUÁRIO É LEVADO À PRÓXIMA PÁGINA
		
		usuario = nome;
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
	
	@RequestMapping(value = "/registrado", method = RequestMethod.POST)
	public String sucessoAoRegistrar(Model model, String nome, String senha, String email) {
		if (nome == null || nome.trim() == "" || nome.trim().length() < 3 ||
			senha == null || senha.trim() == "" || senha.trim().length() < 5) {
			mensagem = "Verifique se o nome e/ou senha que você digitou não está(ão) vazio(s) "
					+ "ou possui menos de 5 caracteres.";
			model.addAttribute("mensagem", mensagem);
			return "inicio"; 
		}
		Usuario u = new Usuario(nome, senha, email, 'C');
		if (!dao.autenticarRegistro(nome, email)) {
			mensagem = "Ops! Você parece já estar registrado! Tente logar mais uma vez!";
			model.addAttribute("mensagem", mensagem);
			return "inicio"; 
		}
		dao.inserirUsuario(u);
		usuario = nome;
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("generos", Genero.values());
		return "redirect:cadastro";
	}
}