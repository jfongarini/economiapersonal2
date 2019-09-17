package com.epoweb.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.epoweb.model.TarjetaConsumo;
import com.epoweb.repository.TarjetaConsumoRepository;

public class TarjetaConsumoService {
	

	final static Logger LOGGER = Logger.getLogger(TarjetaConsumoService.class);

	private TarjetaConsumoRepository repository;	
	
	public Integer saveTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		LOGGER.info("Guardando el tarjetaConsumo: "+ tarjetaConsumo.getId());
		return repository.saveTarjetaConsumo(tarjetaConsumo);
	}	
	
	public TarjetaConsumo updateTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		LOGGER.info("Actualizando el tarjetaConsumo: "+ tarjetaConsumo.getId());
		TarjetaConsumo updated = getTarjetaConsumoId(tarjetaConsumo.getId());
		updated.update(tarjetaConsumo);
		repository.updateTarjetaConsumo(updated);
		return updated;
	}
	
	public TarjetaConsumo getTarjetaConsumoId(int tarjetaConsumo) {
		LOGGER.info("Obteniendo el tarjetaConsumo: "+ tarjetaConsumo);
		return repository.getTarjetaConsumoId(tarjetaConsumo);
	}
	
	public List<TarjetaConsumo> getTarjetaConsumos() {
		LOGGER.info("Obteniendo todas los tarjetaConsumo");
		return repository.getTarjetaConsumos();	
	}
	
	public TarjetaConsumo deleteTarjetaConsumo(int tarjetaConsumoId) {
		TarjetaConsumo tarjetaConsumo = getTarjetaConsumoId(tarjetaConsumoId);
		LOGGER.info("Borrando el tarjetaConsumo: "+ tarjetaConsumoId);
		repository.deleteTarjetaConsumo(tarjetaConsumo);
		return tarjetaConsumo;
	}
	

	
	
	public TarjetaConsumoRepository getRepository() {
		return repository;
	}
	public void setRepository(TarjetaConsumoRepository repository) {
		this.repository = repository;
	}

}