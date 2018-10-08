package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.Funcion;

public class RepositorioFuncion {

	EntityManagerFactory emf;
	EntityManager em;
	
	public RepositorioFuncion(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	/**
	 * Guarda en la base de datos en la tabla funcion
	 * @param funcion
	 */
	public void salvar(Funcion funcion){
		em.getTransaction().begin();
		em.merge(funcion);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla funcion
	 * @param funcion
	 */
	public void eliminar(Funcion funcion){
		em.getTransaction().begin();
		em.remove(funcion);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos
	 * @param funcion
	 */
	
	@SuppressWarnings("unchecked")
	public List<Funcion> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select funcion from Funcion funcion");
		List<Funcion> funciones = consulta.getResultList();
		emf.close();
		return funciones;
	}
	
	/*
	 * Buscar por id
	 */
	
	public Funcion objetoId(long id){
		em.getTransaction().begin();
		Funcion funcion = em.find(Funcion.class, id);
		em.getTransaction().commit();
		return funcion;
	}
}
