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

import com.example.vc.boot.domain.Adega;
import com.example.vc.boot.dto.AdegaDTO;
import com.example.vc.boot.service.AdegaService;

@RestController()
@RequestMapping("/adegas")
public class AdegaController {
	@Autowired
	private AdegaService adegaService;
	
	@GetMapping
    public List<AdegaDTO> listarTodos() {
		return adegaService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public Adega encontrarAdegaPorId(@PathVariable Integer id) {
		return adegaService.encontrarAdegaPorId(id);
	}
	
	@PostMapping
	public Adega inserirAdega(@RequestBody Adega iAdega) {
		return adegaService.inserirAdega(iAdega);
	}
	
	@PutMapping
	public Adega alterarAdega(@RequestBody Adega iAdega) {
		return adegaService.alterarAdega(iAdega);
	}
	
	@DeleteMapping("/{id}")
	public Adega excluirAdega(@PathVariable Integer id) {
		return adegaService.excluirAdega(id);
	}
}
