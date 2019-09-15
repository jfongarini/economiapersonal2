package com.epoweb.service;

import org.apache.log4j.Logger;

import com.epoweb.model.Saldo;
import com.epoweb.repository.SaldoRepository;

public class SaldoService {
	

	final static Logger LOGGER = Logger.getLogger(SaldoService.class);

	private SaldoRepository repository;	
	
	public Integer saveSaldo(Saldo saldo) {
		LOGGER.info("Guardando el saldo: "+ saldo.getId());
		return repository.saveSaldo(saldo);
	}	
	
	public void updateSaldo(Saldo saldo) {
		LOGGER.info("Actualizando el saldo: "+ saldo.getId());
		repository.updateSaldo(saldo);
	}
	
	public Saldo getSaldo(int saldo) {
		LOGGER.info("Obteniendo el saldo: "+ saldo);
		return repository.getSaldo(saldo);
	}
	
		
	
	public SaldoRepository getRepository() {
		return repository;
	}
	public void setRepository(SaldoRepository repository) {
		this.repository = repository;
	}

}