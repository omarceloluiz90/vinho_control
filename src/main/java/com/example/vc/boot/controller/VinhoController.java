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

import com.example.vc.boot.domain.Vinho;
import com.example.vc.boot.dto.VinhoDTO;
import com.example.vc.boot.service.VinhoService;

@RestController()
@RequestMapping("/vinhos")
public class VinhoController {
	@Autowired
	private VinhoService vinhoService;
	
	@GetMapping
    public List<VinhoDTO> listarTodos() {
		return vinhoService.listarTodos();
    }
	
	@GetMapping("/{id}")
	public Vinho encontrarVinhoPorId(@PathVariable Integer id) {
		return vinhoService.encontrarVinhoPorId(id);
	}
	
	@PostMapping
	public Vinho inserirVinho(@RequestBody Vinho iVinho) {
		return vinhoService.inserirVinho(iVinho);
	}
	
	@PutMapping
	public Vinho alterarVinho(@RequestBody Vinho iVinho) {
		return vinhoService.alterarVinho(iVinho);
	}
	
	@DeleteMapping("/{id}")
	public Vinho excluirVinho(@PathVariable Integer id) {
		return vinhoService.excluirVinho(id);
	}

}

