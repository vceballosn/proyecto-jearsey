package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.TipoElemento;
import com.services.repositorio.RepositorioTipoElemento;


@Path("/getJsonTipoElemento")
public class ServicesJsonTipoElemento {
	
	@GET
    @Path("/incluir/{nombre}/{descripcion}/{estatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoElemento incluirTipoEelemento( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") boolean estatus ) {
        TipoElemento tipoElemento = new TipoElemento();
        tipoElemento.setNombre(nombre);
        tipoElemento.setDescripcion(descripcion);
        tipoElemento.setEstatus(estatus);
        RepositorioTipoElemento repositorioTipoElemento = new RepositorioTipoElemento();
        repositorioTipoElemento.salvar(tipoElemento);
        return tipoElemento;
    }
	
	@GET
    @Path("/modificar/{id}/{nombre}/{descripcion}/{estatus}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoElemento modificarDestino( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") boolean estatus ) {
		RepositorioTipoElemento repositorioTipoElemento = new RepositorioTipoElemento();
		TipoElemento tipoElemento = repositorioTipoElemento.objetoId(id);
		tipoElemento.setNombre(nombre);
		tipoElemento.setDescripcion(descripcion);
		tipoElemento.setEstatus(estatus);
		repositorioTipoElemento.salvar(tipoElemento);
        return tipoElemento;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoElemento eliminarDestino( @PathParam("id") long id ) {
		RepositorioTipoElemento repositorioTipoElemento = new RepositorioTipoElemento();
		TipoElemento tipoElemento = repositorioTipoElemento.objetoId(id);
		repositorioTipoElemento.eliminar(tipoElemento);
        return tipoElemento;
    }

	
	@GET
    @Path("/getTipoElemento")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoElemento> obtenerDestino() {
		RepositorioTipoElemento repositorioTipoElemento = new RepositorioTipoElemento();
		List<TipoElemento> tipoElemento = repositorioTipoElemento.listarTodos();
      return tipoElemento;
      
    }
	

}
