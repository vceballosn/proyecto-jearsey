package com.services.repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.services.modelo.Ubicacion;

public class RepositorioUbicacion {

	EntityManagerFactory emf;
	EntityManager em;
	public RepositorioUbicacion(){
		emf = Persistence.createEntityManagerFactory("test");
		em = emf.createEntityManager();
	}
	
	/**
	 * Guarda en la base de datos en la tabla ubicacion
	 * @param ubicacion
	 */
	public void salvar(Ubicacion ubicacion){
		em.getTransaction().begin();
		em.merge(ubicacion);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Eliminar en la base de datos en la tabla destino
	 * @param destino
	 */
	public void eliminar(Ubicacion ubicacion){
		em.getTransaction().begin();
		em.remove(ubicacion);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	/**
	 * Listar todos ubicacion
	 */
	
	@SuppressWarnings("unchecked")
	public List<Ubicacion> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select ubicacion from Ubicacion ubicacion");
		List<Ubicacion> ubicaciones = consulta.getResultList();
		emf.close();
		return ubicaciones;
	}
	
	/*
	 * Buscar por id
	 */
	
	public Ubicacion objetoId(long id){
		em.getTransaction().begin();
		Ubicacion ubicacion = em.find(Ubicacion.class, id);
		em.getTransaction().commit();
		return ubicacion;
	}

}
