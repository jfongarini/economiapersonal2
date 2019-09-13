package com.epoweb.model;

import java.math.BigDecimal;
import java.util.Date;

public class InversionDiario {

	private int id;
	private Integer personaId;
	private Integer inversionId;
	private Date fecha;
	private BigDecimal monto;
	private String detalle;
	private BigDecimal ganancia;
	private Date fechafin;
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
	public Integer getInversionId() {
		return inversionId;
	}
	public void setInversionId(Integer inversionId) {
		this.inversionId = inversionId;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public BigDecimal getGanancia() {
		return ganancia;
	}
	public void setGanancia(BigDecimal ganancia) {
		this.ganancia = ganancia;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	
	
}
