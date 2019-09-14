package com.epoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiarioController {
	
	@RequestMapping("/diario")
	public String diario() {
		return "diario/diario";
	}

}
