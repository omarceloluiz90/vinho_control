package com.example.vc.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String index() {
		return "/login/index";
	}
	
	@PostMapping("/logar")
	public String logar(Model model, Usuario usuario, String lembrar) {
		String valor = loginService.encontrarUsuarioPorNomeSenha(usuario.getNome(), usuario.getSenha());
		
		if (valor=="erro") {
			model.addAttribute("erro", "ATENÇÃO!! Usuario não foi localizado.");
			return "/login/index";
		}
		else {
			return valor;
		}		
		
	}
}
