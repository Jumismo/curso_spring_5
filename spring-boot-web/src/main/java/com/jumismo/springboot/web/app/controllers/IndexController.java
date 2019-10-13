package com.jumismo.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	
	// Si se omite el method, por defecto es del tipo GET
	//@RequestMapping(value = "/index", method = RequestMethod.GET)
	// Si no tengo mas parametros puedo quitar el value
	@GetMapping(value = {"/index", "/", "home"})
	public String index()
	{
		return "index";
	}

}
