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
	
	public void updateCategoria(Categoria categoria) {
		LOGGER.info("Actualizando la categoria: "+ categoria.getNombre());
		repository.updateCategoria(categoria);
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

	public void updateInversion(Inversion inversion) {
		LOGGER.info("Actualizando la inversion: "+ inversion.getNombre());
		repository.updateInversion(inversion);
	}
		
	public List<Inversion> getInversiones() {
		LOGGER.info("Obteniendo todas las inversiones");
		return repository.getInversiones();
	}
	
	
	//Persona
	public Integer savePersona(Persona persona) {
		LOGGER.info("Guardando la persona: "+ persona.getNombre());
		return repository.savePersona(persona);
	}

	public void updatePersona(Persona persona) {
		LOGGER.info("Actualizando la persona: "+ persona.getNombre());
		repository.updatePersona(persona);;
	}
	
	public List<Persona> getPersona() {
		LOGGER.info("Obteniendo todas las personas");
		return repository.getPersona();
	}
	
	
	//Tarjeta
	public Integer saveTarjeta(Tarjeta tarjeta) {
		LOGGER.info("Guardando la tarjeta: "+ tarjeta.getNombre());
		return repository.saveTarjeta(tarjeta);
	}

	public void updateTarjeta(Tarjeta tarjeta) {
		LOGGER.info("Actualizando la tarjeta: "+ tarjeta.getNombre());
		repository.updateTarjeta(tarjeta);;
	}
	
	public List<Tarjeta> getTarjeta() {
		LOGGER.info("Obteniendo todas las tarjetas");
		return repository.getTarjeta();
	}
	
	
	
	public ConfiguracionRepository getRepository() {
		return repository;
	}
	public void setRepository(ConfiguracionRepository repository) {
		this.repository = repository;
	}

}