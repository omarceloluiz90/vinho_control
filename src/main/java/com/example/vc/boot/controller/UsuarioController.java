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

import com.example.vc.boot.domain.Usuario;
import com.example.vc.boot.dto.PerfilDTO;
import com.example.vc.boot.dto.UsuarioDTO;
import com.example.vc.boot.service.PerfilService;
import com.example.vc.boot.service.UsuarioService;


@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping(value="/")
    public ModelAndView listarTodos() {
		List<UsuarioDTO> lUsuarioDTO = usuarioService.listarTodos();
		ModelAndView mav = new ModelAndView("/usuario/index");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("usuario", lUsuarioDTO);
        return mav;
    }
	
	@GetMapping(value="/find/{id}")
    public ModelAndView encontrarUsuarioPorId(@PathVariable Integer id) {
		List<PerfilDTO> lPerfilDTO = perfilService.listarTodos();
		Usuario iObj = usuarioService.encontrarUsuarioPorId(id);
		ModelAndView mav = new ModelAndView("/usuario/cadastro");
		mav.addObject("nome_usuario", "Gerente");
        mav.addObject("usuarioID", iObj);
        mav.addObject("perfil", lPerfilDTO);
        return mav;
    }
		
	@GetMapping(value="/insert")
	public String cadastrarUsuario(Model iModelAttr) {
		List<PerfilDTO> lPerfilDTO = perfilService.listarTodos(); 
		Usuario iObj = new Usuario();
		iModelAttr.addAttribute("nome_usuario", "Gerente");
		iModelAttr.addAttribute("usuarioID", iObj);
		iModelAttr.addAttribute("perfil", lPerfilDTO);
        return "/usuario/cadastro";
    }
	
	@PostMapping(value="/update")
    public String inserirUsuario(@ModelAttribute("usuarioID") Usuario iModelAttr) {
		usuarioService.inserirUsuario(iModelAttr);
		return "redirect:/usuario/"; 
    }
	
	@GetMapping(value="/delete/{id}")
    public String excluirUsuario(@PathVariable Integer id) {
		usuarioService.excluirUsuario(id);
		return "redirect:/usuario/";
    }
}

