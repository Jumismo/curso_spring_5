package com.jumismo.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	
	// Si se omite el method, por defecto es del tipo GET
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	// Si no tengo mas parametros puedo quitar el value
	// Se puede usar Model, ModelMap, ModelAndView o Map para pasar parámetros a la vista
	// Con ModelAndView, el método devuelve ese tipo y se le pasa la vista con setViewName("nombrevista")
	@GetMapping(value = {"/index", "/", "home"})
	public String index(Model model)
	{
		model.addAttribute("titulo", "Hola Spring Framework!");
		return "index";
	}

}
