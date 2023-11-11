package com.example.vc.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Adega;
import com.example.vc.boot.domain.LocalAdega;
import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.domain.Vinho;
import com.example.vc.boot.dto.LocalAdegaDTO;
import com.example.vc.boot.repository.AdegaRepository;
import com.example.vc.boot.repository.LocalAdegaRepository;
import com.example.vc.boot.repository.VinhoRepository;

@Service
public class LocalAdegaService {
	@Autowired
	private LocalAdegaRepository localAdegaRepository;
	@Autowired
	private VinhoRepository vinhoRepository;
	@Autowired
	private AdegaRepository adegaRepository;
	@Autowired
	private UsuarioService usuarioService;
		
	public List<LocalAdegaDTO> listarTodos() {
		List<LocalAdega> lLocalAdega = localAdegaRepository.findAll();
		List<LocalAdegaDTO> lLocalAdegaDTO = lLocalAdega.stream().map(obj -> new LocalAdegaDTO(obj)).collect(Collectors.toList());
		return lLocalAdegaDTO; 
    }
	
	public LocalAdega encontrarLocalAdegaPorId(Integer id) {
		Optional<LocalAdega> valor = localAdegaRepository.findById(id);
		LocalAdega iObj = null;
        if (valor.isPresent())
        	iObj = valor.get();
        else
            throw new RuntimeException("Registro não localizado para o id : " + id);
        return iObj;
	}
	
	public LocalAdega cadastrarLocalAdega(Integer idUsuario) {
		Usuario usuarioCad = usuarioService.encontrarUsuarioPorId(idUsuario);
		LocalAdega iObj = new LocalAdega();
		iObj.setDataCadastro(LocalDate.now());
		iObj.setUsuarioCad(usuarioCad);
		return iObj;
	}
	
	public LocalAdega inserirLocalAdega(LocalAdega iModelAttr) {
		LocalAdega iLocalAdega = null;
		if(iModelAttr.getId() != null){
			iLocalAdega = localAdegaRepository.findById(iModelAttr.getId()).orElse(null);
		} else {
			iLocalAdega = cadastrarLocalAdega(1);
		}
		
		Vinho iVinho = vinhoRepository.findById(iModelAttr.getVinho().getId()).orElse(null);
		
		if (iVinho == null) {
			throw new RuntimeException("Perfil não localizado na base de dados");
		}
		
		Adega iAdega = adegaRepository.findById(iModelAttr.getAdega().getId()).orElse(null);
		
		if (iAdega == null) {
			throw new RuntimeException("Perfil não localizado na base de dados");
		}
		
		iLocalAdega.setAdegaColuna(iModelAttr.getAdegaColuna());
		iLocalAdega.setAdegaFileira(iModelAttr.getAdegaFileira());
		iLocalAdega.setAdegaPosicao(iModelAttr.getAdegaPosicao());
		
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

