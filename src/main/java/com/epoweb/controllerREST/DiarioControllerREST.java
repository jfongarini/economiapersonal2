package com.epoweb.controllerREST;

import java.util.List;

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

import com.epoweb.model.Diario;
import com.epoweb.service.DiarioService;

@RestController
@RequestMapping(value = "/rest/")
public class DiarioControllerREST {

	@Autowired
	@Qualifier("DiarioServiceTransactional")
	private DiarioService service;
	
	@GetMapping("diario")
    public ResponseEntity<List<Diario>> getAllDiario() {
		return new ResponseEntity<>(service.getAllDiario(), HttpStatus.OK);
	}

	@GetMapping("diario/{diarioID}")
    public ResponseEntity<Diario> getDiario(@PathVariable int diarioID) {
		return new ResponseEntity<>(service.getDiario(diarioID), HttpStatus.OK);
	}
	
	@PostMapping("diario/alta")
    public ResponseEntity<Diario> newDiario(@RequestBody Diario diario) {
		Integer newID = service.saveDiario(diario);
		diario.setId(newID);
		return new ResponseEntity<>(diario, HttpStatus.CREATED);
	}
		
	@PutMapping("diario/actualizar/{idDiario}")
    public ResponseEntity<Diario> updateDiario(@RequestBody Diario diario) {
		Diario updated = service.updateDiario(diario);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
		
	
	public DiarioService getService() {
		return service;
	}
	
	public void setService(DiarioService service) {
		this.service = service;
	}
	
	
}
