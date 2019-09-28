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

import com.epoweb.model.Categoria;
import com.epoweb.model.Inversion;
import com.epoweb.model.Persona;
import com.epoweb.model.Tarjeta;
import com.epoweb.service.ConfiguracionService;

@RestController
@RequestMapping(value = "/rest/configuracion")
public class ConfiguracionControllerREST {

	@Autowired
	@Qualifier("ConfiguracionServiceTransactional")
	private ConfiguracionService service;
	
	@GetMapping("/categoriasIngreso")
    public ResponseEntity<List<Categoria>> getCategoriasIngreso() {
		return new ResponseEntity<>(service.getCategoriasIngreso(), HttpStatus.OK);
	}
	
	@GetMapping("/categoriasGasto")
    public ResponseEntity<List<Categoria>> getCategoriasGasto() {
		return new ResponseEntity<>(service.getCategoriasGasto(), HttpStatus.OK);
	}
	
	@GetMapping("/categoria/{idCategoria}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable Integer idCategoria) {
		Categoria categoria = service.getCategoria(idCategoria);
		return new ResponseEntity<>(categoria ,HttpStatus.OK);
	}
	
	@PostMapping("/categoria/alta")
    public ResponseEntity<Categoria> newCategoria(@RequestBody Categoria categoria) {
		Integer newID = service.saveCategoria(categoria);
		categoria.setId(newID);
		return new ResponseEntity<>(categoria, HttpStatus.CREATED);
	}
		
	@PutMapping("/categoria/actualizar/{categoria}")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria) {
		Categoria updated = service.updateCategoria(categoria);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
	@PutMapping("/categoria/baja/{categoria}")
    public ResponseEntity<Categoria> deleteCategoria(@RequestBody Categoria categoria) {
		Categoria updated = service.deleteCategoria(categoria);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
	@GetMapping("/inversion")
    public ResponseEntity<List<Inversion>> getInversiones() {
		return new ResponseEntity<>(service.getInversiones(), HttpStatus.OK);
	}
	
	@PostMapping("/inversion/alta")
    public ResponseEntity<Inversion> newInversion(@RequestBody Inversion inversion) {
		Integer newID = service.saveInversion(inversion);
		inversion.setId(newID);
		return new ResponseEntity<>(inversion, HttpStatus.CREATED);
	}
		
	@PutMapping("/inversion/actualizar/{idInversion}")
    public ResponseEntity<Inversion> updateInversion(@RequestBody Inversion inversion) {
		Inversion updated = service.updateInversion(inversion);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
	@GetMapping("/persona")
    public ResponseEntity<List<Persona>> getPersonas() {
		return new ResponseEntity<>(service.getPersonas(), HttpStatus.OK);
	}
	
	@PostMapping("/persona/alta")
    public ResponseEntity<Persona> newPersona(@RequestBody Persona persona) {
		Integer newID = service.savePersona(persona);
		persona.setId(newID);
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
	}
		
	@PutMapping("/persona/actualizar/{idPersona}")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
		Persona updated = service.updatePersona(persona);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
	
	@GetMapping("/tarjeta")
    public ResponseEntity<List<Tarjeta>> getTarjetas() {
		return new ResponseEntity<>(service.getTarjetas(), HttpStatus.OK);
	}
	
	@PostMapping("/tarjeta/alta")
    public ResponseEntity<Tarjeta> newTarjeta(@RequestBody Tarjeta tarjeta) {
		Integer newID = service.saveTarjeta(tarjeta);
		tarjeta.setId(newID);
		return new ResponseEntity<>(tarjeta, HttpStatus.CREATED);
	}
		
	@PutMapping("/tarjeta/actualizar/{idTarjeta}")
    public ResponseEntity<Tarjeta> updateTarjeta(@RequestBody Tarjeta tarjeta) {
		Tarjeta updated = service.updateTarjeta(tarjeta);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
}
