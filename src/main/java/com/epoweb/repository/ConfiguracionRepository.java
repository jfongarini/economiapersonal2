package com.epoweb.repository;

import java.util.List;

import org.apache.log4j.Logger;

import com.epoweb.model.Categoria;
import com.epoweb.model.Inversion;
import com.epoweb.model.Persona;
import com.epoweb.model.Tarjeta;

@SuppressWarnings("unchecked")
public class ConfiguracionRepository extends AbstractRepository {

	final static Logger LOGGER = Logger.getLogger(ConfiguracionRepository.class);

	
	//Categoria
	public List<Categoria> getCategorias() {
		return getCurrentSession().createQuery("from Categoria").list();
	}

	public Integer saveCategoria(Categoria categoria) {
		return (Integer) getCurrentSession().save(categoria);
	}

	public void updateCategoria(Categoria categoria) {
		getCurrentSession().update(categoria);
	}
	
	
	//Inversion
	public Integer saveInversion (Inversion inversion) {
		return (Integer) getCurrentSession().save(inversion); 
	}

	public void updateInversion(Inversion inversion) {
		getCurrentSession().update(inversion);
	}
		
	public List<Inversion> getInversiones() {
		return getCurrentSession().createQuery("from Inversion").list();
	}
	
	
	//Persona
	public Integer savePersona(Persona persona) {
		return (Integer) getCurrentSession().save(persona);
	}

	public void updatePersona(Persona persona) {
		getCurrentSession().update(persona);
	}
	
	public List<Persona> getPersona() {
		return getCurrentSession().createQuery("from Persona").list();
	}
	
	
	//Tarjeta
	public Integer saveTarjeta(Tarjeta tarjeta) {
		return (Integer) getCurrentSession().save(tarjeta);
	}

	public void updateTarjeta(Tarjeta tarjeta) {
		getCurrentSession().update(tarjeta);
	}
	
	public List<Tarjeta> getTarjeta() {
		return getCurrentSession().createQuery("from Tarjeta").list();
	}

	
}
