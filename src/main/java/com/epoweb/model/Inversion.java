package com.epoweb.model;

public class Inversion {

	private int id;
	private Integer personaId;
	private String nombre;
	private Boolean vigente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getPersonaId() {
		return personaId;
	}
	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Boolean getVigente() {
		return vigente;
	}
	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	public void update(Inversion inversion) {
		this.setPersonaId(inversion.getPersonaId());
		this.setNombre(inversion.getNombre());
		this.setVigente(inversion.getVigente());		
	}
	
}