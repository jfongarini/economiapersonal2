package com.epoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TarjetaConsumoController {
	
	@RequestMapping("/tarjetaConsumo")
	public String tarjetaConsumo() {
		return "tarjetaConsumo/tarjetaConsumo";
	}

}
