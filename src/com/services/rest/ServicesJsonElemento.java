package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.services.modelo.Elemento;
import com.services.repositorio.RepositorioElemento;
import com.services.utilidad.Utilidad;

@Path("/getJsonElemento")
public class ServicesJsonElemento {

	@GET
    @Path("/incluir")
    @Produces(MediaType.APPLICATION_JSON)
    public Elemento incluirCurso( @QueryParam("nombre") String nombre,@QueryParam("descripcion") String descripcion,@QueryParam("direccionUrl") String direccionUrl,@QueryParam("estatus") int estatus, @QueryParam("fechaCreacion") String fechaCreacion ,@QueryParam("fechaCaducidad") String  fechaCaducidad,@QueryParam("idTipoElemento") int idTipoElemento) {
        
		Elemento elemento = new Elemento();
		elemento.setNombre(nombre);
		elemento.setDescripcion(descripcion);
		elemento.setDireccionUrl(direccionUrl);
		elemento.setEstatus(estatus);
		elemento.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
		elemento.setFechaCaducidad(Utilidad.ParseFecha(fechaCaducidad));
		elemento.setIdTipoElemento(idTipoElemento);
        RepositorioElemento repositorio = new RepositorioElemento();
        repositorio.salvar(elemento);
        return elemento;
    }
	
	@GET
    @Path("/modificar")
    @Produces(MediaType.APPLICATION_JSON)
    public Elemento modificarElemento( @QueryParam("id") int id,@QueryParam("nombre") String nombre,@QueryParam("descripcion") String descripcion,@QueryParam("direccionUrl") String direccionUrl,@QueryParam("estatus") int estatus, @QueryParam("fechaCreacion") String fechaCreacion ,@QueryParam("fechaCaducidad") String  fechaCaducidad,@QueryParam("idTipoElemento") int idTipoElemento) {
		Elemento elemento = new Elemento();
		RepositorioElemento repositorio = new RepositorioElemento();
		elemento = repositorio.objetoId(id);
		elemento.setNombre(nombre);
		elemento.setDescripcion(descripcion);
		elemento.setDireccionUrl(direccionUrl);
		elemento.setEstatus(estatus);
		elemento.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
		elemento.setFechaCaducidad(Utilidad.ParseFecha(fechaCaducidad));
		elemento.setIdTipoElemento(idTipoElemento);
        repositorio.salvar(elemento);
        return elemento;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Elemento eliminarDestino( @PathParam("id") int id ) {
		Elemento elemento = new Elemento();
		RepositorioElemento repositorio = new RepositorioElemento();
		elemento = repositorio.objetoId(id);
        repositorio.eliminar(elemento);
        return elemento;
    }

	
	@GET
    @Path("/getElemento")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Elemento> obtenerDestino() {
		Elemento elemento = new Elemento();
		RepositorioElemento repositorio = new RepositorioElemento();
		List<Elemento> elementos = repositorio.listarTodos();
      return elementos;
      
    }

	
	
	
}
