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
	
	// save
	public Integer saveCategoria(Categoria categoria) {
		LOGGER.info("Guardando la categoria: "+ categoria.getNombre());
		return repository.saveCategoria(categoria);
	}	
	
	public Integer saveInversion (Inversion inversion) {
		LOGGER.info("Guardando la inversion: "+ inversion.getNombre());
		return repository.saveInversion(inversion);
	}
	
	public Integer savePersona(Persona persona) {
		LOGGER.info("Guardando la persona: "+ persona.getNombre());
		return repository.savePersona(persona);
	}
	
	public Integer saveTarjeta(Tarjeta tarjeta) {
		LOGGER.info("Guardando la tarjeta: "+ tarjeta.getNombre());
		return repository.saveTarjeta(tarjeta);
	}
	
	
	
	// update	
	
	public Categoria updateCategoria(Categoria categoria) {
		LOGGER.info("Actualizando Categoria " + categoria.getNombre());
		Categoria repoCategoria = getCategoria(categoria.getId());
		repoCategoria.setNombre(categoria.getNombre());
		saveCategoria(repoCategoria);
		return repoCategoria;
	}
	
	public Inversion updateInversion(Inversion inversion) {
		LOGGER.info("Actualizando Inversion " + inversion.getNombre());
		Inversion repoInversion = getInversion(inversion.getId());
		repoInversion.setNombre(inversion.getNombre());
		saveInversion(repoInversion);
		return repoInversion;
	}
	
	public Persona updatePersona(Persona persona) {
		LOGGER.info("Actualizando Persona " + persona.getNombre());
		Persona repoPersona = getPersona(persona.getId());
		repoPersona.setNombre(persona.getNombre());
		savePersona(repoPersona);
		return repoPersona;
	}
	
	public Tarjeta updateTarjeta(Tarjeta tarjeta) {
		LOGGER.info("Actualizando Tarjeta " + tarjeta.getNombre());
		Tarjeta repoTarjeta = getTarjeta(tarjeta.getId());
		repoTarjeta.setNombre(tarjeta.getNombre());
		saveTarjeta(repoTarjeta);		
		return repoTarjeta;
	}
	
	
	// delete	
	
	public Categoria deleteCategoria(Categoria categoria) {
		Categoria repoCategoria = getCategoria(categoria.getId());
		repoCategoria.setVigente(false);
		saveCategoria(repoCategoria);
		return repoCategoria;
	}
	
	public Inversion deleteInversion(Inversion inversion) {
		Inversion repoInversion = getInversion(inversion.getId());
		repoInversion.setVigente(false);
		saveInversion(repoInversion);
		return repoInversion;
	}
	
	public Tarjeta deleteTarjeta(Tarjeta tarjeta) {
		Tarjeta repoTarjeta = getTarjeta(tarjeta.getId());
		repoTarjeta.setVigente(false);
		saveTarjeta(repoTarjeta);
		return repoTarjeta;
	}
	
	public Persona deletePersona(Persona persona) {
		Persona repoPersona = getPersona(persona.getId());
		repoPersona.setVigente(false);
		savePersona(repoPersona);
		return repoPersona;
	}
	
	
	
	// get individual
	
	public Categoria getCategoria(int categoriaID) {
		return repository.getCategoria(categoriaID);
	}
	
	public Inversion getInversion(int inversionID) {
		return repository.getInversion(inversionID);
	}
	
	public Persona getPersona(int personaID) {
		return repository.getPersona(personaID);
	}
	
	public Tarjeta getTarjeta(int tarjetaID) {
		return repository.getTarjeta(tarjetaID);
	}
	
	
	
	// get all
	
	public List<Categoria> getCategoriasIngreso() {
		LOGGER.info("Obteniendo todas las categorias");
		return repository.getCategoriasIngreso();
	}
	
	public List<Categoria> getCategoriasGasto() {
		LOGGER.info("Obteniendo todas las categorias");
		return repository.getCategoriasGasto();
	}
		
	public List<Inversion> getInversiones() {
		LOGGER.info("Obteniendo todas las inversiones");
		return repository.getInversiones();
	}
	
	public List<Persona> getPersonas() {
		LOGGER.info("Obteniendo todas las personas");
		return repository.getPersonas();
	}
	
	public List<Tarjeta> getTarjetas() {
		LOGGER.info("Obteniendo todas las tarjetas");
		return repository.getTarjetas();
	}
	
	
	
	
	
	
	
	public ConfiguracionRepository getRepository() {
		return repository;
	}
	public void setRepository(ConfiguracionRepository repository) {
		this.repository = repository;
	}

}