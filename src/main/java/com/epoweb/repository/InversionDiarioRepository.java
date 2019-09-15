package com.epoweb.repository;

import java.util.List;

import org.hibernate.query.Query;

import com.epoweb.model.InversionDiario;

@SuppressWarnings({ "unchecked" })
public class InversionDiarioRepository extends AbstractRepository{
	
	public List<InversionDiario> getInversionDiarios() {
		return getCurrentSession().createQuery("from InversionDiario").list();
	}

	public Integer saveInversionDiario(InversionDiario inversionDiario) {
		return (Integer) getCurrentSession().save(inversionDiario);
	}

	public void updateInversionDiario(InversionDiario inversionDiario) {
		getCurrentSession().update(inversionDiario);
	}
	
	public void deleteInversionDiario(InversionDiario inversionDiario) {
		getCurrentSession().delete(inversionDiario);
	}
	
	public InversionDiario getInversionDiarioId(Integer id) {		
		
		String querySql = "from InversionDiario t WHERE (t.id = ?1)";	
		Query<InversionDiario> query = getCurrentSession().createQuery(querySql);
	    query.setParameter(1, id);	  
	    return query.getSingleResult();
		
	}
}

