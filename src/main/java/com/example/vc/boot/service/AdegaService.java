package com.example.vc.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Adega;
import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.AdegaDTO;
import com.example.vc.boot.repository.AdegaRepository;

@Service
public class AdegaService {
	@Autowired
	private AdegaRepository adegaRepository;
	@Autowired
	private UsuarioService usuarioService;
		
	public List<AdegaDTO> listarTodos() {
		List<Adega> lAdega = adegaRepository.findAll();
		List<AdegaDTO> lAdegaDTO = lAdega.stream().map(obj -> new AdegaDTO(obj)).collect(Collectors.toList());
		return lAdegaDTO; 
    }
	
	public Adega encontrarAdegaPorId(Integer id) {
		Optional<Adega> valor = adegaRepository.findById(id);
		Adega iObj = null;
        if (valor.isPresent())
        	iObj = valor.get();
        else
            throw new RuntimeException("Registro não localizado para o id : " + id);
        return iObj;
	}
	
	public Adega cadastrarAdega(Integer idUsuario) {
		Usuario usuarioCad = usuarioService.encontrarUsuarioPorId(idUsuario);
		Adega iObj = new Adega();
		iObj.setDataCadastro(LocalDate.now());
		iObj.setUsuarioCad(usuarioCad);
		return iObj;
	}
	
	public Adega inserirAdega(Adega iModelAttr) {
		Adega iObj = null;
		if(iModelAttr.getId() != null){
			Optional<Adega> valor = adegaRepository.findById(iModelAttr.getId());
			if (valor.isPresent()){
				iObj = valor.get();
			}
		} else {
			iObj = cadastrarAdega(1);
		}
		
		iObj.setCodigo(iModelAttr.getCodigo());
		iObj.setDescricao(iModelAttr.getDescricao());
		iObj.setTotFileiras(iModelAttr.getTotColunas());
		iObj.setTotColunas(iModelAttr.getTotColunas());
		iObj.setTotPosicoes(iModelAttr.getTotPosicoes());
		iObj.setObservacao(iModelAttr.getObservacao());
		iObj.setSituacao(iModelAttr.getSituacao());
		
		return adegaRepository.save(iObj);
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

