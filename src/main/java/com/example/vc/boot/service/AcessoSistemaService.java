package com.example.vc.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.AcessoSistema;
import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.AcessoSistemaDTO;
import com.example.vc.boot.repository.AcessoSistemaRepository;

@Service
public class AcessoSistemaService {
	@Autowired
	private AcessoSistemaRepository acessoSistemaRepository;
	@Autowired
	private UsuarioService usuarioService;
		
	public List<AcessoSistemaDTO> listarTodos() {
		List<AcessoSistema> lAcessoSistema = acessoSistemaRepository.findAll();
		List<AcessoSistemaDTO> lAcessoSistemaDTO = lAcessoSistema.stream().map(obj -> new AcessoSistemaDTO(obj)).collect(Collectors.toList());
		return lAcessoSistemaDTO; 
    }
	
	public AcessoSistema encontrarAcessoSistemaPorId(Integer id) {
		Optional<AcessoSistema> valor = acessoSistemaRepository.findById(id);
		AcessoSistema iObj = null;
        if (valor.isPresent())
        	iObj = valor.get();
        else
            throw new RuntimeException("Registro não localizado para o id : " + id);
        return iObj;
	}
	
	public AcessoSistema cadastrarAcessoSistema(Integer idUsuario) {
		Usuario usuarioCad = usuarioService.encontrarUsuarioPorId(idUsuario);
		AcessoSistema iObj = new AcessoSistema();
		iObj.setDataCadastro(LocalDate.now());
		iObj.setUsuarioCad(usuarioCad);
		return iObj;
	}
	
	public AcessoSistema inserirAcessoSistema(AcessoSistema iModelAttr) {
		AcessoSistema iObj = null;
		if(iModelAttr.getId() != null){
			Optional<AcessoSistema> valor = acessoSistemaRepository.findById(iModelAttr.getId());
			if (valor.isPresent()){
				iObj = valor.get();
			}
		} else {
			iObj = cadastrarAcessoSistema(1);
		}
		
		iObj.setDescricao(iModelAttr.getDescricao());
		
		return acessoSistemaRepository.save(iObj);
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

