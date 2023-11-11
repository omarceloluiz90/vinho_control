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

import com.example.vc.boot.domain.AcessoSistema;
import com.example.vc.boot.dto.AcessoSistemaDTO;
import com.example.vc.boot.service.AcessoSistemaService;

@RestController()
@RequestMapping("/acesso_sistema")
public class AcessoSistemaController {
	@Autowired
	private AcessoSistemaService acessoSistemaService;
	
	@GetMapping
    public List<AcessoSistemaDTO> listarTodos() {
		return acessoSistemaService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public AcessoSistema encontrarAcessoSistemaPorId(@PathVariable Integer id) {
		return acessoSistemaService.encontrarAcessoSistemaPorId(id);
	}
	
	@PostMapping
	public AcessoSistema inserirAcessoSistema(@RequestBody AcessoSistema iAcessoSistema) {
		return acessoSistemaService.inserirAcessoSistema(iAcessoSistema);
	}
	
	@PutMapping
	public AcessoSistema alterarAcessoSistema(@RequestBody AcessoSistema iAcessoSistema) {
		return acessoSistemaService.alterarAcessoSistema(iAcessoSistema);
	}
	
	@DeleteMapping("/{id}")
	public AcessoSistema excluirAcessoSistema(@PathVariable Integer id) {
		return acessoSistemaService.excluirAcessoSistema(id);
	}

}

