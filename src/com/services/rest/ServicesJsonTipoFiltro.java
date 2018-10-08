package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.TipoFiltro;
import com.services.repositorio.RepositorioTipoFiltro;
import com.services.utilidad.Utilidad;


@Path("/getJsonTipoFiltro")
public class ServicesJsonTipoFiltro {

	@GET
    @Path("/incluir/{nombre}/{estatus}/{fechaCreacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoFiltro incluirCurso( @PathParam("nombre") String nombre,@PathParam("estatus") boolean estatus, @PathParam("fechaCreacion") String fechaCreacion) {
        
		TipoFiltro tipoFiltro = new TipoFiltro();
		tipoFiltro.setNombre(nombre);
		tipoFiltro.setEstatus(estatus);
		tipoFiltro.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
        RepositorioTipoFiltro  repositorio = new RepositorioTipoFiltro();
        repositorio.salvar(tipoFiltro);
        return tipoFiltro;
    }
	
	@GET
    @Path("/modificar/{id}/{nombre}/{estatus}/{fechaCreacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoFiltro modificarCurso( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("estatus") boolean estatus, @PathParam("fechaCreacion") String fechaCreacion ) {
		TipoFiltro tipoFiltro = new TipoFiltro();
		RepositorioTipoFiltro  repositorio = new RepositorioTipoFiltro();
		tipoFiltro = repositorio.objetoId(id);
		tipoFiltro.setNombre(nombre);
		tipoFiltro.setEstatus(estatus);
		tipoFiltro.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
        repositorio.salvar(tipoFiltro);
        return tipoFiltro;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoFiltro eliminarDestino( @PathParam("id") long id ) {
		TipoFiltro tipoFiltro = new TipoFiltro();
		RepositorioTipoFiltro repositorio = new RepositorioTipoFiltro();
		tipoFiltro = repositorio.objetoId(id);
        repositorio.eliminar(tipoFiltro);
        return tipoFiltro;
    }

	
	@GET
    @Path("/getTipoFiltro")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<TipoFiltro> obtenerDestino() {
		TipoFiltro tipoFiltro = new TipoFiltro();
		RepositorioTipoFiltro repositorio = new RepositorioTipoFiltro();
		List<TipoFiltro> tipoFiltros = repositorio.listarTodos();
      return tipoFiltros;
      
    }

	
}
