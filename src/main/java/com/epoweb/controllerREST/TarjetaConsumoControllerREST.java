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

import com.epoweb.model.TarjetaConsumo;
import com.epoweb.service.TarjetaConsumoService;

@RestController
@RequestMapping(value = "/rest/")
public class TarjetaConsumoControllerREST {

	@Autowired
	@Qualifier("TarjetaConsumoServiceTransactional")
	private TarjetaConsumoService service;
	
	@GetMapping("TarjetaConsumo")
    public ResponseEntity<List<TarjetaConsumo>> getTarjetaConsumos() {
		return new ResponseEntity<>(service.getTarjetaConsumos(), HttpStatus.OK);
	}

	@GetMapping("TarjetaConsumo/{idTarjetaConsumo}")
    public ResponseEntity<TarjetaConsumo> getTarjetaConsumoId(@PathVariable int tarjetaConsumoID) {
		return new ResponseEntity<>(service.getTarjetaConsumoId(tarjetaConsumoID), HttpStatus.OK);
	}
	
	@PostMapping("TarjetaConsumo/alta")
    public ResponseEntity<TarjetaConsumo> newTarjetaConsumo(@RequestBody TarjetaConsumo tarjetaConsumo) {
		Integer newID = service.saveTarjetaConsumo(tarjetaConsumo);
		tarjetaConsumo.setId(newID);
		return new ResponseEntity<>(tarjetaConsumo, HttpStatus.CREATED);
	}
		
	@PutMapping("TarjetaConsumo/actualizar/{idTarjetaConsumo}")
    public ResponseEntity<TarjetaConsumo> updateTarjetaConsumo(@RequestBody TarjetaConsumo tarjetaConsumo) {
		TarjetaConsumo updated = service.updateTarjetaConsumo(tarjetaConsumo);
		return new ResponseEntity<>(updated ,HttpStatus.OK);
	}
		
	@DeleteMapping("TarjetaConsumo/eliminar/{idTarjetaConsumo}")	
    public ResponseEntity<TarjetaConsumo> deleteTarjetaConsumo(@PathVariable int tarjetaConsumoID) {
		return new ResponseEntity<>(service.deleteTarjetaConsumo(tarjetaConsumoID), HttpStatus.OK);
	}
	
	public TarjetaConsumoService getService() {
		return service;
	}
	
	public void setService(TarjetaConsumoService service) {
		this.service = service;
	}
	
	
}
