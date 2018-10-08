package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.Curso;

public class RepositorioCurso {
	
	EntityManagerFactory emf;
	EntityManager em;
	public RepositorioCurso(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	
	/**
	 * Guarda en la base de datos en la tabla curso
	 * @param destino
	 */
	public void salvar(Curso curso){
		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla destino
	 * @param destino
	 */
	public void eliminar(Curso curso){
		em.getTransaction().begin();
		em.remove(curso);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos cursos
	 * 
	 */
	
	@SuppressWarnings("unchecked")
	public List<Curso> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select curso from Curso curso");
		List<Curso> cursos = consulta.getResultList();
		emf.close();
		return cursos;
	}
	
	/*
	 * Buscar por id
	 */
	
	public Curso objetoId(long id){
		em.getTransaction().begin();
		Curso curso = em.find(Curso.class, id);
		em.getTransaction().commit();
		return curso;
	}


}
