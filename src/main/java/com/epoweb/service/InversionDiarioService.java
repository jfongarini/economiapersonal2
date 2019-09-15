package com.epoweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import com.epoweb.model.InversionDiario;
import com.epoweb.repository.InversionDiarioRepository;

public class InversionDiarioService {
	

	final static Logger LOGGER = Logger.getLogger(InversionDiarioService.class);

	private InversionDiarioRepository repository;	
	
	public Integer saveInversionDiario(InversionDiario inversionDiario) {
		LOGGER.info("Guardando el inversionDiario: "+ inversionDiario.getId());
		return repository.saveInversionDiario(inversionDiario);
	}	
	
	public void updateInversionDiario(InversionDiario inversionDiario) {
		LOGGER.info("Actualizando el inversionDiario: "+ inversionDiario.getId());
		repository.updateInversionDiario(inversionDiario);
	}
	
	public InversionDiario getInversionDiarioId(int inversionDiarioId) {
		LOGGER.info("Obteniendo el inversionDiario: "+ inversionDiarioId);
		return repository.getInversionDiarioId(inversionDiarioId);
	}
	
	@SuppressWarnings("unchecked")
	public List<InversionDiario> getInversionDiarios() {
		LOGGER.info("Obteniendo todas los inversionDiario");
		return repository.getInversionDiarios();	
	}
	
	public void deleteInversionDiario(InversionDiario inversionDiario) {
		LOGGER.info("Borrando el inversionDiario: "+ inversionDiario.getId());
		repository.deleteInversionDiario(inversionDiario);;
	}
	

	
	
	public InversionDiarioRepository getRepository() {
		return repository;
	}
	public void setRepository(InversionDiarioRepository repository) {
		this.repository = repository;
	}

}