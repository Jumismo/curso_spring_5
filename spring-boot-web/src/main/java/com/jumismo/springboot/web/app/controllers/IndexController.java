package com.jumismo.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jumismo.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	
	// Si se omite el method, por defecto es del tipo GET
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	// Si no tengo mas parametros puedo quitar el value
	// Se puede usar Model, ModelMap, ModelAndView o Map para pasar parámetros a la vista
	// Con ModelAndView, el método devuelve ese tipo y se le pasa la vista con setViewName("nombrevista")
	@GetMapping(value = {"/index", "/", "", "home"})
	public String index(Model model)
	{
		model.addAttribute("titulo", "Hola Spring Framework con Model!");
		return "index";
	}

	
	@RequestMapping(value = "/perfil")
	public String perfil(Model model)
	{
		Usuario usuario = new Usuario();
		usuario.setNombre("Juanmi");
		usuario.setApellido("Apellido");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}
}
