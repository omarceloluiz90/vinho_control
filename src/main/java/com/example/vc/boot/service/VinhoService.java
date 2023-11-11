package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Vinho;
import com.example.vc.boot.dto.VinhoDTO;
import com.example.vc.boot.repository.VinhoRepository;

@Service
public class VinhoService {
	@Autowired
	private VinhoRepository vinhoRepository;
	
	public List<VinhoDTO> listarTodos() {
		List<Vinho> lVinhos = vinhoRepository.findAll();
		List<VinhoDTO> lVinhosDTO = lVinhos.stream().map(obj -> new VinhoDTO(obj)).collect(Collectors.toList());
		return lVinhosDTO; 
    }
	
	public Vinho encontrarVinhoPorId(Integer id) {
		Optional<Vinho> valor = vinhoRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		 
		return valor.get();
	}
	
	public Vinho inserirVinho(Vinho iVinho) {
		return vinhoRepository.save(iVinho);
	}
	
	public Vinho alterarVinho(Vinho iVinho) {
		return vinhoRepository.save(iVinho);
	}
	
	public Vinho excluirVinho(Integer id) {
		Optional<Vinho> valor = vinhoRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		vinhoRepository.delete(valor.get());
		
		return valor.get();
	}
}
