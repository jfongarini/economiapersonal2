package com.epoweb.repository;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;

import com.epoweb.model.Categoria;
import com.epoweb.model.Diario;

@SuppressWarnings({ "unchecked" })
public class DiarioRepository extends AbstractRepository{

	final static Logger LOGGER = Logger.getLogger(DiarioRepository.class);
	
	public int saveDiario (Diario diario) {
		return (int) getCurrentSession().save(diario); 
	}

	public void updateDiario(Diario diario) {
		getCurrentSession().update(diario);
	}
	
	public Diario getDiario(int id){
		return getCurrentSession().get(Diario.class, id);
	}
	
	public void deleteDiario(Diario diario) {
		getCurrentSession().delete(diario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Diario> getAllDiario() {
		return getCurrentSession().createQuery("FROM Diario d").list();		
	}		
		
	public Categoria getCategoriaId(Integer id) {		
		
		String querySql = "from Categoria t WHERE (t.id = ?1)";	
		Query<Categoria> query = getCurrentSession().createQuery(querySql);
	    query.setParameter(1, id);	  
	    return query.getSingleResult();
		
	}

}	