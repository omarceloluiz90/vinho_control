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

import com.example.vc.boot.domain.LocalAdega;
import com.example.vc.boot.dto.AdegaDTO;
import com.example.vc.boot.dto.LocalAdegaDTO;
import com.example.vc.boot.dto.VinhoDTO;
import com.example.vc.boot.service.AdegaService;
import com.example.vc.boot.service.LocalAdegaService;
import com.example.vc.boot.service.VinhoService;


@Controller
@RequestMapping(value="/local_adega")
public class LocalAdegaController {
	@Autowired
	private LocalAdegaService localAdegaService;
	@Autowired
	private VinhoService vinhoService;
	@Autowired
	private AdegaService adegaService;
		
	@GetMapping(value="/")
    public ModelAndView listarTodos() {
		List<LocalAdegaDTO> lLocalAdegaDTO = localAdegaService.listarTodos();
		ModelAndView mav = new ModelAndView("/local_adega/index");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("localAdegaID", lLocalAdegaDTO);
        return mav;
    }
	
	@GetMapping(value="/find/{id}")
    public ModelAndView encontrarLocalAdegaPorId(@PathVariable Integer id) {
		List<VinhoDTO> lVinhoDTO = vinhoService.listarTodos();
		List<AdegaDTO> lAdegaDTO = adegaService.listarTodos();
		LocalAdega iObj = localAdegaService.encontrarLocalAdegaPorId(id);
		ModelAndView mav = new ModelAndView("/local_adega/cadastro");
		mav.addObject("nome_usuario", "Gerente");
		mav.addObject("localAdegaID", iObj);
        mav.addObject("vinho", lVinhoDTO);
        mav.addObject("adega", lAdegaDTO);
        return mav;
    }
		
	@GetMapping(value="/insert")
	public String cadastrarLocalAdega(Model iModelAttr) {
		List<VinhoDTO> lVinhoDTO = vinhoService.listarTodos();
		List<AdegaDTO> lAdegaDTO = adegaService.listarTodos();
		LocalAdega iObj = new LocalAdega();
		iModelAttr.addAttribute("nome_usuario", "Gerente");
		iModelAttr.addAttribute("localAdegaID", iObj);
		iModelAttr.addAttribute("vinho", lVinhoDTO);
		iModelAttr.addAttribute("adega", lAdegaDTO);
        return "/local_adega/cadastro";
    }
	
	@PostMapping(value="/update")
    public String inserirLocalAdega(@ModelAttribute("localAdegaID") LocalAdega iModelAttr) {
		localAdegaService.inserirLocalAdega(iModelAttr);
		return "redirect:/local_adega/"; 
    }
	
	@GetMapping(value="/delete/{id}")
    public String excluirLocalAdega(@PathVariable Integer id) {
		localAdegaService.excluirLocalAdega(id);
		return "redirect:/local_adega/";
    }
}

