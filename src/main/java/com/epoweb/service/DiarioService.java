package com.epoweb.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epoweb.model.Categoria;
import com.epoweb.model.Diario;
import com.epoweb.repository.DiarioRepository;

public class DiarioService {
	

	final static Logger LOGGER = Logger.getLogger(DiarioService.class);

	private DiarioRepository repository;	
	
	public Integer saveDiario(Diario diario) {
		LOGGER.info("Guardando el diario: "+ diario.getId());
		return repository.saveDiario(diario);
	}	
	
	public Diario updateDiario(Diario diario) {
		LOGGER.info("Actualizando el diario: "+ diario.getId());
		Diario updated = getDiario(diario.getId());
		updated.update(diario);
		repository.updateDiario(updated);
		return updated;
	}
	
	public Diario getDiario(int diarioId) {
		LOGGER.info("Obteniendo el diario: "+ diarioId);
		return repository.getDiario(diarioId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Diario> getAllDiario() {
		LOGGER.info("Obteniendo todas los diario");
		return repository.getAllDiario();	
	}
	
	public void deleteDiario(Diario diario) {
		LOGGER.info("Borrando el diario: "+ diario.getId());
		repository.deleteDiario(diario);;
	}
	
	public Categoria getCategoriaId(Integer id) {		
		return repository.getCategoriaId(id);		
	}
	
	public DiarioRepository getRepository() {
		return repository;
	}
	public void setRepository(DiarioRepository repository) {
		this.repository = repository;
	}

}