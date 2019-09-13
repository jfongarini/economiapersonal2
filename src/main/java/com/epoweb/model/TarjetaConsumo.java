package com.epoweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class TarjetaConsumo {

	private int id;
	private Integer personaId;
	private String nombre;
	private BigDecimal monto;
	private Integer cuotas;
	private Date fechapri;
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
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	public Date getFechapri() {
		return fechapri;
	}
	public void setFechapri(Date fechapri) {
		this.fechapri = fechapri;
	}
	
}
