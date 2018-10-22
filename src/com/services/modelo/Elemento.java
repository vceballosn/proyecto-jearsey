package com.services.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catelementos")
public class Elemento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int idElemento;
	
	@Column(name="idTipoElemento")
    private int idTipoElemento;
	
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
   
    @Column(name="url")
    private String direccionUrl;
    
    @Column(name="fechaCreacion")
    private Date fechaCreacion;
    
    @Column(name="fechaCaducidad")
    private Date fechaCaducidad;
    
    @Column(name="estatus")
    private int estatus;

	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public int getIdTipoElemento() {
		return idTipoElemento;
	}

	public void setIdTipoElemento(int idTipoElemento) {
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

	public String getDireccionUrl() {
		return direccionUrl;
	}

	public void setDireccionUrl(String direccionUrl) {
		this.direccionUrl = direccionUrl;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

}
