package com.jumismo.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jumismo.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	// Si se omite el method, por defecto es del tipo GET
	// @RequestMapping(value = "/index", method = RequestMethod.GET)
	// Si no tengo mas parametros puedo quitar el value
	// Se puede usar Model, ModelMap, ModelAndView o Map para pasar parámetros a la
	// vista
	// Con ModelAndView, el método devuelve ese tipo y se le pasa la vista con
	// setViewName("nombrevista")
	@GetMapping(value = { "/index", "/", "", "home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con Model!");
		return "index";
	}

	@RequestMapping(value = "/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juanmi");
		usuario.setApellido("Apellido");
		usuario.setEmail("juanmi@correo.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		
//		List<Usuario> usuarios = new ArrayList<>();
//		usuarios.add(new Usuario("Andrés", "Guzman", "andres@correo.com"));
//		usuarios.add(new Usuario("John", "Doe", "john@correo.com"));
//		usuarios.add(new Usuario("John", "Doe", "john@correo.com"));

		model.addAttribute("titulo", "Listado de usuarios");
		//model.addAttribute("usuarios", usuarios);

		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andrés", "Guzman", "andres@correo.com"),
				new Usuario("John", "Doe", "john@correo.com"),
				new Usuario("Jane", "Doe", "jane@correo.com"),
				new Usuario("Tornado", "Roe", "roe@correo.com"));

		return usuarios;
	}
}
