package com.services.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="catUbicacion")
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUbicacion;

	@Column(name="nombre")
	private String nombre;


	@Column(name="descripcion")
	private String descripcion;

	@Column(name="estatus")
	private int estatus;

	public long getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(long idUbicacion) {
		this.idUbicacion = idUbicacion;
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

	public int isEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

}
