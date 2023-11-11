package com.example.vc.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.vc.boot.domain.Perfil;
import com.example.vc.boot.dto.PerfilDTO;
import com.example.vc.boot.service.PerfilService;


@Controller
@RequestMapping(value="/perfil")
public class PerfilController {
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping(value="/")
    public ModelAndView listarTodos() {
		List<PerfilDTO> lPerfilDTO = perfilService.listarTodos();
		ModelAndView mav = new ModelAndView("/perfil/index");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("perfil", lPerfilDTO);
        return mav;
    }
	
	@GetMapping(value="/find/{id}")
    public ModelAndView encontrarPerfilPorId(@PathVariable Integer id) {
		Perfil iObj = perfilService.encontrarPerfilPorId(id);
		ModelAndView mav = new ModelAndView("/perfil/cadastro");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("perfilID", iObj);
        return mav;
    }
		
	@GetMapping(value="/insert")
	public String cadastrarPerfil(Model iModelAttr) {
		Perfil iObj = new Perfil();
		iModelAttr.addAttribute("nome_usuario", "Gerente");
		iModelAttr.addAttribute("perfilID", iObj);
        return "/perfil/cadastro";
    }
	
	@PostMapping(value="/update")
    public String inserirPerfil(@ModelAttribute("perfilID") Perfil iModelAttr) {
		perfilService.inserirPerfil(iModelAttr);
		return "redirect:/perfil/"; 
    }
	
	@GetMapping(value="/delete/{id}")
    public String excluirPerfil(@PathVariable Integer id) {
		perfilService.excluirPerfil(id);
		return "redirect:/perfil/";
    }
}

