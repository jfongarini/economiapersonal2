package com.epoweb.repository;

import java.util.List;

import org.hibernate.query.Query;

import com.epoweb.model.TarjetaConsumo;

@SuppressWarnings({ "unchecked" })
public class TarjetaConsumoRepository extends AbstractRepository{
	
	public List<TarjetaConsumo> getTarjetaConsumos() {
		return getCurrentSession().createQuery("from TarjetaConsumo").list();
	}

	public Integer saveTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		return (Integer) getCurrentSession().save(tarjetaConsumo);
	}

	public void updateTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		getCurrentSession().update(tarjetaConsumo);
	}
	
	public void deleteTarjetaConsumo(TarjetaConsumo tarjetaConsumo) {
		getCurrentSession().delete(tarjetaConsumo);
	}
	
	public TarjetaConsumo getTarjetaConsumoId(Integer id) {		
		
		String querySql = "from TarjetaConsumo t WHERE (t.id = ?1)";	
		Query<TarjetaConsumo> query = getCurrentSession().createQuery(querySql);
	    query.setParameter(1, id);	  
	    return query.getSingleResult();
		
	}
}

