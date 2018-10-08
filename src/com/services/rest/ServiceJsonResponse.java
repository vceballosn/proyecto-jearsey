package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.services.bean.User;
import com.services.modelo.Funcion;
import com.services.modelo.Destino;
import com.services.repositorio.RepositorioFuncion;
import com.services.repositorio.RepositorioDestino;


@Path("/getResponseJson")
public class ServiceJsonResponse {

	
	@Path("/getJson")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response  getUserAsJson(@Context HttpHeaders httpHeaders) {
		User user = new User("vladimir","Ceballos");
		return Response.ok(user).build();
 
	}
	
	@GET
    @Path("/incluir/{nombre}/{descripcion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcion produceJSON( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion ) {
        Funcion funcion = new Funcion();
        funcion.setNombre(nombre);
        funcion.setDescripcion(descripcion);
        RepositorioFuncion RepositorioFuncion = new RepositorioFuncion();
        RepositorioFuncion.salvar(funcion);
        return funcion;
    }
	
	@GET
    @Path("/modificar/{id}/{nombre}/{descripcion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcion produceModificar( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion ) {
		RepositorioFuncion RepositorioFuncion = new RepositorioFuncion();
		Funcion funcion = RepositorioFuncion.objetoId(id);
		funcion.setNombre(nombre);
        funcion.setDescripcion(descripcion);
        RepositorioFuncion.salvar(funcion);
        return funcion;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcion produceEliminar( @PathParam("id") long id ) {
		RepositorioFuncion RepositorioFuncion = new RepositorioFuncion();
		Funcion funcion = RepositorioFuncion.objetoId(id);
        RepositorioFuncion.eliminar(funcion);
        return funcion;
    }

	
	@GET
    @Path("/getFunciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Funcion> obtenerFunciones() {
		RepositorioFuncion RepositorioFuncion = new RepositorioFuncion();
		List<Funcion> funciones = RepositorioFuncion.listarTodos();
      return funciones;
      
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
