package com.epoweb.repository;

import org.hibernate.query.Query;

import com.epoweb.model.Persona;

@SuppressWarnings({ "unchecked" })
public class PersonaRepository extends AbstractRepository{
	
	public Integer savePersona(Persona persona) {
		return (Integer) getCurrentSession().save(persona);
	}

	public void updatePersona(Persona persona) {
		getCurrentSession().update(persona);
	}
		
	public Persona getPersonaId(Integer id) {		
		
		String querySql = "from Persona t WHERE (t.id = ?1)";	
		Query<Persona> query = getCurrentSession().createQuery(querySql);
	    query.setParameter(1, id);	  
	    return query.getSingleResult();
		
	}
}

