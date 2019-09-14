package com.epoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaldoController {
	
	@RequestMapping("/saldo")
	public String saldo() {
		return "saldo/saldo";
	}

}
