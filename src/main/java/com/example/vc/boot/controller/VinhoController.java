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

import com.example.vc.boot.domain.Vinho;
import com.example.vc.boot.dto.VinhoDTO;
import com.example.vc.boot.service.VinhoService;


@Controller
@RequestMapping(value="/vinho")
public class VinhoController {
	@Autowired
	private VinhoService vinhoService;
	
	@GetMapping(value="/")
    public ModelAndView listarTodos() {
		List<VinhoDTO> lVinhoDTO = vinhoService.listarTodos();
		ModelAndView mav = new ModelAndView("/vinho/index");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("vinho", lVinhoDTO);
        return mav;
    }
	
	@GetMapping(value="/find/{id}")
    public ModelAndView encontrarVinhoPorId(@PathVariable Integer id) {
		Vinho iObj = vinhoService.encontrarVinhoPorId(id);
		ModelAndView mav = new ModelAndView("/vinho/cadastro");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("vinhoID", iObj);
        return mav;
    }
		
	@GetMapping(value="/insert")
	public String cadastrarVinho(Model iModelAttr) {
		Vinho iObj = new Vinho();
		iModelAttr.addAttribute("nome_usuario", "Gerente");
		iModelAttr.addAttribute("vinhoID", iObj);
        return "/vinho/cadastro";
    }
	
	@PostMapping(value="/update")
    public String inserirVinho(@ModelAttribute("vinho") Vinho iModelAttr) {
		vinhoService.inserirVinho(iModelAttr);
		return "redirect:/vinho/"; 
    }
	
	@GetMapping(value="/delete/{id}")
    public String excluirVinho(@PathVariable Integer id) {
		vinhoService.excluirVinho(id);
		return "redirect:/vinho/";
    }
}

