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

import com.epoweb.model.Persona;
import com.epoweb.service.PersonaService;

@RestController
@RequestMapping(value = "/rest/")
public class PersonaControllerREST {

	@Autowired
	@Qualifier("PersonaServiceTransactional")
	private PersonaService service;
	

	@GetMapping("Persona/{idPersona}")
    public ResponseEntity<Persona> getPersonaId(@PathVariable int personaID) {
		return new ResponseEntity<>(service.getPersonaId(personaID), HttpStatus.OK);
	}
	
	@PostMapping("Persona/alta")
    public ResponseEntity<Persona> newPersona(@RequestBody Persona persona) {
		Integer newID = service.savePersona(persona);
		persona.setId(newID);
		return new ResponseEntity<>(persona, HttpStatus.CREATED);
	}
		
	@PutMapping("Persona/actualizar/{idPersona}")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
		Persona updated = service.updatePersona(persona);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
	
	public PersonaService getService() {
		return service;
	}
	
	public void setService(PersonaService service) {
		this.service = service;
	}
	
	
}
