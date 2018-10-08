package com.services.modelo;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="catFiltro")
public class Filtro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFiltro;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="estatus")
	private boolean estatus;
	
	@Column(name="valorMinimo")   
	private Float valorMinimo;
	
	@Column(name="valorMaximo")
    private Float valorMaximo;
	
	@Column(name="fechaCreacion")
    private Date fechaCreacion;
	
	@Column(name="fechaCaducidad")
    private Date fechaCaducidad;
	
	@Column(name="idCatTipoFiltro")
    private Long idCatTipoFiltro;
	
	@Column(name="idElementoVersion")
    private Long idElementoVersion;
	
	@Column(name="idDestino")
    private Long idDestino;
	
	@Column(name="idTipoValor")
	private Long idTipoValor;
	
	public Long getIdTipoValor() {
		return idTipoValor;
	}

	public void setIdTipoValor(Long idTipoValor) {
		this.idTipoValor = idTipoValor;
	}

	public long getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(long idFiltro) {
		this.idFiltro = idFiltro;
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

	public Float getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(Float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Float getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(Float valorMaximo) {
		this.valorMaximo = valorMaximo;
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

	public Long getIdCatTipoFiltro() {
		return idCatTipoFiltro;
	}

	public void setIdCatTipoFiltro(Long idCatTipoFiltro) {
		this.idCatTipoFiltro = idCatTipoFiltro;
	}

	public Long getIdElementoVersion() {
		return idElementoVersion;
	}

	public void setIdElementoVersion(Long idElementoVersion) {
		this.idElementoVersion = idElementoVersion;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}

	

}
