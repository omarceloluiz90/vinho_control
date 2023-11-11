package com.example.vc.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.UsuarioDTO;
import com.example.vc.boot.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> listarTodos() {
		List<Usuario> lUsuarios = usuarioRepository.findAll();
		List<UsuarioDTO> lUsuariosDTO = lUsuarios.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return lUsuariosDTO; 
    }
	
	public Usuario encontrarUsuarioPorId(Integer id) {
		Optional<Usuario> valor = usuarioRepository.findById(id);
			
		if (valor.isEmpty()){
			throw new RuntimeException("Registro não localizado na base de dados");
		}
		
		return valor.get();
	}
	
	public Usuario inserirUsuario(Usuario iUsuario) {
		return usuarioRepository.save(iUsuario);
	}
	
	public Usuario alterarUsuario(Usuario iUsuario) {
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
