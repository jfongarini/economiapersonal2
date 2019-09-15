package com.epoweb.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epoweb.model.Categoria;
import com.epoweb.model.Inversion;
import com.epoweb.model.Persona;
import com.epoweb.model.Tarjeta;
import com.epoweb.repository.ConfiguracionRepository;

public class ConfiguracionService {
	

	final static Logger LOGGER = Logger.getLogger(ConfiguracionService.class);

	private ConfiguracionRepository repository;	
	
	//Categoria
	public Integer saveCategoria(Categoria categoria) {
		LOGGER.info("Guardando la categoria: "+ categoria.getNombre());
		return repository.saveCategoria(categoria);
	}	
	
	public Categoria updateCategoria(Categoria categoria) {
		LOGGER.info("Actualizando Categoria " + categoria.getNombre());
		Categoria updated = getCategoria(categoria.getId());
		updated.update(categoria);
		repository.updateCategoria(updated);
		return updated;
	}
	
	public Categoria getCategoria(int categoriaID) {
		return repository.getCategoria(categoriaID);
	}
	
	public List<Categoria> getCategorias() {
		LOGGER.info("Obteniendo todas las categorias");
		return repository.getCategorias();
	}
	
	//Inversion
	public Integer saveInversion (Inversion inversion) {
		LOGGER.info("Guardando la inversion: "+ inversion.getNombre());
		return repository.saveInversion(inversion);
	}
		
	public List<Inversion> getInversiones() {
		LOGGER.info("Obteniendo todas las inversiones");
		return repository.getInversiones();
	}
	
	public Inversion updateInversion(Inversion inversion) {
		LOGGER.info("Actualizando Inversion " + inversion.getId());
		Inversion updated = getInversion(inversion.getId());
		updated.update(inversion);
		repository.updateInversion(updated);
		return updated;
	}
	
	public Inversion getInversion(int inversionID) {
		return repository.getInversion(inversionID);
	}
	
	//Persona
	public Integer savePersona(Persona persona) {
		LOGGER.info("Guardando la persona: "+ persona.getNombre());
		return repository.savePersona(persona);
	}

	public List<Persona> getPersonas() {
		LOGGER.info("Obteniendo todas las personas");
		return repository.getPersonas();
	}
	
	public Persona updatePersona(Persona persona) {
		LOGGER.info("Actualizando Persona " + persona.getNombre());
		Persona updated = getPersona(persona.getId());
		updated.update(persona);
		repository.updatePersona(updated);
		return updated;
	}
	
	public Persona getPersona(int personaID) {
		return repository.getPersona(personaID);
	}
	
	//Tarjeta
	public Integer saveTarjeta(Tarjeta tarjeta) {
		LOGGER.info("Guardando la tarjeta: "+ tarjeta.getNombre());
		return repository.saveTarjeta(tarjeta);
	}
	
	public List<Tarjeta> getTarjetas() {
		LOGGER.info("Obteniendo todas las tarjetas");
		return repository.getTarjetas();
	}
	
	public Tarjeta updateTarjeta(Tarjeta tarjeta) {
		LOGGER.info("Actualizando Tarjeta " + tarjeta.getNombre());
		Tarjeta updated = getTarjeta(tarjeta.getId());
		updated.update(tarjeta);
		repository.updateTarjeta(updated);
		return updated;
	}
	
	public Tarjeta getTarjeta(int tarjetaID) {
		return repository.getTarjeta(tarjetaID);
	}
	
	
	
	public ConfiguracionRepository getRepository() {
		return repository;
	}
	public void setRepository(ConfiguracionRepository repository) {
		this.repository = repository;
	}

}