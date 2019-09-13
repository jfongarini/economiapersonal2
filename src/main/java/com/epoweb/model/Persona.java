package com.epoweb.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

public class Persona {

	private int id;
	private String nombre;
	private Blob password;
	private Date fecha;
	private Integer imagen;
	private BigDecimal saldobanco;
	private BigDecimal saldocash;
	private Boolean vigente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Blob getPassword() {
		return password;
	}
	public void setPassword(Blob password) {
		this.password = password;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getImagen() {
		return imagen;
	}
	public void setImagen(Integer imagen) {
		this.imagen = imagen;
	}
	public BigDecimal getSaldobanco() {
		return saldobanco;
	}
	public void setSaldobanco(BigDecimal saldobanco) {
		this.saldobanco = saldobanco;
	}
	public BigDecimal getSaldocash() {
		return saldocash;
	}
	public void setSaldocash(BigDecimal saldocash) {
		this.saldocash = saldocash;
	}
	public Boolean getVigente() {
		return vigente;
	}
	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}
	
	
	
}
