package com.epoweb.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epoweb.model.Saldo;
import com.epoweb.service.SaldoService;

@RestController
@RequestMapping(value = "/rest/")
public class SaldoControllerREST {

	@Autowired
	@Qualifier("SaldoServiceTransactional")
	private SaldoService service;
	

	@GetMapping("saldo/{idSaldo}")
    public ResponseEntity<Saldo> getSaldo(@PathVariable int saldoID) {
		return new ResponseEntity<>(service.getSaldo(saldoID), HttpStatus.OK);
	}
	
	@PostMapping("saldo/alta")
    public ResponseEntity<Saldo> newSaldo(@RequestBody Saldo saldo) {
		Integer newID = service.saveSaldo(saldo);
		saldo.setId(newID);
		return new ResponseEntity<>(saldo, HttpStatus.CREATED);
	}
		
	@PutMapping("saldo/actualizar/{idSaldo}")
    public ResponseEntity<Saldo> updateSaldo(@RequestBody Saldo saldo) {
		Saldo updated = service.updateSaldo(saldo);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
	public SaldoService getService() {
		return service;
	}
	
	public void setService(SaldoService service) {
		this.service = service;
	}
	
	
}
