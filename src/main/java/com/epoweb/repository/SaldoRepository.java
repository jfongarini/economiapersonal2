package com.epoweb.repository;

import org.hibernate.query.Query;

import com.epoweb.model.Saldo;

@SuppressWarnings({ "unchecked" })
public class SaldoRepository extends AbstractRepository{
	
	public Integer saveSaldo(Saldo saldo) {
		return (Integer) getCurrentSession().save(saldo);
	}

	public void updateSaldo(Saldo saldo) {
		getCurrentSession().update(saldo);
	}
	
	public Saldo getSaldo(Integer id) {		
		
		String querySql = "from Saldo t WHERE (t.id = ?1)";	
		Query<Saldo> query = getCurrentSession().createQuery(querySql);
	    query.setParameter(1, id);	  
	    return query.getSingleResult();
		
	}
}

