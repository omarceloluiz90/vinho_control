package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Perfil;
import com.example.vc.boot.dto.PerfilDTO;
import com.example.vc.boot.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<PerfilDTO> listarTodos() {
		List<Perfil> lPerfil = perfilRepository.findAll();
		List<PerfilDTO> lPerfilDTO = lPerfil.stream().map(obj -> new PerfilDTO(obj)).collect(Collectors.toList());
		return lPerfilDTO; 
    }
	
	public Perfil encontrarPerfilPorId(Integer id) {
		Optional<Perfil> valor = perfilRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		
		return valor.get();
	}
	
	public Perfil inserirPerfil(Perfil iPerfil) {
		return perfilRepository.save(iPerfil);
	}
	
	public Perfil alterarPerfil(Perfil iPerfil) {
		return perfilRepository.save(iPerfil);
	}
	
	public Perfil excluirPerfil(Integer id) {
		Optional<Perfil> valor = perfilRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		perfilRepository.delete(valor.get());
		
		return valor.get();
	}
}
