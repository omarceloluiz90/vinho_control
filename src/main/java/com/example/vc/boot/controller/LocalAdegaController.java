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

import com.example.vc.boot.domain.LocalAdega;
import com.example.vc.boot.service.LocalAdegaService;

@RestController()
@RequestMapping("/local_adega")
public class LocalAdegaController {
	@Autowired
	private LocalAdegaService localAdegaService;
	
	@GetMapping
    public List<LocalAdega> listarTodos() {
		return localAdegaService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public LocalAdega encontrarLocalAdegaPorId(@PathVariable Integer id) {
		return localAdegaService.encontrarLocalAdegaPorId(id);
	}
	
	@PostMapping
	public LocalAdega inserirLocalAdega(@RequestBody LocalAdega iLocalAdega) {
		return localAdegaService.inserirLocalAdega(iLocalAdega);
	}
	
	@PutMapping
	public LocalAdega alterarLocalAdega(@RequestBody LocalAdega iLocalAdega) {
		return localAdegaService.alterarLocalAdega(iLocalAdega);
	}
	
	@DeleteMapping("/{id}")
	public LocalAdega excluirLocalAdega(@PathVariable Integer id) {
		return localAdegaService.excluirLocalAdega(id);
	}

}


