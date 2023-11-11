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

import com.example.vc.boot.domain.Adega;
import com.example.vc.boot.dto.AdegaDTO;
import com.example.vc.boot.service.AdegaService;


@Controller
@RequestMapping(value="/adega")
public class AdegaController {
	@Autowired
	private AdegaService adegaService;
	
	@GetMapping(value="/")
    public ModelAndView listarTodos() {
		List<AdegaDTO> lAdegaDTO = adegaService.listarTodos();
		ModelAndView mav = new ModelAndView("/adega/index");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("adega", lAdegaDTO);
        return mav;
    }
	
	@GetMapping(value="/find/{id}")
    public ModelAndView encontrarAdegaPorId(@PathVariable Integer id) {
		Adega iObj = adegaService.encontrarAdegaPorId(id);
		ModelAndView mav = new ModelAndView("/adega/cadastro");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("adegaID", iObj);
        return mav;
    }
		
	@GetMapping(value="/insert")
	public String cadastrarAdega(Model iModelAttr) {
		Adega iObj = new Adega();
		iModelAttr.addAttribute("nome_usuario", "Gerente");
		iModelAttr.addAttribute("adegaID", iObj);
        return "/adega/cadastro";
    }
	
	@PostMapping(value="/update")
    public String inserirAdega(@ModelAttribute("adegaID") Adega iModelAttr) {
		adegaService.inserirAdega(iModelAttr);
		return "redirect:/adega/"; 
    }
	
	@GetMapping(value="/delete/{id}")
    public String excluirAdega(@PathVariable Integer id) {
		adegaService.excluirAdega(id);
		return "redirect:/adega/";
    }
}

