package com.services.rest;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.Curso;
import com.services.modelo.Destino;
import com.services.modelo.Filtro;
import com.services.repositorio.RepositorioCurso;
import com.services.repositorio.RepositorioDestino;
import com.services.repositorio.RepositorioFiltro;
import com.services.utilidad.Utilidad;


@Path("/getJsonFiltro")
public class ServiceJsonFiltro {

	@GET
    @Path("/incluir/{nombre}/{descripcion}/{estatus}/{valorMinimo}/{valorMaximo}/{fechaCreacion}/{fechaCaducidad}/{idCatTipoFiltro}/{idElementoVersion}/{idDestino}/{idTipoValor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Filtro incluirCurso( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") boolean estatus,@PathParam("valorMinimo") Float valorMinimo, 
    		@PathParam("valorMaximo") Float valorMaximo,@PathParam("fechaCreacion") String fechaCreacion,@PathParam("fechaCaducidad") String fechaCaducidad,@PathParam("idCatTipoFiltro") long idCatTipoFiltro,
    		@PathParam("idElementoVersion") long idElementoVersion,@PathParam("idDestino") long idDestino, @PathParam("idTipoValor") long idTipoValor) {
        
		Filtro filtro = new Filtro();
		filtro.setNombre(nombre);
		filtro.setDescripcion(descripcion);
		filtro.setEstatus(estatus);
		filtro.setValorMaximo(valorMaximo);
		filtro.setValorMinimo(valorMinimo);
	    filtro.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
	    filtro.setFechaCaducidad(Utilidad.ParseFecha(fechaCaducidad));
	    filtro.setIdCatTipoFiltro(idCatTipoFiltro);
	    filtro.setIdElementoVersion(idElementoVersion);
	    filtro.setIdDestino(idDestino);
	    filtro.setIdTipoValor(idTipoValor);
        RepositorioFiltro repositorio = new RepositorioFiltro();
        repositorio.salvar(filtro);
        return filtro;
    }
	
	
	@GET
    @Path("/modificar/{id}/{nombre}/{descripcion}/{estatus}/{valorMinimo}/{valorMaximo}/{fechaCreacion}/{fechaCaducidad}/{idCatTipoFiltro}/{idElementoVersion}/{idDestino}/{idTipoValor}")
    @Produces(MediaType.APPLICATION_JSON)
    public Filtro modificarCurso(@PathParam("id") long id, @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") boolean estatus,@PathParam("valorMinimo") Float valorMinimo, 
    		@PathParam("valorMaximo") Float valorMaximo,@PathParam("fechaCreacion") String fechaCreacion,@PathParam("fechaCaducidad") String fechaCaducidad,@PathParam("idCatTipoFiltro") long idCatTipoFiltro,
    		@PathParam("idElementoVersion") long idElementoVersion,@PathParam("idDestino") long idDestino, @PathParam("idTipoValor") long idTipoValor) {
        
		RepositorioFiltro repositorio = new RepositorioFiltro();
		Filtro filtro = repositorio.objetoId(id);
		filtro.setNombre(nombre);
		filtro.setDescripcion(descripcion);
		filtro.setEstatus(estatus);
		filtro.setValorMaximo(valorMaximo);
		filtro.setValorMinimo(valorMinimo);
	    filtro.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
	    filtro.setFechaCaducidad(Utilidad.ParseFecha(fechaCaducidad));
	    filtro.setIdCatTipoFiltro(idCatTipoFiltro);
	    filtro.setIdElementoVersion(idElementoVersion);
	    filtro.setIdDestino(idDestino);
	    filtro.setIdTipoValor(idTipoValor);
        repositorio.salvar(filtro);
        return filtro;
    }
	
	
	
	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Filtro eliminarDestino( @PathParam("id") long id ) {
		Filtro filtro = new Filtro();
		RepositorioFiltro repositorio = new RepositorioFiltro();
		filtro = repositorio.objetoId(id);
        repositorio.eliminar(filtro);
        return filtro;
    }

	
	@GET
    @Path("/getFiltro")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Filtro> obtenerDestino() {
		Filtro filtro = new Filtro();
		RepositorioFiltro repositorio = new RepositorioFiltro();
		List<Filtro> filtros = repositorio.listarTodos();
      return filtros;
      
    }
}
