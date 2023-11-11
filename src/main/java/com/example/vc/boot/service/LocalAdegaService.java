package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.LocalAdega;
import com.example.vc.boot.repository.LocalAdegaRepository;

@Service
public class LocalAdegaService {
	@Autowired
	private LocalAdegaRepository localAdegaRepository;
	
	public List<LocalAdega> listarTodos() {
		return localAdegaRepository.findAll(); 
    }
	
	public LocalAdega encontrarLocalAdegaPorId(Integer id) {
		Optional<LocalAdega> valor = localAdegaRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		 
		return valor.get();
	}
	
	public LocalAdega inserirLocalAdega(LocalAdega iLocalAdega) {
		return localAdegaRepository.save(iLocalAdega);
	}
	
	public LocalAdega alterarLocalAdega(LocalAdega iLocalAdega) {
		return localAdegaRepository.save(iLocalAdega);
	}
	
	public LocalAdega excluirLocalAdega(Integer id) {
		Optional<LocalAdega> valor = localAdegaRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		localAdegaRepository.delete(valor.get());
		
		return valor.get();
	}
}

