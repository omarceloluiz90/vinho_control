package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.AcessoSistema;
import com.example.vc.boot.dto.AcessoSistemaDTO;
import com.example.vc.boot.repository.AcessoSistemaRepository;

@Service
public class AcessoSistemaService {
	@Autowired
	private AcessoSistemaRepository acessoSistemaRepository;
	
	public List<AcessoSistemaDTO> listarTodos() {
		List<AcessoSistema> lAcessoSistema = acessoSistemaRepository.findAll();
		List<AcessoSistemaDTO> lAcessoSistemaDTO = lAcessoSistema.stream().map(obj -> new AcessoSistemaDTO(obj)).collect(Collectors.toList());
		return lAcessoSistemaDTO; 
    }
	
	public AcessoSistema encontrarAcessoSistemaPorId(Integer id) {
		Optional<AcessoSistema> valor = acessoSistemaRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		
		return valor.get();
	}
	
	public AcessoSistema inserirAcessoSistema(AcessoSistema iAcessoSistema) {
		return acessoSistemaRepository.save(iAcessoSistema);
	}
	
	public AcessoSistema alterarAcessoSistema(AcessoSistema iAcessoSistema) {
		return acessoSistemaRepository.save(iAcessoSistema);
	}
	
	public AcessoSistema excluirAcessoSistema(Integer id) {
		Optional<AcessoSistema> valor = acessoSistemaRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		acessoSistemaRepository.delete(valor.get());
		
		return valor.get();
	}
}

