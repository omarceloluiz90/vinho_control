package com.example.vc.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.repository.UsuarioRepository;

@Service
public class LoginService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public String encontrarUsuarioPorNomeSenha(String nome, String senha) {
		Usuario valor = usuarioRepository.encontrarUsuarioPorNomeSenha(nome, senha);
		
		if (valor!=null){
			return "redirect:/";
		}
		return "erro";
	}
}
