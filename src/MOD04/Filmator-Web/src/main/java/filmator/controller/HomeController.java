package filmator.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class HomeController {

	@Inject
	private UsuarioDao dao = new UsuarioDao();
	@Inject
	private FilmeDao filmedao = new FilmeDao();
	public static Usuario usuario = new Usuario();
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
			mensagem = "O usuário e/ou senha informado(s) não está(ão) registrado(s). "
					+ "Verifique se você digitou tudo corretamente.";
			model.addAttribute("mensagem", mensagem);
			return "inicio";
		}
		
//DEIXA A PRIMEIRA LETRA DO NOME EM MAIÚSCULO PARA EXIBIR NAS PÁGINAS
		usuario = dao.buscarUsuario(nome);
		nome = usuario.getNomeComInicialMaiuscula(nome);		
		usuario.setNome(nome);
		
//O USUÁRIO É LEVADO À PÁGINA CONSULTA.HTML CASO SEJA UM CLIENTE
		if (usuario.getTipoAcesso() == 'C') {			
			model.addAttribute("usuario", usuario.getNome());
			model.addAttribute("filmes",  filmedao.buscaTodosFilmes());
			return "consulta";
		}
		
		model.addAttribute("usuario", usuario.getNome());
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}
	
	@RequestMapping(value = "/consulta", method = RequestMethod.POST)
	public String registrarUsuario(Model model, String nomeRegistro, String senhaRegistro, String emailRegistro) {
		String nome = nomeRegistro.toLowerCase();
		String senha = senhaRegistro.toLowerCase();
		String email = emailRegistro.toLowerCase();
		
		if (nome == null || nome.trim() == "" || nome.trim().length() < 3 ||
				senha == null || senha.trim() == "" || senha.trim().length() < 5) {
			mensagem = "Verifique se o nome e/ou senha que você digitou não está(ão) vazio(s) "
					+ "ou o nome possui menos de 3 caracteres ou "
					+ "a senha possui menos de 5 caracteres.";
			model.addAttribute("mensagem", mensagem);
			return "inicio";
		}
		
		if (!dao.autenticarRegistro(nome, email)) {
			mensagem = "Ops! Você e/ou seu email parece(m) já estar registrado(s)! Tente logar mais uma vez.";
			model.addAttribute("mensagem", mensagem);
			return "inicio";
		}
		
//INSERÇÃO DE DADOS PARA O BANCO DE DADOS
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setEmail(email);
		usuario.setTipoAcesso('C');		
		dao.inserirUsuario(usuario);
		
//ATUALIZAÇÃO DO NOME PARA EXIBIR NAS TELAS
		nome = usuario.getNomeComInicialMaiuscula(nome);
		usuario.setNome(nome);
		
		model.addAttribute("usuario", usuario.getNome());
		model.addAttribute("filmes",  filmedao.buscaTodosFilmes());
		return "consulta";
	}
}