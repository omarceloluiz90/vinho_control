package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Adega;
import com.example.vc.boot.dto.AdegaDTO;
import com.example.vc.boot.repository.AdegaRepository;

@Service
public class AdegaService {
	@Autowired
	private AdegaRepository adegaRepository;
	
	public List<AdegaDTO> listarTodos() {
		List<Adega> lAdegas = adegaRepository.findAll();
		List<AdegaDTO> lAdegasDTO = lAdegas.stream().map(obj -> new AdegaDTO(obj)).collect(Collectors.toList());
		return lAdegasDTO; 
    }
	
	public Adega encontrarAdegaPorId(Integer id) {
		Optional<Adega> valor = adegaRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		
		return valor.get();
	}
	
	public Adega inserirAdega(Adega iAdega) {
		return adegaRepository.save(iAdega);
	}
	
	public Adega alterarAdega(Adega iAdega) {
		return adegaRepository.save(iAdega);
	}
	
	public Adega excluirAdega(Integer id) {
		Optional<Adega> valor = adegaRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		adegaRepository.delete(valor.get());
		
		return valor.get();
	}
}

