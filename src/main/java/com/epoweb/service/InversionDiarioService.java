package com.epoweb.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epoweb.model.InversionDiario;
import com.epoweb.repository.InversionDiarioRepository;

public class InversionDiarioService {
	

	final static Logger LOGGER = Logger.getLogger(InversionDiarioService.class);

	private InversionDiarioRepository repository;	
	
	public Integer saveInversionDiario(InversionDiario inversionDiario) {
		LOGGER.info("Guardando el inversionDiario: "+ inversionDiario.getId());
		return repository.saveInversionDiario(inversionDiario);
	}	
	
	public InversionDiario updateInversionDiario(InversionDiario inversionDiario) {
		LOGGER.info("Actualizando el inversionDiario: "+ inversionDiario.getId());
		InversionDiario updated = getInversionDiarioId(inversionDiario.getId());
		updated.update(inversionDiario);
		repository.updateInversionDiario(updated);
		return updated;
	}
		
	public InversionDiario getInversionDiarioId(int inversionDiarioId) {
		LOGGER.info("Obteniendo el inversionDiario: "+ inversionDiarioId);
		return repository.getInversionDiarioId(inversionDiarioId);
	}
	
	public List<InversionDiario> getInversionDiarios() {
		LOGGER.info("Obteniendo todas los inversionDiario");
		return repository.getInversionDiarios();	
	}
	
	public InversionDiario deleteInversionDiario(int inversionDiarioId) {
		InversionDiario inversionDiario = getInversionDiarioId(inversionDiarioId);
		LOGGER.info("Borrando el inversionDiario: "+ inversionDiarioId);
		repository.deleteInversionDiario(inversionDiario);
		return inversionDiario;
	}
	
	public InversionDiarioRepository getRepository() {
		return repository;
	}
	public void setRepository(InversionDiarioRepository repository) {
		this.repository = repository;
	}

}