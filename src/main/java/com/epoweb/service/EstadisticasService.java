package com.epoweb.service;

import org.apache.log4j.Logger;

import com.epoweb.repository.EstadisticasRepository;

public class EstadisticasService {
	
	final static Logger LOGGER = Logger.getLogger(EstadisticasService.class);

	private EstadisticasRepository repository;	
	public EstadisticasRepository getRepository() {
		return repository;
	}
	public void setRepository(EstadisticasRepository repository) {
		this.repository = repository;
	}

}