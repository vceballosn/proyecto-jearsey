package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.Elemento;
import com.services.repositorio.RepositorioElemento;
import com.services.utilidad.Utilidad;

@Path("/getJsonElemento")
public class ServicesJsonElemento {

	@GET
    @Path("/incluir/{nombre}/{descripcion}/{direccionUrl}/{estatus}/{fechaCreacion}/{fechaCaducidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Elemento incluirCurso( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("direccionUrl") String direccionUrl,@PathParam("estatus") int estatus, @PathParam("fechaCreacion") String fechaCreacion ,@PathParam("fechaCaducidad") String  fechaCaducidad) {
        
		Elemento elemento = new Elemento();
		elemento.setNombre(nombre);
		elemento.setDescripcion(descripcion);
		elemento.setDireccionUrl(direccionUrl);
		elemento.setEstatus(estatus);
		elemento.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
		elemento.setFechaCaducidad(Utilidad.ParseFecha(fechaCaducidad));
        RepositorioElemento repositorio = new RepositorioElemento();
        repositorio.salvar(elemento);
        return elemento;
    }
	
	@GET
    @Path("/modificar/{id}{nombre}/{descripcion}/{direccionUrl}/{estatus}/{fechaCreacion}/{fechaCaducidad}")
    @Produces(MediaType.APPLICATION_JSON)
    public Elemento modificarElemento( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("direccionUrl") String direccionUrl,@PathParam("estatus") int estatus, @PathParam("fechaCreacion") String fechaCreacion ,@PathParam("fechaCaducidad") String  fechaCaducidad) {
		Elemento elemento = new Elemento();
		RepositorioElemento repositorio = new RepositorioElemento();
		elemento = repositorio.objetoId(id);
		elemento.setNombre(nombre);
		elemento.setDescripcion(descripcion);
		elemento.setDireccionUrl(direccionUrl);
		elemento.setEstatus(estatus);
		elemento.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
		elemento.setFechaCaducidad(Utilidad.ParseFecha(fechaCaducidad));
        repositorio.salvar(elemento);
        return elemento;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Elemento eliminarDestino( @PathParam("id") long id ) {
		Elemento elemento = new Elemento();
		RepositorioElemento repositorio = new RepositorioElemento();
		elemento = repositorio.objetoId(id);
        repositorio.eliminar(elemento);
        return elemento;
    }

	
	@GET
    @Path("/getCursos")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Elemento> obtenerDestino() {
		Elemento elemento = new Elemento();
		RepositorioElemento repositorio = new RepositorioElemento();
		List<Elemento> elementos = repositorio.listarTodos();
      return elementos;
      
    }

	
	
	
}
