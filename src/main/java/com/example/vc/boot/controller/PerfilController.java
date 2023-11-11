package com.example.vc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vc.boot.domain.Perfil;
import com.example.vc.boot.dto.PerfilDTO;
import com.example.vc.boot.service.PerfilService;

@RestController()
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
    public List<PerfilDTO> listarTodos() {
		return perfilService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public Perfil encontrarperfilPorId(@PathVariable Integer id) {
		return perfilService.encontrarPerfilPorId(id);
	}
	
	@PostMapping
	public Perfil inserirperfil(@RequestBody Perfil iperfil) {
		return perfilService.inserirPerfil(iperfil);
	}
	
	@PutMapping
	public Perfil alterarperfil(@RequestBody Perfil iperfil) {
		return perfilService.alterarPerfil(iperfil);
	}
	
	@DeleteMapping("/{id}")
	public Perfil excluirperfil(@PathVariable Integer id) {
		return perfilService.excluirPerfil(id);
	}
}
