package com.example.vc.boot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vc.boot.domain.Vinho;
import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.VinhoDTO;
import com.example.vc.boot.repository.VinhoRepository;

@Service
public class VinhoService {
	@Autowired
	private VinhoRepository vinhoRepository;
	@Autowired
	private UsuarioService usuarioService;
		
	public List<VinhoDTO> listarTodos() {
		List<Vinho> lVinho = vinhoRepository.findAll();
		List<VinhoDTO> lVinhoDTO = lVinho.stream().map(obj -> new VinhoDTO(obj)).collect(Collectors.toList());
		return lVinhoDTO; 
    }
	
	public Vinho encontrarVinhoPorId(Integer id) {
		Optional<Vinho> valor = vinhoRepository.findById(id);
		Vinho iObj = null;
        if (valor.isPresent())
        	iObj = valor.get();
        else
            throw new RuntimeException("Registro não localizado para o id : " + id);
        return iObj;
	}
	
	public Vinho cadastrarVinho(Integer idUsuario) {
		Usuario usuarioCad = usuarioService.encontrarUsuarioPorId(idUsuario);
		Vinho iObj = new Vinho();
		iObj.setDataCadastro(LocalDate.now());
		iObj.setUsuarioCad(usuarioCad);
		return iObj;
	}
	
	public Vinho inserirVinho(Vinho iModelAttr) {
		Vinho iObj = null;
		if(iModelAttr.getId() != null){
			Optional<Vinho> valor = vinhoRepository.findById(iModelAttr.getId());
			if (valor.isPresent()){
				iObj = valor.get();
			}
		} else {
			iObj = cadastrarVinho(1);
		}
		
		iObj.setAmadurecimento(iModelAttr.getAmadurecimento());
		iObj.setClassificacao(iModelAttr.getClassificacao());
		iObj.setComentario(iModelAttr.getComentario());
		iObj.setConteudoVolume(iModelAttr.getConteudoVolume());
		iObj.setGustativo(iModelAttr.getGustativo());
		iObj.setNome(iModelAttr.getNome());
		iObj.setOlfativo(iModelAttr.getOlfativo());
		iObj.setPaisRegiao(iModelAttr.getPaisRegiao());
		iObj.setPotencialGuarda(iModelAttr.getPotencialGuarda());
		iObj.setSafra(iModelAttr.getSafra());
		iObj.setTemperaturaServico(iModelAttr.getTemperaturaServico());
		iObj.setTeorAlcoolico(iModelAttr.getTeorAlcoolico());
		iObj.setTipoUva(iModelAttr.getTipoUva());
		
		return vinhoRepository.save(iObj);
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

