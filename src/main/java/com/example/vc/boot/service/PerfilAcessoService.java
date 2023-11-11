package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.PerfilAcesso;
import com.example.vc.boot.repository.PerfilAcessoRepository;

@Service
public class PerfilAcessoService {
	@Autowired
	private PerfilAcessoRepository perfilAcessoRepository;
	
	public List<PerfilAcesso> listarTodos() {
		return perfilAcessoRepository.findAll(); 
    }
	
	public PerfilAcesso encontrarPerfilAcessoPorId(Integer id) {
		Optional<PerfilAcesso> valor = perfilAcessoRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		 
		return valor.get();
	}
	
	public PerfilAcesso inserirPerfilAcesso(PerfilAcesso iPerfilAcesso) {
		return perfilAcessoRepository.save(iPerfilAcesso);
	}
	
	public PerfilAcesso alterarPerfilAcesso(PerfilAcesso iPerfilAcesso) {
		return perfilAcessoRepository.save(iPerfilAcesso);
	}
	
	public PerfilAcesso excluirPerfilAcesso(Integer id) {
		Optional<PerfilAcesso> valor = perfilAcessoRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		perfilAcessoRepository.delete(valor.get());
		
		return valor.get();
	}
}

