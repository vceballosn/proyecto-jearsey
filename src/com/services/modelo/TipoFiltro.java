package com.services.modelo;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="catTipoFiltro")
public class TipoFiltro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCatTipoFiltro;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fechaCreacion")
    private Date fechaCreacion;


	@Column(name="estatus")
	private boolean estatus;


	public long getIdTipoFiltro() {
		return idCatTipoFiltro;
	}


	public void setIdTipoFiltro(long idCatTipoFiltro) {
		this.idCatTipoFiltro = idCatTipoFiltro;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public boolean isEstatus() {
		return estatus;
	}


	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
	
	
}
