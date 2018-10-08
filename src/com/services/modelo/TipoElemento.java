package com.services.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="catTipoElemento")
public class TipoElemento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTipoElemento;

	@Column(name="nombre")
	private String nombre;


	@Column(name="descripcion")
	private String descripcion;

	@Column(name="estatus")
	private boolean estatus;

	public long getIdTipoElemento() {
		return idTipoElemento;
	}

	public void setIdTipoElemento(long idTipoElemento) {
		this.idTipoElemento = idTipoElemento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	
}
