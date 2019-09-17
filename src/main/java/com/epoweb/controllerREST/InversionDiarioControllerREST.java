package com.epoweb.controllerREST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epoweb.model.InversionDiario;
import com.epoweb.service.InversionDiarioService;

@RestController
@RequestMapping(value = "/rest/")
public class InversionDiarioControllerREST {

	@Autowired
	@Qualifier("InversionDiarioServiceTransactional")
	private InversionDiarioService service;
	
	@GetMapping("inversionDiario")
    public ResponseEntity<List<InversionDiario>> getInversionDiarios() {
		return new ResponseEntity<>(service.getInversionDiarios(), HttpStatus.OK);
	}

	@GetMapping("inversionDiario/{idInversionDiario}")
    public ResponseEntity<InversionDiario> getInversionDiarioId(@PathVariable int InversionDiarioID) {
		return new ResponseEntity<>(service.getInversionDiarioId(InversionDiarioID), HttpStatus.OK);
	}
	
	@PostMapping("inversionDiario/alta")
    public ResponseEntity<InversionDiario> newInversionDiario(@RequestBody InversionDiario inversionDiario) {
		Integer newID = service.saveInversionDiario(inversionDiario);
		inversionDiario.setId(newID);
		return new ResponseEntity<>(inversionDiario, HttpStatus.CREATED);
	}
		
	@PutMapping("inversionDiario/actualizar/{idInversionDiario}")
    public ResponseEntity<InversionDiario> updateInversionDiario(@RequestBody InversionDiario idInversionDiario) {
		InversionDiario updated = service.updateInversionDiario(idInversionDiario);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
		
	@DeleteMapping("inversionDiario/eliminar/{idInversionDiario}")	
    public ResponseEntity<InversionDiario> deleteInversionDiario(@PathVariable int idInversionDiario) {
		return new ResponseEntity<>(service.deleteInversionDiario(idInversionDiario), HttpStatus.OK);
	}
	
	public InversionDiarioService getService() {
		return service;
	}
	
	public void setService(InversionDiarioService service) {
		this.service = service;
	}
	
	
}
