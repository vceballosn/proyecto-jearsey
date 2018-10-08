package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.modelo.Curso;
import com.services.repositorio.RepositorioCurso;
import com.services.utilidad.Utilidad;



@Path("/getJsonCurso")
public class ServiceJsonCurso {
	

	@GET
    @Path("/incluir/{nombre}/{descripcion}/{estatus}/{fechaCreacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Curso incluirCurso( @PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") int estatus, @PathParam("fechaCreacion") String fechaCreacion) {
        
		Curso curso = new Curso();
		curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setEstatus(estatus);
        curso.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
        RepositorioCurso repositorio = new RepositorioCurso();
        repositorio.salvar(curso);
        return curso;
    }
	
	@GET
    @Path("/modificar/{id}/{nombre}/{descripcion}/{estatus}/{fechaCreacion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Curso modificarCurso( @PathParam("id") long id,@PathParam("nombre") String nombre,@PathParam("descripcion") String descripcion,@PathParam("estatus") int estatus, @PathParam("fechaCreacion") String fechaCreacion ) {
		Curso curso = new Curso();
		RepositorioCurso repositorio = new RepositorioCurso();
		curso = repositorio.objetoId(id);
		curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setEstatus(estatus);
        curso.setFechaCreacion(Utilidad.ParseFecha(fechaCreacion));
        repositorio.salvar(curso);
        return curso;
    }
	

	@GET
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Curso eliminarDestino( @PathParam("id") long id ) {
		Curso curso = new Curso();
		RepositorioCurso repositorio = new RepositorioCurso();
		curso = repositorio.objetoId(id);
        repositorio.eliminar(curso);
        return curso;
    }

	
	@GET
    @Path("/getCursos")
    @Produces(MediaType.APPLICATION_JSON) 
    public List<Curso> obtenerDestino() {
		Curso curso = new Curso();
		RepositorioCurso repositorio = new RepositorioCurso();
		List<Curso> cursos = repositorio.listarTodos();
      return cursos;
      
    }

}
