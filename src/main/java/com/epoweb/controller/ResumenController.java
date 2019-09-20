package com.epoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResumenController {
	
	@RequestMapping("/")
	public String configuracion() {
		return "resumen/resumen";
	}

}
