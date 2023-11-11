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

import com.example.vc.boot.domain.AcessoSistema;
import com.example.vc.boot.dto.AcessoSistemaDTO;
import com.example.vc.boot.service.AcessoSistemaService;


@Controller
@RequestMapping(value="/acesso_sistema")
public class AcessoSistemaController {
	@Autowired
	private AcessoSistemaService acessoSistemaService;
	
	@GetMapping(value="/")
    public ModelAndView listarTodos() {
		List<AcessoSistemaDTO> lAcessoSistemaDTO = acessoSistemaService.listarTodos();
		ModelAndView mav = new ModelAndView("/acesso_sistema/index");
		mav.addObject("nome_usuario", "Gerente");
		mav.addObject("a_sys", lAcessoSistemaDTO);
        return mav;
    }
	
	@GetMapping(value="/find/{id}")
    public ModelAndView encontrarAcessoSistemaPorId(@PathVariable Integer id) {
		AcessoSistema iObj = acessoSistemaService.encontrarAcessoSistemaPorId(id);
		ModelAndView mav = new ModelAndView("/acesso_sistema/cadastro");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("a_sysID", iObj);
        return mav;
    }
		
	@GetMapping(value="/insert")
	public String cadastrarAcessoSistema(Model iModelAttr) {
		AcessoSistema iObj = new AcessoSistema();
		iModelAttr.addAttribute("nome_usuario", "Gerente");
		iModelAttr.addAttribute("a_sysID", iObj);
        return "/acesso_sistema/cadastro";
    }
	
	@PostMapping(value="/update")
    public String inserirAcessoSistema(@ModelAttribute("a_sysID") AcessoSistema iModelAttr) {
		acessoSistemaService.inserirAcessoSistema(iModelAttr);
		return "redirect:/acesso_sistema/"; 
    }
	
	@GetMapping(value="/delete/{id}")
    public String excluirAcessoSistema(@PathVariable Integer id) {
		acessoSistemaService.excluirAcessoSistema(id);
		return "redirect:/acesso_sistema/";
    }
}

