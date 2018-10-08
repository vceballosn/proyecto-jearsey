package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.Ubicacion;
import com.services.repositorio.RepositorioUbicacion;

@Path("/getJsonUbicacion")
public class ServicesJsonUbicacion {

	
	
	@GET
    @Path("/incluir/{nombre}/{descripcion}/{estatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ubicacion incluirUbicacion( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") int estatus ) {
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setNombre(nombre);
        ubicacion.setDescripcion(descripcion);
        ubicacion.setEstatus(estatus);
        RepositorioUbicacion repositorioUbicacion = new RepositorioUbicacion();
        repositorioUbicacion.salvar(ubicacion);
        return ubicacion;
    }
	
	@GET
    @Path("/modificar/{id}/{nombre}/{descripcion}/{estatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ubicacion modificarUbicacion( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") int estatus ) {
		RepositorioUbicacion repositorioUbicacion = new RepositorioUbicacion();
		Ubicacion ubicacion = repositorioUbicacion.objetoId(id);
		ubicacion.setNombre(nombre);
        ubicacion.setDescripcion(descripcion);
        ubicacion.setEstatus(estatus);
        repositorioUbicacion.salvar(ubicacion);
        return ubicacion;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Ubicacion eliminarUbicacion( @PathParam("id") long id ) {
		RepositorioUbicacion repositorioUbicacion = new RepositorioUbicacion();
		Ubicacion ubicacion = repositorioUbicacion.objetoId(id);
        repositorioUbicacion.eliminar(ubicacion);
        return ubicacion;
    }

	
	@GET
    @Path("/getUbicacion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ubicacion> obtenerDestino() {
		RepositorioUbicacion repositorioUbicacion = new RepositorioUbicacion();
		List<Ubicacion> ubicaciones = repositorioUbicacion.listarTodos();
      return ubicaciones;
      
    }
	

}
