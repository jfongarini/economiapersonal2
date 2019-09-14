package com.epoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonaController {
	
	@RequestMapping("/persona")
	public String persona() {
		return "persona/persona";
	}

}
