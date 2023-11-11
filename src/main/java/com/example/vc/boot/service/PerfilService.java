package com.example.vc.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Perfil;
import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.PerfilDTO;
import com.example.vc.boot.repository.PerfilRepository;

@Service
public class PerfilService {
	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private UsuarioService usuarioService;
		
	public List<PerfilDTO> listarTodos() {
		List<Perfil> lPerfil = perfilRepository.findAll();
		List<PerfilDTO> lPerfilDTO = lPerfil.stream().map(obj -> new PerfilDTO(obj)).collect(Collectors.toList());
		return lPerfilDTO; 
    }
	
	public Perfil encontrarPerfilPorId(Integer id) {
		Optional<Perfil> valor = perfilRepository.findById(id);
		Perfil iObj = null;
        if (valor.isPresent())
        	iObj = valor.get();
        else
            throw new RuntimeException("Registro não localizado para o id : " + id);
        return iObj;
	}
	
	public Perfil cadastrarPerfil(Integer idUsuario) {
		Usuario usuarioCad = usuarioService.encontrarUsuarioPorId(idUsuario);
		Perfil iObj = new Perfil();
		iObj.setDataCadastro(LocalDate.now());
		iObj.setUsuarioCad(usuarioCad);
		return iObj;
	}
	
	public Perfil inserirPerfil(Perfil iModelAttr) {
		Perfil iObj = null;
		if(iModelAttr.getId() != null){
			Optional<Perfil> valor = perfilRepository.findById(iModelAttr.getId());
			if (valor.isPresent()){
				iObj = valor.get();
			}
		} else {
			iObj = cadastrarPerfil(1);
		}
		
		iObj.setNome(iModelAttr.getNome());
		iObj.setObservacao(iModelAttr.getObservacao());
		iObj.setSituacao(iModelAttr.getSituacao());
		
		return perfilRepository.save(iObj);
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

