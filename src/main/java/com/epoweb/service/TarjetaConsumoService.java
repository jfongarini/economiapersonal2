package com.epoweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import com.epoweb.model.TarjetaConsumo;
import com.epoweb.repository.TarjetaConsumoRepository;

public class TarjetaConsumoService {
	

	final static Logger LOGGER = Logger.getLogger(TarjetaConsumoService.class);

	private TarjetaConsumoRepository repository;	
	
	public Integer saveTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		LOGGER.info("Guardando el tarjetaConsumo: "+ tarjetaConsumo.getId());
		return repository.saveTarjetaConsumo(tarjetaConsumo);
	}	
	
	public void updateTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		LOGGER.info("Actualizando el tarjetaConsumo: "+ tarjetaConsumo.getId());
		repository.updateTarjetaConsumo(tarjetaConsumo);
	}
	
	public TarjetaConsumo v(int tarjetaConsumo) {
		LOGGER.info("Obteniendo el tarjetaConsumo: "+ tarjetaConsumo);
		return repository.getTarjetaConsumoId(tarjetaConsumo);
	}
	
	@SuppressWarnings("unchecked")
	public List<TarjetaConsumo> getTarjetaConsumo() {
		LOGGER.info("Obteniendo todas los tarjetaConsumo");
		return repository.getTarjetaConsumo();	
	}
	
	public void deleteTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		LOGGER.info("Borrando el tarjetaConsumo: "+ tarjetaConsumo.getId());
		repository.deleteTarjetaConsumo(tarjetaConsumo);;
	}
	

	
	
	public TarjetaConsumoRepository getRepository() {
		return repository;
	}
	public void setRepository(TarjetaConsumoRepository repository) {
		this.repository = repository;
	}

}