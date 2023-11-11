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

import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.UsuarioDTO;
import com.example.vc.boot.service.UsuarioService;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
    public List<UsuarioDTO> listarTodos() {
		return usuarioService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public Usuario encontrarUsuarioPorId(@PathVariable Integer id) {
		return usuarioService.encontrarUsuarioPorId(id);
	}
	
	@PostMapping
	public Usuario inserirUsuario(@RequestBody Usuario iUsuario) {
		return usuarioService.inserirUsuario(iUsuario);
	}
	
	@PutMapping
	public Usuario alterarUsuario(@RequestBody Usuario iUsuario) {
		return usuarioService.alterarUsuario(iUsuario);
	}
	
	@DeleteMapping("/{id}")
	public Usuario excluirUsuario(@PathVariable Integer id) {
		return usuarioService.excluirUsuario(id);
	}
}
