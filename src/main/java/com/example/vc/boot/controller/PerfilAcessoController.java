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

import com.example.vc.boot.domain.PerfilAcesso;
import com.example.vc.boot.service.PerfilAcessoService;

@RestController()
@RequestMapping("/perfil_acesso")
public class PerfilAcessoController {
	@Autowired
	private PerfilAcessoService perfilAcessoService;
	
	@GetMapping
    public List<PerfilAcesso> listarTodos() {
		return perfilAcessoService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public PerfilAcesso encontrarPerfilAcessoPorId(@PathVariable Integer id) {
		return perfilAcessoService.encontrarPerfilAcessoPorId(id);
	}
	
	@PostMapping
	public PerfilAcesso inserirPerfilAcesso(@RequestBody PerfilAcesso iPerfilAcesso) {
		return perfilAcessoService.inserirPerfilAcesso(iPerfilAcesso);
	}
	
	@PutMapping
	public PerfilAcesso alterarPerfilAcesso(@RequestBody PerfilAcesso iPerfilAcesso) {
		return perfilAcessoService.alterarPerfilAcesso(iPerfilAcesso);
	}
	
	@DeleteMapping("/{id}")
	public PerfilAcesso excluirPerfilAcesso(@PathVariable Integer id) {
		return perfilAcessoService.excluirPerfilAcesso(id);
	}

}
