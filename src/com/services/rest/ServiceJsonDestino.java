package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.Destino;
import com.services.repositorio.RepositorioDestino;



@Path("/getJsonDestino")
public class ServiceJsonDestino {
	
	
	@GET
    @Path("/incluir/{nombre}/{descripcion}/{estatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public Destino incluirDestino( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") boolean estatus ) {
        Destino destino = new Destino();
        destino.setNombre(nombre);
        destino.setDescripcion(descripcion);
        destino.setEstatus(estatus);
        RepositorioDestino repositorioDestino = new RepositorioDestino();
        repositorioDestino.salvar(destino);
        return destino;
    }
	
	@GET
    @Path("/modificar/{id}/{nombre}/{descripcion}/{estatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public Destino modificarDestino( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") boolean estatus ) {
		RepositorioDestino repositorioDestino = new RepositorioDestino();
		Destino destino = repositorioDestino.objetoId(id);
		destino.setNombre(nombre);
        destino.setDescripcion(descripcion);
        destino.setEstatus(estatus);
        repositorioDestino.salvar(destino);
        return destino;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Destino eliminarDestino( @PathParam("id") long id ) {
		RepositorioDestino repositorioDestino = new RepositorioDestino();
		Destino destino = repositorioDestino.objetoId(id);
        repositorioDestino.eliminar(destino);
        return destino;
    }

	
	@GET
    @Path("/getDestino")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Destino> obtenerDestino() {
		RepositorioDestino repositorioDestino = new RepositorioDestino();
		List<Destino> destino = repositorioDestino.listarTodos();
      return destino;
      
    }
	

}
