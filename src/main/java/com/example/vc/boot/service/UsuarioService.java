package com.example.vc.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Perfil;
import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.UsuarioDTO;
import com.example.vc.boot.repository.PerfilRepository;
import com.example.vc.boot.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PerfilRepository perfilRepository;
		
	public List<UsuarioDTO> listarTodos() {
		List<Usuario> lUsuario = usuarioRepository.findAll();
		List<UsuarioDTO> lUsuarioDTO = lUsuario.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return lUsuarioDTO; 
    }
	
	public Usuario encontrarUsuarioPorId(Integer id) {
		Optional<Usuario> valor = usuarioRepository.findById(id);
		Usuario iObj = null;
        if (valor.isPresent())
        	iObj = valor.get();
        else
            throw new RuntimeException("Registro não localizado para o id : " + id);
        return iObj;
	}
	
	public Usuario cadastrarUsuario(Integer idUsuario) {		
		Usuario iObj = new Usuario();
		iObj.setDataCadastro(LocalDate.now());
		iObj.setIdUsuarioCad(idUsuario);
		return iObj;
	}
	
	public Usuario inserirUsuario(Usuario iModelAttr) {
		Usuario iUsuario = null;
		if(iModelAttr.getId() != null){
			iUsuario = usuarioRepository.findById(iModelAttr.getId()).orElse(null);
		} else {
			iUsuario = cadastrarUsuario(1);
		}
		Perfil iPerfilUsuario = perfilRepository.findById(iModelAttr.getPerfilUsuario().getId()).orElse(null);
		
		if (iPerfilUsuario == null) {
			throw new RuntimeException("Perfil não localizado na base de dados");
		}
						
		iUsuario.setNome(iModelAttr.getNome());
		iUsuario.setSenha(iModelAttr.getSenha());
		iUsuario.setObservacao(iModelAttr.getObservacao());
		iUsuario.setSituacao(iModelAttr.getSituacao());
		iUsuario.setPerfilUsuario(iPerfilUsuario);
						
		return usuarioRepository.save(iUsuario);
	}
	
	public Usuario excluirUsuario(Integer id) {
		Optional<Usuario> valor = usuarioRepository.findById(id);
		
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		usuarioRepository.delete(valor.get());
		
		return valor.get();
	}
}

